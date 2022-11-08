/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dao;

import com.rastkosprojects.springbootecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface which represents the DAO to the Customer objects.
 * Spring Data REST scans the repository and automatically opens endpoints.
 * @author rastko
 */
public interface CustomerRepository extends JpaRepository<Customer, Long>{
	/**
	 * Query method which is used by Spring Data REST and automatically implemented.
	 * Used to find the customers by email.
	 * @param email email as String
	 * @return Customer returns a Customer object
	 * */
    Customer findByEmail(String email);
}
