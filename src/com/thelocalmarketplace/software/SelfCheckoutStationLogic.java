package com.thelocalmarketplace.software;

import com.jjjwelectronics.scanner.Barcode;
import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.hardware.external.ProductDatabases;

public class SelfCheckoutStationLogic {
	private static boolean sessionStarts = false;
	private static SelfCheckoutStation station;
	private static double expectedWeight = 0;
	
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
	
	public void addItemByBarcodeScan(Barcode barcode) throws Exception {
		if(!sessionStarts) throw new Exception("Cannot add item before starting a session!");
		
		BarcodedProduct addedProd = null;
		
		for (Barcode b: ProductDatabases.BARCODED_PRODUCT_DATABASE.keySet()) {
			if(b == barcode) addedProd = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(b); 
		}
		
		if(addedProd == null) throw new Exception("Product not found!");
		
		
	}
}
