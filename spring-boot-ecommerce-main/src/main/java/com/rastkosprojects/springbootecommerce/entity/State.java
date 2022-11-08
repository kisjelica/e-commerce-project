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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

/**
 * Class which represents a State.
 * @author rastko
 */
@Entity
@Table(name = "state")

public class State {
	/**
	 * Attribute - Id primary key as Long.
	 * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
   	 * Attribute - state name as String.
   	 * */
    @Column(name = "name")
    private String name;
    /**
     * Attribute - country to which the state belongs as a Country object.
     * */
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}
	/**
	 * Sets name attribute to new value.
	 * @param name  name as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument is not at least 2 characters long.
	 * */
	public void setName(String name) {
		if(name == null) {
			throw new NullPointerException("Name cannot be null");
		}
		if(name.length() < 2) {
			throw new RuntimeException("Name length must be greater than 2");
		}
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}
	/**
	 * Sets the country attribute to the given value.
	 * @param country as a Country attribute.
	 * @throws java.lang.NullPointerException if argument is null
	 * */
	public void setCountry(Country country) {
		if(country == null) {
			throw new NullPointerException("Country cannot be null!");
		}
		this.country = country;
	}

	/**
	 * @return result Returns hashCode result.
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Compares country attribute and name attribute of the argument to this object.
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
		State other = (State) obj;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
    
}
