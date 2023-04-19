package com.Parley.Backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RestaurantResponse {

    private String id;
    private String name;
    private String imageUrl;
    private int reviewCount;
    private double rating;
    private String priceCategory;
    private double distance;


}
