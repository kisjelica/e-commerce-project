package com.rastkosprojects.springbootecommerce.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CustomerTest {
	Customer c;
	@BeforeEach
	void setUp() throws Exception {
		c = new Customer();
	}

	@AfterEach
	void tearDown() throws Exception {
		c = null;
	}

	@Test
	void testSetFirstName() {
		c.setFirstName("Rastko");
		assertEquals("Rastko",c.getFirstName());
	}

	@Test
	void testSetFirstNameNull() {
		assertThrows(NullPointerException.class, ()->c.setFirstName(null));
	}
	@Test
	void testSetFirstNameShort() {
		assertThrows(RuntimeException.class, ()->c.setFirstName(""));
		assertThrows(RuntimeException.class, ()->c.setFirstName("A"));
	}
	
	@Test
	void testSetLastName() {
		c.setLastName("Kisjelica");
		assertEquals("Kisjelica",c.getLastName());
	}
	@Test
	void testSetLasttNameNull() {
		assertThrows(NullPointerException.class, ()->c.setLastName(null));
	}
	@Test
	void testSetLastNameShort() {
		assertThrows(RuntimeException.class, ()->c.setLastName(""));
		assertThrows(RuntimeException.class, ()->c.setLastName("A"));
	}
	@Test
	void testSetEmail() {
		c.setEmail("kisjelicarastko@gmail.com");
		assertEquals("kisjelicarastko@gmail.com", c.getEmail());
	}

	@ParameterizedTest
	@CsvSource({
		"kisjelica",
		"kisjelica@gmail",
		"kisjelica@gmail.c",
		"kisjelica@gmail.somethingtoolong",
		"@gmail.com"
	})
	void testSetEmailInvalidFormat(String email) {
		assertThrows(RuntimeException.class, ()-> c.setEmail(email));
	}
	@Test
	void testSetOrders() {
		assertThrows(NullPointerException.class, ()->c.setOrders(null));
		
	}
	
	@Test
	void testEquals() {
		c.setEmail("peraperic@gmail.com");
		Customer c2 = new Customer();
		c2.setEmail("zikazikic@yahoo.com");
		Customer c3 = new Customer();
		c3.setEmail("peraperic@gmail.com");
		
		assertEquals(false, c.equals(c2));
		assertEquals(c, c3);
		
	}
}
