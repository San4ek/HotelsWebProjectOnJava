package com.example.hotels.controllers;

import com.example.hotels.enums.Role;
import com.example.hotels.enums.RoomStatus;
import com.example.hotels.models.Hotel;
import com.example.hotels.models.Purchase;
import com.example.hotels.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/hotels")
    public String hotels(Model model){
        model.addAttribute("user", appController.user);
        model.addAttribute("hotels",hotelService.getHotels());
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "hotels";
    }

    @GetMapping("/hotel/{id}")
    public String hotel(@PathVariable Long id, Model model){
        model.addAttribute("hotel",hotelService.getHotel(id));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        model.addAttribute("userRole", Role.USER);
        model.addAttribute("rooms", roomService.getRoomsByHotelIdAndRoomStatus(id, RoomStatus.EMPTY));
        return "hotel-info";
    }

    @PostMapping("/hotel/order/{hotelId}")
    public String orderHotel(@PathVariable Long hotelId, Long roomId) {
        Purchase purchase = purchaseService.createPurchase(appController.user, hotelId, roomId);
        purchaseService.savePurchase(purchase);
        return "redirect:/hotels";
    }

    @PostMapping("/hotel/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return "redirect:/hotels";
    }

    @GetMapping("/hotel/create")
    public String createHotel(Model model){
        model.addAttribute("companies", companyService.getCompanies());
        model.addAttribute("directors", userService.getDirectors());
        model.addAttribute("countries", countryService.getCountries());
        return "hotel-create";
    }

    @PostMapping("/hotel/add")
    public String addHotel(Hotel hotel) {
        hotelService.saveHotel(hotel);
        roomService.createRooms(hotel);
        return "redirect:/hotels";
    }

    @GetMapping("/hotel/{id}/edit")
    public String editHotel(@PathVariable Long id, Model model) {
        model.addAttribute("hotel", hotelService.getHotel(id));
        model.addAttribute("companies", companyService.getCompanies());
        model.addAttribute("directors", userService.getDirectors());
        model.addAttribute("countries", countryService.getCountries());
        return "hotel-edit";    }

    @PostMapping("/hotel/edit/{id}")
    public String editHotel(@PathVariable Long id, Hotel hotel) {
        hotelService.editHotel(id,hotel);
        return "redirect:/hotels";
    }
}
