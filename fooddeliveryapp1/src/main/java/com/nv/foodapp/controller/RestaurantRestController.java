package com.nv.foodapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nv.foodapp.dto.RestaurantDTO;
import com.nv.foodapp.entity.Restaurant;
import com.nv.foodapp.service.restaurant.IRestaurantService;
import com.nv.foodapp.util.RestaurantDtoConvertor;


@RestController
@RequestMapping("/restaurant")

public class RestaurantRestController {

	

		@Autowired
		RestaurantDtoConvertor restuarantConvertor;
		@Autowired
		IRestaurantService restaurantService;

		private final Logger logger = LoggerFactory.getLogger(this.getClass());

		public RestaurantRestController() {
			logger.info("restaurant rest controller");
			System.err.println("restaurant rest controller");
		}

		@PostMapping("/register")
		public ResponseEntity<RestaurantDTO> savedRestaurants(@RequestBody Restaurant restaurant) throws Exception {
			Restaurant savedRestaurant = restaurantService.addRestaurant(restaurant);
			logger.info(" --->> Instructor saved " + savedRestaurant);

			if (savedRestaurant != null) {
				RestaurantDTO dtoObj = restuarantConvertor.getRestaurantDTO(savedRestaurant);
				return new ResponseEntity<RestaurantDTO>(dtoObj, HttpStatus.OK);

			}
			return null;
			//localhost:2003/restaurant/register
		}

		@GetMapping("/list")
		public ResponseEntity<List<RestaurantDTO>> getAllRestuarant() {
			List<Restaurant> allRestuarant = restaurantService.viewAllRestaurants();
			List<RestaurantDTO> restuarantDtoList = new ArrayList<>();

			if (allRestuarant != null && allRestuarant.isEmpty() == false) {
				for (Restaurant restuarants : allRestuarant) {
					RestaurantDTO dto = restuarantConvertor.getRestaurantDTO(restuarants);
					restuarantDtoList.add(dto);
				}
			}

			return new ResponseEntity<List<RestaurantDTO>>(restuarantDtoList, HttpStatus.OK);
		}
		//localhost:2003/restaurant/list

		@GetMapping("/{resid}")
		public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable int resid) throws Exception {

			Restaurant savedRestaurant = restaurantService.viewRestaurantById(resid);
			RestaurantDTO dto = restuarantConvertor.getRestaurantDTO(savedRestaurant);
			return new ResponseEntity<RestaurantDTO>(dto, HttpStatus.OK);

		}

		@GetMapping("/{resName}")
		public ResponseEntity<RestaurantDTO> getRestaurantByName(@PathVariable String resName) throws Exception {

			Restaurant savedRestaurant = restaurantService.viewRestaurantByName(resName);
			RestaurantDTO dto = restuarantConvertor.getRestaurantDTO(savedRestaurant);
			return new ResponseEntity<RestaurantDTO>(dto, HttpStatus.OK);

		}
		

		@GetMapping("/city/{city}")
		public ResponseEntity<List<RestaurantDTO>> getRestaurantByCity(@PathVariable String city)
		{
			List<Restaurant> allRestaurant = restaurantService.getRestaurantByCity(city);
			List<RestaurantDTO> dto = new ArrayList<>();
			
			for (Restaurant restaurant : allRestaurant) {
				
				dto.add(RestaurantDtoConvertor.getRestaurantDTO(restaurant));
				
			}
			
			return new ResponseEntity<List<RestaurantDTO>>(dto,HttpStatus.OK);
		}

		@GetMapping("/country/{country}")
		public ResponseEntity<List<RestaurantDTO>> getRestaurantByCountry(@PathVariable String country)
		{
			List<Restaurant> allRestaurant = restaurantService.getRestaurantByCountry(country);
			List<RestaurantDTO> dto= new ArrayList<>();
			
			for (Restaurant restaurant : allRestaurant) {
				
			dto.add(RestaurantDtoConvertor.getRestaurantDTO(restaurant));
				
			}
			
			return new ResponseEntity<List<RestaurantDTO>>(dto,HttpStatus.OK);
		}
		@GetMapping("state/{state}")
		public ResponseEntity<List<RestaurantDTO>> getRestaurantByState(@PathVariable String country)
		{
			List<Restaurant> allRestaurant = restaurantService.getRestaurantByCountry(country);
			List<RestaurantDTO> dto= new ArrayList<>();
			
			for (Restaurant restaurant : allRestaurant) {
				
			dto.add(RestaurantDtoConvertor.getRestaurantDTO(restaurant));
				
			}
			
			return new ResponseEntity<List<RestaurantDTO>>(dto,HttpStatus.OK);
		}
		@DeleteMapping("/remove/{restaurantId}")
		public ResponseEntity<Boolean> deleteRestaurant(@PathVariable int restaurantId){
			boolean status = restaurantService.removeRestaurant(restaurantId);
			return new ResponseEntity<Boolean>(status, HttpStatus.OK);
		}

		@GetMapping("restaurant/{id}")
		public List<Restaurant> ListAllByRestaurantId(@PathVariable("id") int id) {
			return restaurantService.findAllByRestaurantId(id);
		}
		
		

		
		
}
