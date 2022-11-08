package com.rastkosprojects.springbootecommerce.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {
	Product p;
	@BeforeEach
	void setUp() throws Exception {
		p = new Product();
	}

	@AfterEach
	void tearDown() throws Exception {
		p = null;
	}
	
	@Test
	void testSetCategory() {
		ProductCategory pc = new ProductCategory();
		pc.setCategoryName("Books");
		p.setCategory(pc);
		assertEquals(pc, p.getCategory());
	}
	@Test
	void testSetCategoryNull() {
		assertThrows(NullPointerException.class,()-> p.setCategory(null));
	}
	@Test
	void testSetSku() {
		String sku = "BOOK-0-1";
		p.setSku(sku);
		assertEquals(sku, p.getSku());
	}
	@Test
	void testSetSkuNull() {
		assertThrows(NullPointerException.class,()-> p.setSku(null));
	}
	
	@Test
	void testSetSkuShort() {
		assertThrows(RuntimeException.class,()-> p.setSku(""));
		assertThrows(RuntimeException.class,()-> p.setSku("A"));
	}
	@Test
	void testSetName() {
		p.setName("Mrtve duse");
		assertEquals("Mrtve duse", p.getName());
	}
	@Test
	void testSetNameNull() {
		assertThrows(NullPointerException.class,()-> p.setName(null));
	}
	
	@Test
	void testSetNameShort() {
		assertThrows(RuntimeException.class,()-> p.setName(""));
		assertThrows(RuntimeException.class,()-> p.setName("A"));
	}
	@Test
	void testSetDescription() {
		p.setDescription("A very good book!");
		assertEquals("A very good book!", p.getDescription());
	}
	@Test
	void testSetDescriptionNull() {
		assertThrows(NullPointerException.class,()-> p.setDescription(null));
	}
	@Test
	void testSetUnitPrice() {
		p.setUnitPrice(BigDecimal.valueOf(10000.0));
		assertEquals(BigDecimal.valueOf(10000.0), p.getUnitPrice());
	}

	@Test
	void testSetUnitPriceNull() {
		assertThrows(NullPointerException.class, () -> p.setUnitPrice(null));
	}

	@Test
	void testSetUnitZeroOrLess() {
		assertThrows(RuntimeException.class, () -> p.setUnitPrice(BigDecimal.ZERO));
	}

	@Test
	void testSetUnitsInStock() {
		p.setUnitsInStock(5);
		assertEquals(5,p.getUnitsInStock());
	}
	@Test
	void testSetUnitsInStockLessThanZero() {
		assertThrows(RuntimeException.class, ()-> p.setUnitsInStock(-1));
	}
	@Test
	void testEqualsObject() {
		String sku1 = "BOOK-1";
		String sku2 = "BOOK-2";
		Product p2 = new Product();
		Product p3 = new Product();
		p2.setSku(sku1);
		p3.setSku(sku2);
		p.setSku(sku1);
		assertEquals(true, p.equals(p2));
		assertEquals(false, p.equals(p3));
	}

}
