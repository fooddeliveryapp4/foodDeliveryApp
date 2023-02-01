package com.nv.foodapp.service.restaurant;

import java.util.List;

import org.springframework.stereotype.Service;
import com.nv.foodapp.entity.Restaurant;

@Service
public interface IRestaurantService {
	public Restaurant addRestaurant(Restaurant res)throws Exception;
	public Restaurant viewRestaurantById(int id);
	public Restaurant viewRestaurantByName(String name);
	public List<Restaurant> viewAllRestaurants();
	
	
}
