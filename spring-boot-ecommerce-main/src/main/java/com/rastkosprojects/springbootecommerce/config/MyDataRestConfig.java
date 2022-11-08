/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.config;

import com.rastkosprojects.springbootecommerce.entity.Country;
import com.rastkosprojects.springbootecommerce.entity.Order;
import com.rastkosprojects.springbootecommerce.entity.Product;
import com.rastkosprojects.springbootecommerce.entity.ProductCategory;
import com.rastkosprojects.springbootecommerce.entity.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.util.pattern.PathPattern;

/**
 * Class for configuring the repositories.
 * @author rastko
 */
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Value("${allowed.origins}")
    String allowedOrigins;
    
	/**
	 * Entity manager attribute which is to be injected.
	 * */
    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    
    /**
     * Method to configure the repositories.
     * Used to disable  HTTP methods for certain repositories
     * Also used to expose ids of repositories
     * @param config the configuration of the application
     * @param cors cross-origin resource sharing
     * */
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE,HttpMethod.PATCH};
        //disable HTTP methods PUT, POST and DELETE for the Product entity
        disableHttpMethods(Product.class, config, unsupportedActions);
        //the same for ProductCategory
        disableHttpMethods(ProductCategory.class, config, unsupportedActions);
        
        //for country and state
        disableHttpMethods(Country.class, config, unsupportedActions);
        disableHttpMethods(State.class, config, unsupportedActions);
        disableHttpMethods(Order.class, config, unsupportedActions);
        exposeIds(config);
        //configure cors mapping
        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(allowedOrigins);
        
    }
    /**
     * Method used to expose ids at the endpoints
     * @param config the configuration of the application
     * */
    private void exposeIds(RepositoryRestConfiguration config) {
        //expose entity ids
        
        //get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
        
        List<Class> entityClasses = new ArrayList<>();
        //get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }
        //expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
        
    }
    /**
     * Helper method to disable the given http methods
     * @param theClass class for which we disable the methods
     * @param config the configuration of the application
     * @param unsupportedActions the Http methods to be disabled
     * */
    private void disableHttpMethods(Class theClass,RepositoryRestConfiguration config, HttpMethod[] unsupportedActions){
    config.getExposureConfiguration().forDomainType(theClass)
        .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions))
        .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsupportedActions));
        
    }

}
