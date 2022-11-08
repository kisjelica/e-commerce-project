package com.rastkosprojects.springbootecommerce.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductCategoryTest {
	ProductCategory pc;
	@BeforeEach
	void setUp() throws Exception {
		pc = new ProductCategory();
	}

	@AfterEach
	void tearDown() throws Exception {
		pc = null;
	}
	@Test
	void testSetCategoryName() {
		pc.setCategoryName("Books");
		assertEquals("Books", pc.getCategoryName());
	}
	@Test
	void testSetNameNull() {
		assertThrows(NullPointerException.class, ()-> pc.setCategoryName(null));
	}
	@Test
	void testSetNameShort() {
		assertThrows(RuntimeException.class, ()-> pc.setCategoryName(""));
		assertThrows(RuntimeException.class, ()-> pc.setCategoryName("A"));
		assertThrows(RuntimeException.class, ()-> pc.setCategoryName("AB"));
	}

	@Test
	void testSetProductsNull() {
		assertThrows(NullPointerException.class, ()-> pc.setProducts(null));
	}

	@Test
	void testEqualsObject() {
		pc.setCategoryName("Books");
		ProductCategory pc2 = new ProductCategory();
		ProductCategory pc3 = new ProductCategory();
		pc2.setCategoryName("Coffee cups");
		pc3.setCategoryName("Books");
		assertEquals(false, pc.equals(pc2));
		assertEquals(true, pc.equals(pc3));
	}

}
