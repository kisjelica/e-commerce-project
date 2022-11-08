package com.rastkosprojects.springbootecommerce.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rastkosprojects.springbootecommerce.entity.Address;
import com.rastkosprojects.springbootecommerce.entity.OrderItem;

class PurchaseTest {
	Purchase p;
	@BeforeEach
	void setUp() throws Exception {
		p = new Purchase();
	}

	@AfterEach
	void tearDown() throws Exception {
		p = null;
	}

	@Test
	void testSetCustomerNull() {
		assertThrows(NullPointerException.class, () -> p.setCustomer(null));
	}

	@Test
	void testSetShippingAddress() {
		Address a = new Address();
		a.setCountry("USA");
		a.setState("Washington");
		a.setCity("Seattle");
		a.setStreet("2nd Avenue");
		a.setZipCode("30000");
		p.setShippingAddress(a);
		assertEquals(a, p.getShippingAddress());
	}

	@Test
	void testSetShippingAddressNull() {
		assertThrows(NullPointerException.class, () -> p.setShippingAddress(null));
	}

	@Test
	void testSetBillingAddress() {
		Address a = new Address();
		a.setCountry("USA");
		a.setState("Washington");
		a.setCity("Seattle");
		a.setStreet("2nd Avenue");
		a.setZipCode("30000");
		p.setBillingAddress(a);
		assertEquals(a, p.getBillingAddress());
	}

	@Test
	void testSetBillingAddressNull() {
		assertThrows(NullPointerException.class, () -> p.setBillingAddress(null));
	}

	@Test
	void testSetOrders() {
		assertThrows(NullPointerException.class, ()->p.setOrder(null));
		
	}

	@Test
	void testSetOrderItemsNull() {
		assertThrows(NullPointerException.class, () -> p.setOrderItems(null));
	}

	@Test
	void testSetOrderItemsEmpty() {
		Set<OrderItem> orderItems = new HashSet<>();
		assertThrows(RuntimeException.class, () -> p.setOrderItems(orderItems));
	}

}
