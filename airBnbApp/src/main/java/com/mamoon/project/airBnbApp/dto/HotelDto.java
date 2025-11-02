package com.mamoon.project.airBnbApp.dto;

import com.mamoon.project.airBnbApp.entity.HotelContactInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter
public class HotelDto {

    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof HotelDto hotelDto)) return false;
        return Objects.equals(getId(), hotelDto.getId()) && Objects.equals(getName(), hotelDto.getName()) && Objects.equals(getCity(), hotelDto.getCity()) && Objects.deepEquals(getPhotos(), hotelDto.getPhotos()) && Objects.deepEquals(getAmenities(), hotelDto.getAmenities()) && Objects.equals(getContactInfo(), hotelDto.getContactInfo()) && Objects.equals(getActive(), hotelDto.getActive());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCity(), Arrays.hashCode(getPhotos()), Arrays.hashCode(getAmenities()), getContactInfo(), getActive());
    }



    @Override
    public String toString() {
        return "HotelDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", photos=" + Arrays.toString(photos) +
                ", amenities=" + Arrays.toString(amenities) +
                ", contactInfo=" + contactInfo +
                ", active=" + active +
                '}';
    }


}
