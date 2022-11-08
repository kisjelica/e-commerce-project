package com.rastkosprojects.springbootecommerce.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CountryTest {
	Country c;
	@BeforeEach
	void setUp() throws Exception {
		c = new Country();
	}

	@AfterEach
	void tearDown() throws Exception {
		c = null;
	}

	@Test
	void testSetCode() {
		c.setCode("RS");
		assertEquals("RS", c.getCode());
	}

	@Test
	void testSetCodeNull() {
		assertThrows(NullPointerException.class, ()-> c.setCode(null));
	}
	@Test
	void testSetCodeInvalidLength() {
		assertThrows(RuntimeException.class, ()-> c.setCode(""));
		assertThrows(RuntimeException.class, ()-> c.setCode("A"));
		assertThrows(RuntimeException.class, ()-> c.setCode("ABC"));
	}
	@Test
	void testSetName() {
		c.setName("Serbia");
		assertEquals("Serbia", c.getName());
	}
	@Test
	void testSetNameNull() {
		assertThrows(NullPointerException.class, ()-> c.setName(null));
	}
	@Test
	void testSetNameShort() {
		assertThrows(RuntimeException.class, ()-> c.setName(""));
		assertThrows(RuntimeException.class, ()-> c.setName("A"));
		
	}
	@Test
	void testSetStates() {
		List<State> states = new LinkedList<State>();
		State state1 = new State();
		state1.setCountry(c);
		state1.setName("Washington");
		State state2 = new State();
		state2.setCountry(c);
		state2.setName("Texas");
		
		states.add(state1);
		states.add(state2);
		c.setStates(states);
		assertEquals(states, c.getStates());
	}

	@ParameterizedTest
	@CsvSource({
		"India, India,true",
		"India, Brasil, false"
	})
	void testEqualsObject(String name1,String name2, boolean equals) {
		c.setName(name1);
		Country c2 = new Country();
		c2.setName(name2);
		
		assertEquals(equals, c.equals(c2));
	}

}
