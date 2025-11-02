package com.mamoon.project.airBnbApp.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;

@Getter
@Setter

public class RoomDto {

    private Long id;
    private String type;
    private BigDecimal basePrice;
    private String[] photos;
    private String[] amenities;
    private Integer totalCount;
    private Integer capacity;



    @Override
    public String toString() {
        return "RoomDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", basePrice=" + basePrice +
                ", photos=" + Arrays.toString(photos) +
                ", amenities=" + Arrays.toString(amenities) +
                ", totalCount=" + totalCount +
                ", capacity=" + capacity +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RoomDto roomDto)) return false;
        return Objects.equals(getId(), roomDto.getId()) && Objects.equals(getType(), roomDto.getType()) && Objects.equals(getBasePrice(), roomDto.getBasePrice()) && Objects.deepEquals(getPhotos(), roomDto.getPhotos()) && Objects.deepEquals(getAmenities(), roomDto.getAmenities()) && Objects.equals(getTotalCount(), roomDto.getTotalCount()) && Objects.equals(getCapacity(), roomDto.getCapacity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getType(), getBasePrice(), Arrays.hashCode(getPhotos()), Arrays.hashCode(getAmenities()), getTotalCount(), getCapacity());
    }



}
