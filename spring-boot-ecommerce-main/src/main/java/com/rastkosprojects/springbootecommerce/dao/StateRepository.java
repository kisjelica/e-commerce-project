/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.dao;

import com.rastkosprojects.springbootecommerce.entity.State;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Interface which represents the DAO to the State objects.
 * Spring Data REST scans the repository and automatically opens endpoints.
 * @author rastko
 */

@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer>{
    /**
     * Query method for finding states by country code.
     * Automatically implemented by Spring Data REST.
     * @param code code to search by
     * @return List<State> returns a list of states with the associated country code
     * */
    List<State> findByCountryCode(@Param("code") String code);
}
