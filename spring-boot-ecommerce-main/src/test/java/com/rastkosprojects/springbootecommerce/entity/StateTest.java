package com.rastkosprojects.springbootecommerce.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StateTest {
	State s;
	@BeforeEach
	void setUp() throws Exception {
		s = new State();
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
	}

	@Test
	void testSetName() {
		s.setName("Washington");
		assertEquals("Washington", s.getName());
	}
	@Test
	void testSetNameNull() {
		assertThrows(NullPointerException.class,()-> s.setName(null));
	}
	
	@Test
	void testSetNameShort() {
		assertThrows(RuntimeException.class,()-> s.setName(""));
		assertThrows(RuntimeException.class,()-> s.setName("A"));
	}
	@Test
	void testSetCountryNull() {
		assertThrows(NullPointerException.class, () -> s.setCountry(null));
	}

	@Test
	void testEqualsObject() {
		Country c = new Country();
		c.setName("USA");
		State state1 = new State();
		state1.setCountry(c);
		state1.setName("Washington");
		State state2 = new State();
		state2.setCountry(c);
		state2.setName("Texas");
		s.setCountry(c);
		s.setName("Texas");
		
		assertEquals(false, state1.equals(state2));
		assertEquals(true, s.equals(state2));
		
	}

}
