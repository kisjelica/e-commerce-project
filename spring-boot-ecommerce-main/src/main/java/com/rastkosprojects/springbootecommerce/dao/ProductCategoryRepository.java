/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dao;

import com.rastkosprojects.springbootecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Interface which represents the DAO to the ProductCategory objects.
 * Spring Data REST scans the repository and automatically opens endpoints.
 * @author rastko
 */

@RepositoryRestResource(collectionResourceRel = "productCategory",path="product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long>{
    
}
