/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.controller;

import com.rastkosprojects.springbootecommerce.dto.Purchase;
import com.rastkosprojects.springbootecommerce.dto.PurchaseResponse;
import com.rastkosprojects.springbootecommerce.service.CheckoutService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class which controls communication with checkout.
 * 
 * @author rastko
 */

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    private final CheckoutService checkoutService;
    /**
     * Constructor to create the controller injected with the checkout service
     * @param checkoutService injected checkoutService object.
     * */
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }
    /**
     * Method which responds to the post mapping for purchase.
     * Places the order by saving the order with the checkout service and creating a response.
     * @param purchase Purchase objects with the order parameters
     * @return PurchaseResponse response which will be sent to the front-end
     * */
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        
        return purchaseResponse;
    }
}
