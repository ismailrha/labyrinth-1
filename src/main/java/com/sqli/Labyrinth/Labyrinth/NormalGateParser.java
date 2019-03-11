package com.sqli.Labyrinth.Labyrinth;

public class NormalGateParser implements Parser {

    public Gate parser(final String path) {
        String[] pathSeparated = path.split("\\" + GateType.NORMAL.getSymbol());

        return new Gate(new Room(pathSeparated[0]), new Room(pathSeparated[1]), GateType.NORMAL);
    }
}
