/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Class that represents an address. Used in orders as billingAddress and shippingAddress.
 * 
 * @author rastko
 */
@Entity
@Table(name="address")
public class Address {
    /**
     * Attribute - Id primary key as Long.
     * 
     * 
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * Attribute - street name as String.
     * */
    @Column(name = "street")
    private String street;
    /**
     * Attribute - city name as String.
     * */
    @Column(name = "city")    
    private String city;
    /**
     * Attribute - state name as String.
     * */
    @Column(name = "state")    
    private String state;
    /**
     * Attribute - country name as String.
     * */
    @Column(name = "country")
    private String country;
    /**
     * Attribute - zip code as String.
     * */
    @Column(name = "zip_code")
    private String zipCode;
    /**
     * Order - Order object which is linked to the address.
     * */
    @OneToOne
    @PrimaryKeyJoinColumn
    private Order order;
   
	public Long getId() {
		return id;
	}
	
	public String getStreet() {
		return street;
	}
	/**
	 * Sets street attribute to new value.
	 * @param street street as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument is shorter than 2 characters
	 * */
	public void setStreet(String street) {
		if(street == null) {
			throw new NullPointerException("Street cannot be null!");
		}
		if(street.length() < 2) {
			throw new RuntimeException("Length must be greater than 2!");
		}
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	/**
	 * Sets city attribute to new value.
	 * @param city city as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument is shorter than 2 characters
	 * */
	public void setCity(String city) {
		if(city == null) {
			throw new NullPointerException("City cannot be null!");
		}
		if(city.length() < 2) {
			throw new RuntimeException("Length must be greater than 2!");
		}
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	/**
	 * Sets state attribute to new value.
	 * @param state state as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument is shorter than 2 characters
	 * */
	public void setState(String state) {
		if(state == null) {
			throw new NullPointerException("State cannot be null!");
		}
		if(state.length() < 2) {
			throw new RuntimeException("Length must be greater than 2!");
		}
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	/**
	 * Sets country attribute to new value.
	 * @param country country as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument is shorter than 2 characters
	 * */
	public void setCountry(String country) {
		if(country == null) {
			throw new NullPointerException("Country cannot be null!");
		}
		if(country.length() < 2) {
			throw new RuntimeException("Length must be greater than 2!");
		}
		this.country = country;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * Sets zip code attribute to new value.
	 * @param zipCode zip code as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument is shorter than 2 characters
	 * */
	public void setZipCode(String zipCode) {
		if(zipCode == null) {
			throw new NullPointerException("Zip code cannot be null!");
		}
		if(zipCode.length() < 2) {
			throw new RuntimeException("Length must be greater than 2!");
		}

		this.zipCode = zipCode;
	}

	public Order getOrder() {
		return order;
	}
	/**
	 * Sets order attribute to new value.
	 * @param order order as Order object.
	 * 
	 * */
	public void setOrder(Order order) {
		if(order == null) {
			throw new NullPointerException("");
		}
			
		this.order = order;
	}

	/**
	 * @return result Returns hashCode result.
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}
	/**
	 * Compares all attributes (street, city, country, state, zipCode) of the argument to this object.
	 * 
	 * @return true if objects are equal
	 * @return false if objects are not equal
	 * 
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

	
            
}
