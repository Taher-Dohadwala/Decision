package com.Parley.Backend.controllers;

import com.Parley.Backend.dto.RestaurantResponse;
import com.Parley.Backend.entities.Location;
import com.Parley.Backend.services.RestuarantService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/restaurant")
@AllArgsConstructor
public class RestaurantController {

    private final RestuarantService restuarantService;

    @GetMapping("/search")
    public ResponseEntity<String> searchRestaurants(@RequestBody Location location) {
        return restuarantService.searchRestaurants(location);
    }


}
