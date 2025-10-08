package com.jspiders.project.data.repositories;

import com.jspiders.project.data.entities.HotelContactInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelContactInfoRepository
        extends JpaRepository<HotelContactInfoEntity,Long> {
    Optional<HotelContactInfoEntity> findByHotelId(Long hotelId);
}
