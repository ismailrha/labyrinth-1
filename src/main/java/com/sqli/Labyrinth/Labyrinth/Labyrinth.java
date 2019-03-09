package com.sqli.Labyrinth.Labyrinth;

import java.util.ArrayList;
import java.util.List;

public class Labyrinth {
	
	private List<Gate> gates ;
	private Room currentRoom;
	private Gate lastGate;
	private PathTaken pathTaken;
	
	public Labyrinth(String ...paths) {
		
		this.gates=new ArrayList<Gate>();
		currentRoom = new Room("");
		pathTaken = new PathTaken();
		Parser parser;
		
		for(String path:paths)
		{
			
			if(path.contains(GateType.NORMAL.getSymbol()))
			{
				
				parser= new NormalGateParser();
			
				this.gates.add(parser.parser(path));
			}
			else
			{
				parser= new SensorGateParser();
				this.gates.add(parser.parser(path));
			}
			
		}
		
	}

	public void popIn(String roomName) throws IllegalMoveException {
			if(currentRoom.doesntExist())
				currentRoom = new Room(roomName);
			else
				throw new IllegalMoveException();
			
		
	}

	public void walkTo(String roomName) throws IllegalMoveException, ClosedDoorException {
		Room lastRoom = currentRoom;
		
		for(Gate gate:gates)
		{
			
			if(gate.isRoomExist(roomName))
			{	

				if(gate.isFirstRoomCurrentRoom(currentRoom) && gate.isRoomSecond(roomName))
					{	if(!gate.isGateOpen())
							throw new ClosedDoorException();
					else {
						currentRoom = new Room(roomName);
						lastGate = gate;
						pathTaken.addMove(gate);
						break;
						}
					}
				else if(gate.isSecondRoomCurrentRoom(currentRoom) && gate.isRoomFirst(roomName))
				{
					if(!gate.isGateOpen())
						throw new ClosedDoorException();
				else {
					currentRoom = new Room(roomName);
					lastGate = gate;
					pathTaken.addMove(gate);
					break;
					}
				}
				
			}
			
		
		}
		if(lastRoom.equals(currentRoom))
			throw new IllegalMoveException();
		
	
		
	}

	public void closeLastDoor() throws DoorAlreadyClosedException {
	
		if(lastGate.isGateOpen())
			lastGate.closingDoor();
		else
			throw new DoorAlreadyClosedException();
			
		
	}

	public String readSensors() {
		List <String> trackedPath = pathTaken.getTrackedPath();
	
		Printer printer = new StringPrinter();
		return printer.print(trackedPath);
	
	}

}
