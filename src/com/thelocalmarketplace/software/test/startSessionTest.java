package com.thelocalmarketplace.software.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.software.SelfCheckoutStationLogic;

import powerutility.PowerGrid;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class startSessionTest {
	private SelfCheckoutStation st;
	private SelfCheckoutStationLogic software;
	
	@Before
	public void setUp() {
		st = new SelfCheckoutStation();
		PowerGrid pw = PowerGrid.instance();
		st.plugIn(pw);
		st.scanner.turnOn();
		st.coinValidator.activate();
		software = new SelfCheckoutStationLogic(st);
	}
	
	
	@Test
	public void testStartSession() {
		try {
			software.startSession();
		} catch (Exception e) {
			System.out.println(e);
			fail("Exception happened!");
		}
	}
	
	@Test
	public void testStartSessionWhenAlreadyInASession() {
		try {
			software.startSession();
		} catch (Exception e) {
			assertTrue("Already in a session", e instanceof Exception);
		}
	}
}
