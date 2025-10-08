package com.jspiders.project.data.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel_info")
public class HotelInfoEntity {
    @Id//Mark this as Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long hotelId;
    @Column(name = "hotelname")
    private String hotelName;
    @Column(name = "thumbnail")
    private String thumbNail;
    @Column(name = "providerfamily")
    private String providerFamily;
    @Column(name = "propertytype")
    private String propertyType;
    @Column(name = "rating")
    private Double rating;

    @OneToOne(cascade = CascadeType.ALL,
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private HotelContactInfoEntity hotelContactInfo;

    public HotelContactInfoEntity getHotelContactInfo() {
        return hotelContactInfo;
    }

    public void setHotelContactInfo(HotelContactInfoEntity hotelContactInfo) {
        this.hotelContactInfo = hotelContactInfo;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public void setThumbNail(String thumbNail) {
        this.thumbNail = thumbNail;
    }

    public String getProviderFamily() {
        return providerFamily;
    }

    public void setProviderFamily(String providerFamily) {
        this.providerFamily = providerFamily;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
