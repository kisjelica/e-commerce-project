/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dao;

import com.rastkosprojects.springbootecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Interface which represents the DAO to the Product objects.
 * Spring Data REST scans the repository and automatically opens endpoints.
 * @author rastko
 */
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long>{
    /**Query method because it starts with find by.
      Matches by category id.
      Behind the scenes, Spring executes a statement like:
      SELECT * FROM product WHERE category_id=?
      Spring Data REST will also expose the endpoint for:
      http://localhost:8080/api/products/search/findByCategory?id=2
      @param id id in Long type, which represents category id
      @param pageable enables pagination
      
    */
    Page<Product> findByCategoryId(@RequestParam("id")Long id, Pageable pageable);
    /**
    Executes a statement like:
    SELECT * FROM product WHERE name LIKE CONCAT('%',:name,'%')
    @param name name to search by
    @param pageable enables pagination
    */
    Page<Product> findByNameContaining(@RequestParam("name")String name, Pageable pageable);
}
