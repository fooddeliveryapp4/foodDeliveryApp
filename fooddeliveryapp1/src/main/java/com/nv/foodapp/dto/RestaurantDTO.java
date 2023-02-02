package com.nv.foodapp.dto;



public class RestaurantDTO {

	
	private int restaurantId;
	private String restaurantName;
	private String restaurantContainItem;
	public RestaurantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantDTO(int restaurantId, String restaurantName, String restaurantContainItem) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantContainItem = restaurantContainItem;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantContainItem() {
		return restaurantContainItem;
	}
	public void setRestaurantContainItem(String restaurantContainItem) {
		this.restaurantContainItem = restaurantContainItem;
	}
	
}
