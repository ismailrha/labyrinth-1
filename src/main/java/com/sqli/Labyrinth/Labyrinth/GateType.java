package com.sqli.Labyrinth.Labyrinth;

public enum GateType {
    NORMAL("|"), SENSOR("$");
    private String gateSymbol;

    GateType(final String gateSymbol) {
        this.gateSymbol = gateSymbol;
    }

    public String getSymbol() {
        return this.gateSymbol;
    }
}
