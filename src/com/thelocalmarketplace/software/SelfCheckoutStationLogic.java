package com.thelocalmarketplace.software;

import com.thelocalmarketplace.hardware.SelfCheckoutStation;

public class SelfCheckoutStationLogic {
	private static boolean sessionStarts = false;
	private static SelfCheckoutStation station;
	
	public SelfCheckoutStationLogic(SelfCheckoutStation st) {
		station = st;
	}
	
	public boolean simulatedStartButtonEvent() {
		return true;
	}
	
	public void startSession() {
		if(sessionStarts) return;
		if(simulatedStartButtonEvent()) sessionStarts = true;
	}
	
	public void addItemByBarcodeScan() {
		
	}
}
