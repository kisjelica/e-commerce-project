/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dto;

import com.rastkosprojects.springbootecommerce.entity.Address;
import com.rastkosprojects.springbootecommerce.entity.Customer;
import com.rastkosprojects.springbootecommerce.entity.Order;
import com.rastkosprojects.springbootecommerce.entity.OrderItem;
import java.util.Set;
import lombok.Data;

/**
 * Class which represents a purchase, made on the front-end.
 * @author rastko
 */

public class Purchase {
	/**
	 * Attribute - customer as Customer object.
	 * */
    private Customer customer;
    /**
	 * Attribute - shipping address as Address object.
	 * */
    private Address shippingAddress;
    /**
   	 * Attribute - billing address as Address object.
   	 * */
    private Address billingAddress;
    /**
   	 * Attribute - order as Order object.
   	 * */
    private Order order;
    /**
   	 * Attribute - order items as Set of OrderItem objects.
   	 * */
    private Set<OrderItem> orderItems;

	public Customer getCustomer() {
		return customer;
	}
	/**
	 * Sets customer attribute to new value.
	 * @param customer customer as Customer object
	 * @throws java.lang.NullPointerException if argument is null
	 * */
	public void setCustomer(Customer customer) {
		if(customer == null) {
			throw new NullPointerException("Customer cannot be null");
		}
		this.customer = customer;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}
	/**
	 * Sets shipping address attribute to new value.
	 * @param shippingAddress shipping address as Address object
	 * @throws java.lang.NullPointerException if argument is null
	 * */
	public void setShippingAddress(Address shippingAddress) {
		if(shippingAddress == null) {
			throw new NullPointerException("Shipping address cannot be null");
		}
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}
	/**
	 * Sets billing address attribute to new value.
	 * @param billingAddress shipping address as Address object
	 * @throws java.lang.NullPointerException if argument is null
	 * */
	public void setBillingAddress(Address billingAddress) {
		if(billingAddress == null) {
			throw new NullPointerException("Billing address cannot be null");
		}
		this.billingAddress = billingAddress;
	}

	public Order getOrder() {
		return order;
	}
	/**
	 * Sets the order attribute to new value.
	 * @param order order as Order object
	 * @throws java.lang.NullPointerException if argument is null
	 * */
	public void setOrder(Order order) {
		if(order == null) {
			throw new NullPointerException("Order cannot be null");
		}
		this.order = order;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	/**
	 * Sets order items attribute to new value.
	 * @param orderItems order items as Set of OrderItem objects
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if set is empty
	 * */
	public void setOrderItems(Set<OrderItem> orderItems) {
		if(orderItems == null) {
			throw new NullPointerException("Order items cannot be null");
		}
		if(orderItems.isEmpty()) {
			throw new RuntimeException("Order items cannot be empty.");
		}
		this.orderItems = orderItems;
	}
}
