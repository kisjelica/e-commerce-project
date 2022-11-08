/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Class that represents a Country, with id, code, name and states attribute.
 * @author rastko
 * 
 */
@Entity
@Table(name = "country")
public class Country {
	/**
	 * Attribute - Id primary key as Long.
	 * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    /**
	 * Attribute - country code as String.
	 * */
    @Column(name = "code")
    private String code;
    /**
	 * Attribute - country name as String.
	 * */
    @Column(name = "name")
    private String name;
    /**
     * Attribute - States as a List, mapped to the country.
     * 
     * */
    @OneToMany(mappedBy = "country")
    @JsonIgnore
    private List<State> states;
    public int getId() {
		return id;
	}
	public String getCode() {
		return code;
	}
	/**
	 * Sets code attribute to new value.
	 * @param code code as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument length is not 2 characters
	 * */
	public void setCode(String code) {
		if(code == null) {
			throw new NullPointerException("Code cannot be null!");
		}
		if(code.length() != 2) {
			throw new RuntimeException("Code length must be exactly 2!");
		}
		this.code = code;
	}

	public String getName() {
		return name;
	}
	/**
	 * Sets name attribute to new value.
	 * @param name name as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument is shorter than 2 characters
	 * */
	public void setName(String name) {
		if(name == null) {
			throw new NullPointerException("Name cannot be null!");
		}
		if(name.length() < 2) {
			throw new RuntimeException("Name length must be greater than 2!");
		}
		this.name = name;
	}

	public List<State> getStates() {
		return states;
	}
	/**
	 * Sets states attribute to new value.
	 * @param states argument as List of State objects.
	 * */
	public void setStates(List<State> states) {
		this.states = states;
	}
	/**
	 * @return result Returns hashCode result.
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	/**
	 * Compares name attribute of the argument to this object.
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
		Country other = (Country) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
	
	
}
