/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.service;

import com.rastkosprojects.springbootecommerce.dto.Purchase;
import com.rastkosprojects.springbootecommerce.dto.PurchaseResponse;

/**
 * CheckoutService class which is used for communication with the checkout form on the front-end.
 * @author rastko
 */
public interface CheckoutService {
	/**
	 * Method which is used to place an order, save it to the database, generate an UUID order tracking number, and return it in
	 * the response to the customer.
	 * @param purchase Purchase object with parameters taken from the checkout form.
	 * @return PurchaseResponse returns a purchase response which contains the order tracking number
	 * */
    PurchaseResponse placeOrder(Purchase purchase);
}
