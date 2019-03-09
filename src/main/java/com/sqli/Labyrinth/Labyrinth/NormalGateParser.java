package com.sqli.Labyrinth.Labyrinth;

public class NormalGateParser implements Parser {

	public Gate parser(String path) {
		String[] pathSeparated = path.split("\\" + GateType.NORMAL.getSymbol());
	
		return new Gate(new Room(pathSeparated[0]), new Room(pathSeparated[1]) , GateType.NORMAL);
	}
	
	public static void main(String[] args) {
		
		String s="a|b";
		NormalGateParser normalGateParser = new NormalGateParser();
		Gate g = normalGateParser.parser(s);
		
	}

}
