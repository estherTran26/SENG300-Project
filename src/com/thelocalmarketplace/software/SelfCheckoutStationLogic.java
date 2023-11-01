package com.thelocalmarketplace.software;

import com.jjjwelectronics.IDevice;
import com.jjjwelectronics.IDeviceListener;
import com.jjjwelectronics.scanner.Barcode;
import com.jjjwelectronics.scanner.BarcodeScannerListener;
import com.jjjwelectronics.scanner.BarcodedItem;
import com.jjjwelectronics.scanner.IBarcodeScanner;
import com.thelocalmarketplace.hardware.BarcodedProduct;
import com.thelocalmarketplace.hardware.SelfCheckoutStation;
import com.thelocalmarketplace.hardware.external.ProductDatabases;

public class SelfCheckoutStationLogic implements BarcodeScannerListener{
	private static boolean sessionStarts = false;
	private static SelfCheckoutStation station;
	private static double expectedWeight = 0;
	private Barcode barcode;
	
	public SelfCheckoutStationLogic(SelfCheckoutStation st) {
		station = st;
		station.scanner.register(this);
	}
	
	public boolean simulatedStartButtonEvent() {
		return true;
	}
	
	public void startSession() {
		if(sessionStarts) return;
		if(simulatedStartButtonEvent()) sessionStarts = true;
	}
	
	public void addItemByBarcodeScan() throws Exception {
		if(!sessionStarts) throw new Exception("Cannot add item before starting a session!");
		
		BarcodedProduct addedProd = null;
		
		for (Barcode b: ProductDatabases.BARCODED_PRODUCT_DATABASE.keySet()) {
			if(b == barcode) addedProd = ProductDatabases.BARCODED_PRODUCT_DATABASE.get(b); 
		}
		
		if(addedProd == null) throw new Exception("Product not found!");
	}

	@Override
	public void aDeviceHasBeenEnabled(IDevice<? extends IDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aDeviceHasBeenDisabled(IDevice<? extends IDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aDeviceHasBeenTurnedOn(IDevice<? extends IDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aDeviceHasBeenTurnedOff(IDevice<? extends IDeviceListener> device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void aBarcodeHasBeenScanned(IBarcodeScanner barcodeScanner, Barcode barcode) {
		// TODO Auto-generated method stub
		this.barcode = barcode;
	}
}
