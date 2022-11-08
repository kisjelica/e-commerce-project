/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dto;

import lombok.Data;

/**
 * Class which represents a PurchaseResponse to send back to the front-end, it contains a order tracking number for the customer.
 * @author rastko
 */
//used to send java object as json
//@Data
public class PurchaseResponse {
    //lombok will only generate constructors for final fields
    //or add @NonNull
	/**
	 * Attribute - order tracking number as String.
	 * 
	 * */
    private final String orderTrackingNumber;
    /**
	 * Constructor to create a purchase response with the injected order tracking number
	 * @param orderTrackingNumber order tracking number as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if order tracking number is not valid
	 * */
    public PurchaseResponse(String orderTrackingNumber) {
    	if(orderTrackingNumber == null) {
			throw new NullPointerException("Order tracking number cannot be null.");
		}
		if(orderTrackingNumber.length() != 36) {
			throw new RuntimeException("Order tracking number must be a 36 character UUID");
		}
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public String getOrderTrackingNumber() {
		return orderTrackingNumber;
	}
}
