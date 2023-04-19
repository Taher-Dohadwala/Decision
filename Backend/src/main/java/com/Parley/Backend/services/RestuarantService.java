package com.Parley.Backend.services;


import com.Parley.Backend.dto.RestaurantResponse;
import com.Parley.Backend.entities.Location;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import org.springframework.http.HttpHeaders;
import java.util.Map;

@Service
@AllArgsConstructor
public class RestuarantService {


    public ResponseEntity<String> searchRestaurants(Location location) {
        String apiKey = "API-KEY";
        String authHeader = "Bearer " + apiKey;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", authHeader);
        headers.add("accept", "application/json");
        String url = "https://api.yelp.com/v3/businesses/search?latitude="+ location.getLatitude() + "&longitude="+ location.getLongitude() + "&term=restaurants&radius=8046&open_now=true&sort_by=best_match&limit=20";
        HttpEntity<Object> entity = new HttpEntity<Object>(headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // System.out.println(response);
        return response;
    }

//    public RestaurantResponse yelpBusinessSearch(BigDecimal latitude, BigDecimal longitude) {
//        RestTemplate restTemplate = new RestTemplate();
//        String apiUrl = "https://api.yelp.com/v3/businesses/{id}";
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Authorization", "Bearer " + apiKey);
//        HttpEntity<?> entity = new HttpEntity<>(headers);
//        String id = "SFlAWPKHOJEsTttBLUj8Hw";
//        UriComponents uriComponents = UriComponentsBuilder.fromUriString(apiUrl)
//                .buildAndExpand(id);
//        ResponseEntity<Map> responseEntity = restTemplate.exchange(uriComponents.toUri(),
//                HttpMethod.GET, entity, Map.class);
//
//        Map<String, Object> data = responseEntity.getBody();
//
//        RestaurantResponse restaurant = new RestaurantResponse();
//        restaurant.setName((String) data.get("name"));
//        restaurant.setRating((Double) data.get("rating"));
//    }
}
