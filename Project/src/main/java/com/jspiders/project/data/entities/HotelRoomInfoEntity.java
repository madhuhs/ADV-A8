package com.jspiders.project.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_room_info")
public class HotelRoomInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private String roomType;
    private Integer maxGuestAllowed;
    private Integer maxAdultAllowed;
    private Integer maxChildrenAllowed;
    private Double roomRate;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelInfoEntity hotelInfoEntity;

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getMaxGuestAllowed() {
        return maxGuestAllowed;
    }

    public void setMaxGuestAllowed(Integer maxGuestAllowed) {
        this.maxGuestAllowed = maxGuestAllowed;
    }

    public Integer getMaxAdultAllowed() {
        return maxAdultAllowed;
    }

    public void setMaxAdultAllowed(Integer maxAdultAllowed) {
        this.maxAdultAllowed = maxAdultAllowed;
    }

    public Integer getMaxChildrenAllowed() {
        return maxChildrenAllowed;
    }

    public void setMaxChildrenAllowed(Integer maxChildrenAllowed) {
        this.maxChildrenAllowed = maxChildrenAllowed;
    }

    public Double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }
}
