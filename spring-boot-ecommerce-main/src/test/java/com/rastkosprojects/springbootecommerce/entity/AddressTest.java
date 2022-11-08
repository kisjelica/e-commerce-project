package com.rastkosprojects.springbootecommerce.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AddressTest {
	Address a;
	@BeforeEach
	void setUp() throws Exception {
		 a = new Address();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	

	@Test
	void testSetStreet() {
		
		a.setStreet("Vojvode Stepe");
		assertEquals("Vojvode Stepe", a.getStreet());
	}

	@Test
	void testSetStreetNull() {
		
		assertThrows(NullPointerException.class, ()-> a.setStreet(null));
	}
	
	@Test
	void testSetStreetShort() {
		
		assertThrows(RuntimeException.class, ()-> a.setStreet(""));
		assertThrows(RuntimeException.class, ()-> a.setStreet("A"));
		
	}
	@Test
	void testSetCity() {
		a.setCity("Beograd");
		assertEquals("Beograd", a.getCity());
	}
	@Test
	void testSetCityNull() {
		
		assertThrows(NullPointerException.class, ()-> a.setCity(null));
	}
	
	@Test
	void testSetCityShort() {
		
		assertThrows(RuntimeException.class, ()-> a.setCity(""));
		assertThrows(RuntimeException.class, ()-> a.setCity("A"));
		
	}
	@Test
	void testSetState() {
		a.setState("Baden-Wuttemberg");
		assertEquals("Baden-Wuttemberg", a.getState());
	}
	@Test
	void testSetStateNull() {
		
		assertThrows(NullPointerException.class, ()-> a.setState(null));
	}
	
	@Test
	void testSetStateShort() {
		
		assertThrows(RuntimeException.class, ()-> a.setState(""));
		assertThrows(RuntimeException.class, ()-> a.setState("A"));
		
	}
	@Test
	void testSetCountry() {
		a.setCountry("Germany");
		assertEquals("Germany",a.getCountry());
	}
	
	@Test
	void testSetCountryNull() {
		
		assertThrows(NullPointerException.class, ()-> a.setCountry(null));
	}
	
	@Test
	void testSetCountryShort() {
		
		assertThrows(RuntimeException.class, ()-> a.setCountry(""));
		assertThrows(RuntimeException.class, ()-> a.setCountry("A"));
		
	}
	
	@Test
	void testSetZipCode() {
		a.setZipCode("11000");
		assertEquals("11000", a.getZipCode());
	}
	@Test
	void testSetZipCodeNull() {
		
		assertThrows(NullPointerException.class, ()-> a.setZipCode(null));
	}
	
	@Test
	void testSetZipCodeShort() {
		
		assertThrows(RuntimeException.class, ()-> a.setZipCode(""));
		assertThrows(RuntimeException.class, ()-> a.setZipCode(""));
		
	}
	@Test
	void testSetOrder() {
		assertThrows(NullPointerException.class, () -> a.setOrder(null));
	}

	@ParameterizedTest
	@CsvSource({
		"USA, Texas, Austin, 1st street, 10000, USA, Texas, Austin, 1st street, 10000, true",
		"USA, Maine, Bagnor, 2nd street, 20000, USA, Texas, Austin, 1st street, 10000, false",
		"Germany, Bavaria, Baden Baden, Bismarck rue, 10000, USA, Texas, Austin, 1st street, 10000, false",
		"USA, Texas, Austin, 2nd street, 10000, USA, Texas, Austin, 1st street, 10000, false",
		"USA, Texas, Fort Worth, 3rd street, 10000, USA, Texas, Austin, 1st street, 10000, false"
		
	})
	void testEquals(String country1, String state1, String city1, String street1, String zipcode1,
			String country2, String state2, String city2, String street2, String zipcode2, boolean equals) {
		a.setCountry(country1);
		a.setState(state1);
		a.setCity(city1);
		a.setStreet(street1);
		a.setZipCode(zipcode1);
		
		Address b = new Address();
		
		b.setCountry(country2);
		b.setState(state2);
		b.setCity(city2);
		b.setStreet(street2);
		b.setZipCode(zipcode2);
		assertEquals(equals, a.equals(b));
	}

	

}
