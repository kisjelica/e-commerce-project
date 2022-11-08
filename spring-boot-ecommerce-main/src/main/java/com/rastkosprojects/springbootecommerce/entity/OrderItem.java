/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Class that represents an order item.
 * @author rastko
 */

@Entity
@Table(name="order_item")

public class OrderItem {
	/**
	 * Attribute - Id primary key as Long.
	 * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    /**
	 * Attribute - image url as String.
	 * */
    @Column(name = "image_url")
    private String imageUrl;
    /**
   	 * Attribute - unit price as BigDecimal.
   	 * */
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    /**
   	 * Attribute - item quantity as integer.
   	 * */
    @Column(name = "quantity")
    private int quantity;
    /**
   	 * Attribute - product id as Long. Links to the Product of that is in this item.
   	 * */
    @Column(name = "product_id")
    private Long productId;
    /**
   	 * Attribute - order as an Order object.
   	 * */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

	public Long getId() {
		return id;
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

	public int getQuantity() {
		return quantity;
	}
	/**
	 * Sets  quantity attribute to new value.
	 * @param quantity total order quantity as integer
	 * 
	 * @throws java.lang.RuntimeException if quantity is zero or less.
	 * */
	public void setQuantity(int quantity) {
		if(quantity <= 0) {
			throw new RuntimeException("Quantity must be greater than zero!");
		}
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}
	/**
	 * Sets product id attribute to new value.
	 * @param productId product id as Long.
	 * @throws java.lang.NullPointerException if argument is null
	 */
	public void setProductId(Long productId) {
		if(productId == null) {
			throw new NullPointerException("Product id cannot be null");
		}
		this.productId = productId;
	}

	public Order getOrder() {
		return order;
	}
	/**
	 * Sets order attribute to new value.
	 * @param order order as Order object.
	 * @throws java.lang.NullPointerException if argument is null
	 */
	public void setOrder(Order order) {
		if(order == null) {
			throw new NullPointerException("Order cannot be null!");
		}
		this.order = order;
	}
    
    
}
