package com.nv.foodapp.util;

import org.springframework.stereotype.Component;

import com.nv.foodapp.dto.RestaurantDTO;
import com.nv.foodapp.entity.Restaurant;
@Component
public class RestaurantDtoConvertor {
	public static RestaurantDTO getRestaurantDTO(Restaurant r)
	{
		RestaurantDTO obj= new RestaurantDTO(r.getRestaurantId(),r.getRestaurantName(),r.getContactNumber());
		
	    return obj;
	}

	
}
