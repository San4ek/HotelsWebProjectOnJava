package com.example.hotels.controllers;

import com.example.hotels.Converter.IdConverter;
import com.example.hotels.enums.Role;
import com.example.hotels.models.RoomType;
import com.example.hotels.services.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RoomTypeController {

    private final AppController appController;
    private final RoomTypeService roomTypeService;

    @GetMapping("/roomtypes")
    public String roomTypes(Model model) {
        model.addAttribute("roomtypes", roomTypeService.getRoomTypes());
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "roomtypes";
    }

    @PostMapping("/roomtype/delete/{id}")
    public String deleteRoomType(@PathVariable String id) {
        Long longId= IdConverter.convert(id);
        roomTypeService.deleteRoomType(longId);
        return "redirect:/roomtypes";
    }

    @GetMapping("/roomtype/create")
    public String createRoomType() {
        return "roomtype-create";
    }

    @PostMapping("/roomtype/add")
    public String addRoomType(RoomType roomType) {
        roomTypeService.saveRoomType(roomType);
        return "redirect:/roomtypes";
    }

    @GetMapping("/roomtype/{id}/edit")
    public String editRoomType(@PathVariable String id, Model model) {
        Long longId= IdConverter.convert(id);
        model.addAttribute("roomType", roomTypeService.getRoomType(longId));
        return "roomtype-edit";
    }

    @PostMapping("/roomtype/edit/{id}")
    public String roomTypeEdit(@PathVariable String id, RoomType roomType) {
        Long longId= IdConverter.convert(id);
        roomTypeService.editRoomType(longId, roomType);
        return "redirect:/roomtypes";
    }

    @GetMapping("/roomtype/{id}")
    public String roomType(@PathVariable String id, Model model) {
        Long longId= IdConverter.convert(id);
        model.addAttribute("roomType", roomTypeService.getRoomType(longId));
        model.addAttribute("user", appController.user);
        model.addAttribute("administrator", Role.ADMINISTRATOR);
        return "roomtype-info";
    }
}
