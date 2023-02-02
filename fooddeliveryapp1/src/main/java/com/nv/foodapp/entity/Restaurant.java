package com.nv.foodapp.entity;


import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity

public class Restaurant {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int restaurantId;
		private String restaurantName;
		private String managerName;
		private String contactNumber;

		@Embedded
		@Column(nullable = true)
		private Address address;

		

		public Restaurant() {
			super();
		}

		public Restaurant(String restaurantName, String managerName, String contactNumber, Address address) {
			super();
			this.restaurantName = restaurantName;
			this.managerName = managerName;
			this.contactNumber = contactNumber;
			this.address = address;
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

		public String getManagerName() {
			return managerName;
		}

		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}

		public String getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(String contactNumber) {
			this.contactNumber = contactNumber;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		
}
