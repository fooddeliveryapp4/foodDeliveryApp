package com.nv.foodapp.repository.restaurant;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nv.foodapp.entity.Restaurant;
@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant,Integer>{

	@Query(value = "SELECT * from restaurant where restaurant_id=?1", nativeQuery = true)
	public List<Restaurant> findAllByRestaurantId(int id);


	
}

	
/*
	List<Restaurant> getRestaurantByRestaurantByCountry(String country);

	List<Restaurant> getRestaurantByRestaurantByCity(String city);

	
*/


