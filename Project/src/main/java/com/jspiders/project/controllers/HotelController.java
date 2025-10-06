package com.jspiders.project.controllers;

import com.jspiders.project.data.dto.CommonResponse;
import com.jspiders.project.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired//constructor-injection
    public HotelController(HotelService hotelService){
        this.hotelService = hotelService;
    }

    @GetMapping("/rooms")
    public ResponseEntity<CommonResponse> getHotelsWithRooms(){
        return hotelService.getAllHotelsWithRooms();
    }

    @GetMapping("/{hotelId}/images")
    public ResponseEntity<CommonResponse> getImagesByHotelId(@PathVariable Long hotelId){
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{hotelId}/facilities")
    public ResponseEntity<CommonResponse> getFacilitiesByHotelId(@PathVariable Long hotelId){
        return ResponseEntity.ok(null);
    }
    @GetMapping("/{hotelId}/contact")
    public ResponseEntity<CommonResponse> getContactByHotelId(@PathVariable Long hotelId){
        return ResponseEntity.ok(null);
    }
}
