package com.rastkosprojects.springbootecommerce.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {
	Order o;

	@BeforeEach
	void setUp() throws Exception {
		o = new Order();
	}

	@AfterEach
	void tearDown() throws Exception {
		o = null;
	}

	@Test
	void testSetOrderTrackingNumber() {
		String otn = "e13210c2-9a12-40c3-9fb1-744c5c93923f";
		o.setOrderTrackingNumber(otn);
		assertEquals(otn, o.getOrderTrackingNumber());
	}

	@Test
	void testSetOrderTrackingNumberNull() {
		assertThrows(NullPointerException.class, () -> o.setOrderTrackingNumber(null));
	}

	@Test
	void testSetOrderTrackingNumberInvalidLength() {
		assertThrows(RuntimeException.class, () -> o.setOrderTrackingNumber("123213-12321"));
		assertThrows(RuntimeException.class,
				() -> o.setOrderTrackingNumber("123213-12321-e13210c2-9a12-40c3-9fb1-744c5c93923f"));
	}

	@Test
	void testSetTotalQuantity() {
		o.setTotalQuantity(4);
		assertEquals(4, o.getTotalQuantity());
	}

	@Test
	void testSetTotalQuantityZero() {
		assertThrows(RuntimeException.class, () -> o.setTotalQuantity(0));
	}

	@Test
	void testSetTotalPrice() {
		o.setTotalPrice(BigDecimal.valueOf(10000.0));
		assertEquals(BigDecimal.valueOf(10000.0), o.getTotalPrice());
	}

	@Test
	void testSetTotalPriceZero() {
		assertThrows(RuntimeException.class, () -> o.setTotalPrice(BigDecimal.ZERO));
	}

	@Test
	void testSetOrderItemsNull() {
		assertThrows(NullPointerException.class, () -> o.setOrderItems(null));
	}

	@Test
	void testSetOrderItemsEmpty() {
		Set<OrderItem> orderItems = new HashSet<>();
		assertThrows(RuntimeException.class, () -> o.setOrderItems(orderItems));
	}

	@Test
	void testSetCustomerNull() {
		assertThrows(NullPointerException.class, () -> o.setCustomer(null));
	}

	@Test
	void testSetShippingAddress() {
		Address a = new Address();
		a.setCountry("USA");
		a.setState("Washington");
		a.setCity("Seattle");
		a.setStreet("2nd Avenue");
		a.setZipCode("30000");
		o.setShippingAddress(a);
		assertEquals(a, o.getShippingAddress());
	}

	@Test
	void testSetShippingAddressNull() {
		assertThrows(NullPointerException.class, () -> o.setShippingAddress(null));
	}

	@Test
	void testSetBillingAddress() {
		Address a = new Address();
		a.setCountry("USA");
		a.setState("Washington");
		a.setCity("Seattle");
		a.setStreet("2nd Avenue");
		a.setZipCode("30000");
		o.setBillingAddress(a);
		assertEquals(a, o.getBillingAddress());
	}

	@Test
	void testSetBillingAddressNull() {
		assertThrows(NullPointerException.class, () -> o.setBillingAddress(null));
	}

	@Test
	void testAddItemNull() {
		assertThrows(NullPointerException.class, () -> o.add(null));
	}

	@Test
	void testEqualsObject() {
		String otn1 = "3894a1eb-d68a-4881-bb9a-142edd09b507";
		String otn2 = "5e2a3960-5bce-4820-91e6-d50a92703e40";

		o.setOrderTrackingNumber(otn1);
		Order o2 = new Order();
		Order o3 = new Order();
		o2.setOrderTrackingNumber(otn2);
		o3.setOrderTrackingNumber(otn1);
		assertEquals(false, o.equals(o2));
		assertEquals(true, o.equals(o3));
	}

}
