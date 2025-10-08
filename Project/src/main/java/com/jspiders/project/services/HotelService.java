package com.jspiders.project.services;

import com.jspiders.project.data.dto.CommonResponse;
import com.jspiders.project.data.entities.HotelContactInfoEntity;
import com.jspiders.project.data.entities.HotelInfoEntity;
import com.jspiders.project.data.repositories.HotelContactInfoRepository;
import com.jspiders.project.data.repositories.HotelInfoRepository;
import com.jspiders.project.utils.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class HotelService {
    private final HotelInfoRepository hotelInfoRepository;
    private final HotelContactInfoRepository hotelContactInfoRepository;

    @Autowired
    public HotelService(HotelInfoRepository hotelInfoRepository,
                        HotelContactInfoRepository hotelContactInfoRepository) {

        this.hotelInfoRepository = hotelInfoRepository;
        this.hotelContactInfoRepository = hotelContactInfoRepository;
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

//    public ResponseEntity<CommonResponse> getContactByHotelId(Long hotelId)
//    {
//
//        Optional<HotelContactInfoEntity> hotelContactInfoEntityOptional =
//                hotelContactInfoRepository.findByHotelId(hotelId);
//
//        if(hotelContactInfoEntityOptional.isEmpty()) {
//            return ResponseUtil.getErrorResponse("No contact Info", null);
//        }
//
//        HotelContactInfoEntity hotelContactInfoEntity =hotelContactInfoEntityOptional.get();
//
//        return ResponseUtil.
//                getOkResponse(hotelContactInfoEntity.getCity(), hotelContactInfoEntity);
//
//    }

    public ResponseEntity<CommonResponse> getContactByHotelId(Long hotelId)
    {

        Optional<HotelContactInfoEntity> hotelContactInfoEntityOptional =
                hotelContactInfoRepository.findByHotelId(hotelId);

        if(!hotelContactInfoEntityOptional.isEmpty()) {
            HotelContactInfoEntity hotelContactInfoEntity =hotelContactInfoEntityOptional.get();
            return ResponseUtil.
                    getOkResponse(hotelContactInfoEntity.getCity(), hotelContactInfoEntity);
        }
        throw new NoSuchElementException("No contact info found");
    }
}
