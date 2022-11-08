package com.rastkosprojects.springbootecommerce.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PurchaseResponseTest {

	

	@Test
	void testPurchaseResponse() {
		PurchaseResponse purchaseResponse = new PurchaseResponse("e13210c2-9a12-40c3-9fb1-744c5c93923f");
		assertEquals("e13210c2-9a12-40c3-9fb1-744c5c93923f", purchaseResponse.getOrderTrackingNumber());
	}

	@Test
	void testSetOrderTrackingNumberNull() {
		assertThrows(NullPointerException.class, () -> new PurchaseResponse(null));
	}

	@Test
	void testSetOrderTrackingNumberInvalidLength() {
		assertThrows(RuntimeException.class, () -> new PurchaseResponse("123213-12321"));
		assertThrows(RuntimeException.class,
				() -> new PurchaseResponse("123213-12321-e13210c2-9a12-40c3-9fb1-744c5c93923f"));
	}
}
