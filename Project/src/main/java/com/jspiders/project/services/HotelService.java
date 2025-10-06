package com.jspiders.project.services;

import com.jspiders.project.data.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    public ResponseEntity<CommonResponse> getAllHotelsWithRooms(){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setMessage("resposne from getAllHotelsWithRooms");
        commonResponse.setHttpStatus(HttpStatus.OK);
        commonResponse.setSuccess(true);
        commonResponse.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(commonResponse);
    }
}
