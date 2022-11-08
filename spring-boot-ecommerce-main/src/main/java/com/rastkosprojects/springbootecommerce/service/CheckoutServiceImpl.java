/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.service;

import com.rastkosprojects.springbootecommerce.dao.CustomerRepository;
import com.rastkosprojects.springbootecommerce.dto.Purchase;
import com.rastkosprojects.springbootecommerce.dto.PurchaseResponse;
import com.rastkosprojects.springbootecommerce.entity.Customer;
import com.rastkosprojects.springbootecommerce.entity.Order;
import com.rastkosprojects.springbootecommerce.entity.OrderItem;
import java.util.Set;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author rastko
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    //no autowire needed since this is the only constructor
    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //retrieve the order info from dto
    	if(purchase == null) {
    		throw new NullPointerException("Purchase cannot be null");
    	}
        Order order = purchase.getOrder();
        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //populate order with order items
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(orderItem -> {
            order.add(orderItem);
        });
        
        //populate order with billing address and shipping address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        //populate customer with order
        Customer customer = purchase.getCustomer();
        
        //check if existing customer
        String email = customer.getEmail();
        Customer customerFromDB = customerRepository.findByEmail(email);
        if(customerFromDB != null){
            customer = customerFromDB;
            
        }
        
        customer.add(order);
        //save to the database
        customerRepository.save(customer);
        
        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        //create a unique key that is random
        //uuid-4 - universally unique identifier
        
        return UUID.randomUUID().toString();
    }

}
