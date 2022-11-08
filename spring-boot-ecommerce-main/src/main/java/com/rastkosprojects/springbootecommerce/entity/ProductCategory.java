/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rastkosprojects.springbootecommerce.entity;


import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Class which represents the product category.
 * @author rastko
 */
@Entity
@Table(name="product_category")
//@Getter
//@Setter
//instead of @Data because of a known lombok bug with many-to-one relationships
public class ProductCategory {
	/**
	 * Attribute - Id primary key as Long.
	 * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    /**
	 * Attribute - category name as String.
	 * */
    @Column(name="category_name")
    private String categoryName;
    /**
   	 * Attribute - products which belong to category as Set of Product objects.
   	 * */
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "category")
    private Set<Product> products;

	public Long getId() {
		return id;
	}

	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * Sets category name attribute to new value.
	 * @param categoryName  name as String
	 * @throws java.lang.NullPointerException if argument is null
	 * @throws java.lang.RuntimeException if argument is not at least 2 characters long.
	 * */
	public void setCategoryName(String categoryName) {
		if(categoryName == null) {
			throw new NullPointerException("Category name cannot be null");
		}
		if(categoryName.length() <= 2) {
			throw new RuntimeException("Category name length must be greater than 2");
		}
		this.categoryName = categoryName;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	/**
	 * Sets products attribute to new value.
	 * @param products products as a Set of Product objects.
	 * throws java.lang.NullPointerException if argument is null
	 * */
	public void setProducts(Set<Product> products) {
		if(products == null) {
			throw new NullPointerException();
		}
		this.products = products;
	}
	/**
	 * @return result Returns hashCode result.
	 * */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		return result;
	}
	/**
	 * Compares category name attribute of the argument to this object.
	 * 
	 * @return true if objects are equal
	 * @return false if objects are not equal
	 * 
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductCategory other = (ProductCategory) obj;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		return true;
	}
    
    
}
