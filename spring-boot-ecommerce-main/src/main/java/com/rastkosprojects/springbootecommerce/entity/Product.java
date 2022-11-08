/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Class that represents a product.
 * @author rastko
 */
@Entity
@Table(name = "product")
//@Data//lombok automatically generates getters and setters
public class Product {
	/**
	 * Attribute - Id primary key as Long.
	 * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
     * Attribute - category as ProductCategory object.
     * */
    @ManyToOne
    @JoinColumn(name="category_id",nullable = false)
    private ProductCategory category;
    /**
	 * Attribute - sku (stock-keeping unit, bar-code) as String.
	 * */
    @Column(name = "sku")
    private String sku;//bar-code
    /**
	 * Attribute - product name as String.
	 * */
    @Column(name = "name")
    private String name;
    /**
   	 * Attribute - product description as String.
   	 * */
    @Column(name = "description")
    private String description;
    /**
   	 * Attribute - unit price as BigDecimal.
   	 * */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    /**
   	 * Attribute - image url as String.
   	 * */
    @Column(name = "image_url")
    private String imageUrl;
    /**
     * Attribute - product status as boolean (active, inactive).
     * */
    @Column(name = "active")
    private boolean active;
    /**
     * Attribute - number of product units in stock as integer.
     * */
    @Column(name = "units_in_stock")
    private int unitsInStock;
    /**
	 * Attribute - date and time of order creation as Date.
	 * */
    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;
    /**
	 * Attribute - date and time of order update as Date.
	 * */
    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date dateUpdated;

	public Long getId() {
		return id;
	}
	
	public ProductCategory getCategory() {
		return category;
	}
	/**
	 * Sets category attribute to new value.
	 * @param category category as ProductCategory object
	 * @throws java.lang.NullPointerException if argument is null
	 * */
	public void setCategory(ProductCategory category) {
		if(category == null) {
			throw new NullPointerException("Product category cannot be null");
		}
		this.category = category;
	}

	public String getSku() {
		return sku;
	}
	/**
	 * Sets sku attribute to new value.
	 * @param sku sku as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument is not at least 2 characters long long.
	 * */
	public void setSku(String sku) {
		if(sku == null) {
			throw new NullPointerException("Sku cannot be null");
		}
		if(sku.length() < 2) {
			throw new RuntimeException("Sku length must be greater than 2");
		}
		this.sku = sku;
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

	public String getDescription() {
		return description;
	}
	/**
	 * Sets description attribute to new value.
	 * @param description  description as String
	 * @throws java.lang.NullPointerException if argument is null
	 * */
	public void setDescription(String description) {
		if(description == null) {
			throw new NullPointerException("Description cannot be null");
		}
		this.description = description;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	/**
	 * Sets unit price attribute to new value.
	 * @param unitPrice unit price as BigDecimal
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if quantity is zero or less.
	 * */
	public void setUnitPrice(BigDecimal unitPrice) {
		if(unitPrice == null) {
			throw new NullPointerException("Unit price cannot be null");
		}
		if(unitPrice.compareTo(BigDecimal.ZERO) <= 0) {
			throw new RuntimeException("Unit price must be greater than zero!");
		}
		this.unitPrice = unitPrice;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * Sets the image url to new value.
	 * @param imageUrl image url as String.
	 * */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getUnitsInStock() {
		return unitsInStock;
	}
	/**
	 * Sets units in stock attribute to new value.
	 * @param unitsInStock units in stock as integer.
	 * @throws java.lang.RuntimeException if units in stock are less than zero.
	 * */
	public void setUnitsInStock(int unitsInStock) {
		if(unitsInStock < 0) {
			throw new RuntimeException("Units in stock must be greater than or equal to zero!");
		}
		
		this.unitsInStock = unitsInStock;
	}
	/**
	 * @return result Returns hashCode result.
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}
	/**
	 * Compares sku attribute of the argument to this object.
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
		Product other = (Product) obj;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}

}
