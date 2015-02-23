package com.beowulfe.hap.impl.characteristics.thermostat;

import java.util.concurrent.CompletableFuture;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.accessories.Thermostat;
import com.beowulfe.hap.accessories.properties.ThermostatMode;

public class CurrentHeatingCoolingModeCharacteristic extends
		AbstractHeatingCoolingModeCharacteristic {
	
	private final Thermostat thermostat;

	public CurrentHeatingCoolingModeCharacteristic(Thermostat thermostat) {
		super("0000000F-0000-1000-8000-0026BB765291", false, "Current Mode");
		this.thermostat = thermostat;
	}

	@Override
	protected void setModeValue(ThermostatMode mode) throws Exception {
		//Not writable
	}

	@Override
	protected CompletableFuture<ThermostatMode> getModeValue() {
		return thermostat.getCurrentMode();
	}

	@Override
	public void subscribe(HomekitCharacteristicChangeCallback callback) {
		thermostat.subscribeCurrentMode(callback);
	}

	@Override
	public void unsubscribe() {
		thermostat.unsubscribeCurrentMode();
	}

}
