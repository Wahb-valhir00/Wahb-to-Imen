package com.mootez.resvervation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mootez.resvervation.model.Menu;
import com.mootez.resvervation.model.Repas;
import com.mootez.resvervation.model.Restaurant;
import com.mootez.resvervation.repository.MenuRepository;
import com.mootez.resvervation.repository.RestaurantRepository;




@Service
public class RestaurantService {
    @Autowired

    private final MenuRepository menuRepository;

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(MenuRepository menuRepository, RestaurantRepository restaurantRepository) {
        this.menuRepository = menuRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public double calculateTotalPriceByRestaurantId(String id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurant not found for id: " + id));
        Menu menu = restaurant.getMenu();
        double totalPrice = 0.0;
        if (menu != null && menu.getRepas() != null) {
            for (Repas repas : menu.getRepas()) {
                totalPrice += repas.getPrix();
            }
        }
        return totalPrice;
    }
    

    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    } 

    public List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(String id){
        return restaurantRepository.findById(id).orElseThrow();
    }

    public Restaurant updateRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant (String id){
        restaurantRepository.deleteById(id);
    }
}

