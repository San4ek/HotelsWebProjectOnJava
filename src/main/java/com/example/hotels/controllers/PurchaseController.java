package com.example.hotels.controllers;

import com.example.hotels.Converter.IdConverter;
import com.example.hotels.enums.PurchaseStatus;
import com.example.hotels.enums.Role;
import com.example.hotels.models.Purchase;
import com.example.hotels.models.Service;
import com.example.hotels.services.PurchaseService;
import com.example.hotels.services.RoomService;
import com.example.hotels.services.ServiceService;
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
public class PurchaseController {

    private final PurchaseService purchaseService;
    private final AppController appController;
    private final RoomService roomService;
    private final ServiceService serviceService;

    @GetMapping("/purchases")
    public String purchases(Model model) {
        model.addAttribute("purchases", purchaseService.getPurchases(appController.user));
        model.addAttribute("user", appController.user);
        model.addAttribute("directorRole", Role.DIRECTOR);
        model.addAttribute("userRole", Role.USER);
        return "purchases";
    }

    @GetMapping("/purchase/{id}")
    public String company(@PathVariable String id, Model model){
        Long longId= IdConverter.convert(id);
        model.addAttribute("purchase", purchaseService.getPurchase(longId));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "purchase-info";
    }

    @PostMapping("/purchase/{id}/except")
    public String exceptPurchase(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        purchaseService.exceptPurchase(longId);
        return "redirect:/purchases";
    }

    @GetMapping("/purchase/{id}/edit")
    public String editPurchase(@PathVariable String id, Model model) {
        Long longId= IdConverter.convert(id);
        Purchase purchase = purchaseService.getPurchase(longId);
        model.addAttribute("purchase", purchase);
        model.addAttribute("rooms", roomService.getRoomsByHotelId(purchase.getHotel().getId()));
        return "purchase-edit";
    }

    @PostMapping("/purchase/{id}/edit")
    public String updatePurchase(@RequestParam(name = "services", required = false) String[] services, Model model, @PathVariable String id, Date startDate, Date endDate, String roomId) {
        Long purchaseId=IdConverter.convert(id);
        Purchase oldPurchase=purchaseService.getPurchase(purchaseId);
        List<Purchase> purchases = purchaseService.getPurchasesByRoomId(IdConverter.convert(roomId));
        if (!purchases.isEmpty()) {
            for (Purchase listPurchase : purchases) {
                if (!listPurchase.getPurchaseStatus().equals(PurchaseStatus.REJECT) &&
                        !listPurchase.getPurchaseStatus().equals(PurchaseStatus.EVICTED) &&
                        !listPurchase.getId().equals(purchaseId)) {
                    Date purchaseStartdate = listPurchase.getStartDate();
                    Date purchaseEndDate = listPurchase.getEndDate();
                    if (purchaseStartdate.after(startDate) && purchaseStartdate.before(endDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return editPurchase(String.valueOf(purchaseId), model);
                    }
                    if (purchaseEndDate.after(startDate) && purchaseEndDate.before(endDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return editPurchase(id, model);
                    }
                    if (purchaseEndDate.equals(endDate) ||
                            purchaseStartdate.equals(startDate) ||
                            purchaseEndDate.equals(startDate) ||
                            purchaseStartdate.equals(endDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return editPurchase(id, model);
                    }
                    if (startDate.after(purchaseStartdate) && startDate.before(purchaseEndDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return editPurchase(id, model);
                    }
                    if (endDate.after(purchaseStartdate) && endDate.before(purchaseEndDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return editPurchase(id, model);
                    }
                    if (endDate.before(startDate)) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return editPurchase(id, model);
                    }
                    if (endDate.before(Date.valueOf(LocalDate.now())) || startDate.before(Date.valueOf(LocalDate.now()))) {
                        model.addAttribute("errorMessage", "Не правильно указан промежуток времени");
                        return editPurchase(id, model);
                    }
                }
            }
        }

        int length=Math.abs(startDate.toLocalDate().getDayOfYear()-endDate.toLocalDate().getDayOfYear())+1;
        int cost=oldPurchase.getRoom().getRoomType().getCost()*length;
        if (services!=null) {
            List<Service> serviceList = new ArrayList<>();
            for (String arg : services) {
                Long longId= IdConverter.convert(arg);
                Service service = serviceService.getService(longId);
                serviceList.add(service);
                cost+=service.getCost()*length;
            }
            oldPurchase.setServices(serviceList);
        } else {
            oldPurchase.setServices(null);
        }
        oldPurchase.setRoom(roomService.getRoomById(IdConverter.convert(roomId)));
        oldPurchase.setStartDate(startDate);
        oldPurchase.setEndDate(endDate);
        oldPurchase.setCost(cost);
        purchaseService.savePurchase(oldPurchase);

        return "redirect:/purchases";
    }

    @PostMapping("/purchase/{id}/reject")
    public String rejectPurchase(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        purchaseService.rejectPurchase(longId);
        return "redirect:/purchases";
    }

    @PostMapping("/purchase/{id}/inhabited")
    public String inhabitPurchase(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        purchaseService.inhabitPurchase(longId);
        return "redirect:/purchases";
    }

    @PostMapping("/purchase/{id}/evicted")
    public String evictPurchase(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        purchaseService.evictPurchase(longId);
        return "redirect:/purchases";
    }
}
