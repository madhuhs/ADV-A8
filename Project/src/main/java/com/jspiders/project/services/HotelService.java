package com.jspiders.project.services;

import com.jspiders.project.data.dto.CommonResponse;
import com.jspiders.project.data.entities.HotelInfoEntity;
import com.jspiders.project.data.repositories.HotelInfoRepository;
import com.jspiders.project.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class HotelService {

    private final HotelInfoRepository hotelInfoRepository;

    @Autowired
    public HotelService(HotelInfoRepository hotelInfoRepository) {
        this.hotelInfoRepository = hotelInfoRepository;
    }

    public ResponseEntity<CommonResponse> getAllHotelsWithRooms(){
       List<HotelInfoEntity> hotelInfoEntities = hotelInfoRepository.findAll();
        ResponseEntity<CommonResponse> response =
                ResponseUtil.getOkResponse("No of hotels : "+hotelInfoEntities.size(),hotelInfoEntities);
        return response;
    }


    public ResponseEntity<CommonResponse> getHotelsWithRooms(){
     return ResponseUtil.getOkResponse("this is getHotelsWithRooms()",null);
    }


    public ResponseEntity<CommonResponse> getImagesByHotelId(Long hotelId){
        return ResponseUtil.getOkResponse("this is getImagesByHotelId()",null);
    }


    public ResponseEntity<CommonResponse> getFacilitiesByHotelId(Long hotelId){
        return ResponseUtil.getOkResponse("this is getFacilitiesByHotelId()",null);
    }

    public ResponseEntity<CommonResponse> getContactByHotelId(Long hotelId){
        return ResponseUtil.getOkResponse("this is getContactByHotelId()",null);
    }
}
