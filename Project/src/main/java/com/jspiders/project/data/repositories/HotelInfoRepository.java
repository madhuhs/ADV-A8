package com.jspiders.project.data.repositories;

import com.jspiders.project.data.entities.HotelInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelInfoRepository extends JpaRepository<HotelInfoEntity,Long> {
}
