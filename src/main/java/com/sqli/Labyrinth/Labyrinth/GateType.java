package com.sqli.Labyrinth.Labyrinth;

public enum GateType {
	NORMAL("|"), SENSOR("$");
	private String gateSymbol;

	private GateType(String gateSymbol) {
		this.gateSymbol = gateSymbol;
	}

	public String getSymbol() {
		return this.gateSymbol;
	}
}
