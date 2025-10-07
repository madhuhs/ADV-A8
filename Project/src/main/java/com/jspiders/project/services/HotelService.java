package com.jspiders.project.services;

import com.jspiders.project.data.dto.CommonResponse;
import com.jspiders.project.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class HotelService {
    public ResponseEntity<CommonResponse> getAllHotelsWithRooms(){
        ResponseEntity<CommonResponse> response =
                ResponseUtil.getOkResponse("this is getAllHotelsWithRooms()",null);
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
