package com.mootez.resvervation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mootez.resvervation.model.Restaurant;
import com.mootez.resvervation.services.RestaurantService;


@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1/restaurant")

public class RestaurantController {
    @Autowired
    private final RestaurantService restaurantService;
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @PostMapping("/create")
public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){
    Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
    return new ResponseEntity<>(createdRestaurant,HttpStatus.CREATED);
}   
@GetMapping("/all")
public ResponseEntity<List<Restaurant>> getAllRestaurant(){
    List<Restaurant> restaurants = restaurantService.getAllRestaurant();
    return new ResponseEntity<>(restaurants,HttpStatus.OK);
}
@GetMapping("/find/{id}")
public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String id){
    Restaurant restaurant=restaurantService.getRestaurantById(id);
    if (restaurant != null) {
    return new ResponseEntity<>(restaurant,HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
@PutMapping("/update/{id}")
public ResponseEntity<Restaurant> updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable String id ){
    restaurant.setId(id);
    Restaurant updatedRestaurant = restaurantService.updateRestaurant(restaurant);
    return new ResponseEntity<>(updatedRestaurant,HttpStatus.OK);
}
@DeleteMapping("/delete/{id}")
public ResponseEntity<Void> deleteRestaurantById(@PathVariable String id){
    restaurantService.deleteRestaurant(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@GetMapping("/price/{id}")
public double calculateTotalPriceByRestaurantId(@PathVariable String id) {
    return restaurantService.calculateTotalPriceByRestaurantId(id);
}
}
