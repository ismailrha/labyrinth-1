package com.sqli.Labyrinth.Labyrinth;

public class SensorGateParser implements Parser {

    public Gate parse(final String path) {
        String[] pathSeparated = path.split("\\" + GateType.SENSOR.getSymbol());

        return new Gate(new Room(pathSeparated[0]), new Room(pathSeparated[1]), GateType.SENSOR);
    }
}
