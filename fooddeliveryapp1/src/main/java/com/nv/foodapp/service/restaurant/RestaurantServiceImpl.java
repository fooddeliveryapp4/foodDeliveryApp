package com.nv.foodapp.service.restaurant;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.exception.InvalidInputDataException;
import com.nv.foodapp.repository.restaurant.IRestaurantRepository;

@Service
public class RestaurantServiceImpl implements IRestaurantService {
	
	@Autowired
	IRestaurantRepository restaurantRepository;

	@Override
	
	public Restaurant addRestaurant(Restaurant res)throws Exception {
		if(res!=null) {
			if(res.getRestaurantName().equals("")) {
				throw new InvalidInputDataException("restuarant name","restuarant name is null");
			}
			 Restaurant savedRestaurant=restaurantRepository.save(res);
			return savedRestaurant;
		}
		else throw new NullPointerException("restaurant is null");
	
	}

	@Override
	public Restaurant viewRestaurantById(int id) {
		if(id >=1)
		{
			Restaurant savedRestaurant =  restaurantRepository.getReferenceById(id);
			if(savedRestaurant != null) return savedRestaurant;
			else 
			{
				throw new EntityNotFoundException("Invalid Restaurant ID : "+id);
			}
		}
		return null;
		
	}

	@Override
	public Restaurant viewRestaurantByName(String name) {
		return null;
	}

	@Override
	public List<Restaurant> viewAllRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> getRestaurantByCountry(String country) {
		return null;
	}

	@Override
	public List<Restaurant> getRestaurantByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> findAllByRestaurantId(int id) {
		List<Restaurant> list=restaurantRepository.findAllByRestaurantId(id);
		return list;
	}

	@Override
	public boolean removeRestaurant(int restaurantId) {
		restaurantRepository.deleteById(restaurantId);
		return true;

	}

	

	
	
	
     
	
}
