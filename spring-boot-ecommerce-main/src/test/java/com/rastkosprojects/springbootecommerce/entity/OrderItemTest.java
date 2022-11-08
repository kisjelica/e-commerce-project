package com.rastkosprojects.springbootecommerce.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderItemTest {
	OrderItem oi;

	@BeforeEach
	void setUp() throws Exception {
		oi = new OrderItem();
	}

	@AfterEach
	void tearDown() throws Exception {
		oi = null;
	}

	@Test
	void testSetUnitPrice() {
		oi.setUnitPrice(BigDecimal.valueOf(10000.0));
		assertEquals(BigDecimal.valueOf(10000.0), oi.getUnitPrice());
	}

	@Test
	void testSetUnitPriceNull() {
		assertThrows(NullPointerException.class, () -> oi.setUnitPrice(null));
	}

	@Test
	void testSetUnitZeroOrLess() {
		assertThrows(RuntimeException.class, () -> oi.setUnitPrice(BigDecimal.ZERO));
	}

	@Test
	void testSetQuantity() {
		oi.setQuantity(15);
		assertEquals(15, oi.getQuantity());
	}

	@Test
	void testSetQuantityZeroOrLess() {
		assertThrows(RuntimeException.class, () -> oi.setQuantity(0));
	}

	@Test
	void testSetProductId() {
		oi.setProductId(10l);
		assertEquals(10l, oi.getProductId());
	}

	@Test
	void testSetProductIdNull() {
		assertThrows(NullPointerException.class, () -> oi.setProductId(null));
	}

	@Test
	void testSetOrderNull() {
		assertThrows(NullPointerException.class, () -> oi.setOrder(null));
	}

}
