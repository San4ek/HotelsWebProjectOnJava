package com.example.hotels.controllers;

import com.example.hotels.Converter.IdConverter;
import com.example.hotels.enums.PurchaseStatus;
import com.example.hotels.enums.Role;
import com.example.hotels.models.Hotel;
import com.example.hotels.models.Purchase;
import com.example.hotels.models.Service;
import com.example.hotels.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HotelController {
    private final PurchaseService purchaseService;
    private final HotelService hotelService;
    private final CompanyService companyService;
    private final AppController appController;
    private final CountryService countryService;
    private final UserService userService;
    private final RoomService roomService;
    private final ServiceService serviceService;
    private final RoomTypeService roomTypeService;

    @GetMapping("/hotels")
    public String hotels(Model model){
        model.addAttribute("user", appController.user);
        model.addAttribute("hotels",hotelService.getHotels());
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "hotels";
    }

    @GetMapping("/hotel/{id}")
    public String hotel(@PathVariable String id, Model model){
        Long longId= IdConverter.convert(id);
        model.addAttribute("hotel",hotelService.getHotel(longId));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        model.addAttribute("userRole", Role.USER);
        model.addAttribute("rooms", roomService.getRoomsByHotelId(longId));
        return "hotel-info";
    }

    @PostMapping("/hotel/order/{hotelId}")
    public String orderHotel(@RequestParam(name = "services", required = false) String[] services,  Model model, @PathVariable String hotelId, String roomId, Date startDate, Date endDate) {
        Long longHotelId= IdConverter.convert(hotelId);
        Long longRoomId= IdConverter.convert(roomId);
        List<Purchase> purchases = purchaseService.getPurchasesByRoomId(longRoomId);
        if (!purchases.isEmpty()) {
            for (Purchase purchase : purchases) {
                if (!purchase.getPurchaseStatus().equals(PurchaseStatus.REJECT) && !purchase.getPurchaseStatus().equals(PurchaseStatus.EVICTED)) {
                    Date purchaseStartdate = purchase.getStartDate();
                    Date purchaseEndDate = purchase.getEndDate();
                    if (purchaseStartdate.after(startDate) && purchaseStartdate.before(endDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return hotel(hotelId, model);
                    }
                    if (purchaseEndDate.after(startDate) && purchaseEndDate.before(endDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return hotel(hotelId, model);
                    }
                    if (purchaseEndDate.equals(endDate) ||
                            purchaseStartdate.equals(startDate) ||
                            purchaseEndDate.equals(startDate) ||
                            purchaseStartdate.equals(endDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return hotel(hotelId, model);
                    }
                    if (startDate.after(purchaseStartdate) && startDate.before(purchaseEndDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return hotel(hotelId, model);
                    }
                    if (endDate.after(purchaseStartdate) && endDate.before(purchaseEndDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return hotel(hotelId, model);
                    }
                    if (endDate.before(startDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return hotel(hotelId, model);
                    }
                    if (endDate.before(Date.valueOf(LocalDate.now())) || startDate.before(Date.valueOf(LocalDate.now()))) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return hotel(hotelId, model);
                    }
                }
            }
        }

        Purchase purchase = purchaseService.createPurchase(appController.user, longHotelId, longRoomId, startDate, endDate);
        int length=Math.abs(endDate.toLocalDate().getDayOfYear()-endDate.toLocalDate().getDayOfYear())+1;
        int  cost=purchase.getHotel().getRoomType().getCost()*length;
        if (services!=null) {
            List<Service> serviceList = new ArrayList<>();
            for (String arg : services) {
                Long longId= IdConverter.convert(arg);
                Service service = serviceService.getService(longId);
                serviceList.add(service);
                cost+=service.getCost()*length;
            }
            purchase.setServices(serviceList);
        }
        purchase.setCost(cost);
        purchaseService.savePurchase(purchase);

        return "redirect:/hotels";
    }

    @PostMapping("/hotel/delete/{id}")
    public String deleteHotel(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        hotelService.deleteHotel(longId);
        return "redirect:/hotels";
    }

    @GetMapping("/hotel/create")
    public String createHotel(Model model){
        model.addAttribute("companies", companyService.getCompanies());
        model.addAttribute("directors", userService.getDirectors());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("services", serviceService.getServices());
        model.addAttribute("roomTypes", roomTypeService.getRoomTypes());
        return "hotel-create";
    }

    @PostMapping("/hotel/add")
    public String addHotel(@RequestParam(value = "services", required = false) Long[] services, Hotel hotel) {
        if (services!=null) {
            List<Service> serviceList = new ArrayList<>();
            for (Long arg : services) {
                serviceList.add(serviceService.getService(arg));
            }
            hotel.setServices(serviceList);
        }
        hotelService.saveHotel(hotel);
        roomService.createRooms(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/hotel/{id}/edit")
    public String editHotel(@PathVariable String id, Model model) {
        Long longId= IdConverter.convert(id);
        model.addAttribute("hotel", hotelService.getHotel(longId));
        model.addAttribute("companies", companyService.getCompanies());
        model.addAttribute("directors", userService.getDirectors());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("roomTypes", roomTypeService.getRoomTypes());
        model.addAttribute("services", serviceService.getServices());
        return "hotel-edit";    }

    @PostMapping("/hotel/edit/{id}")
    public String editHotel(@RequestParam(name = "services", required = false) String[] services, @PathVariable Long id, Hotel hotel) {
        if (services!=null) {
            List<Service> serviceList = new ArrayList<>();
            for (String arg : services) {
                Long longId= IdConverter.convert(arg);
                serviceList.add(serviceService.getService(longId));
            }
            hotel.setServices(serviceList);
        }
        hotelService.editHotel(id,hotel);
        return "redirect:/hotels";
    }
}
