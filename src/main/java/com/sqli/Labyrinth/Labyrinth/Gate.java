package com.sqli.Labyrinth.Labyrinth;

public class Gate {

    private Room firstRoom;
    private Room secondRoom;
    private GateType gateType;
    private GateStatus gateStatus;

    Gate(final Room firstRoom, final Room secondroom, final GateType gateType) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondroom;
        this.gateType = gateType;
        this.gateStatus = GateStatus.OPEN;
    }

    public boolean isRoomExist(final String roomName) {
        if (isRoomFirst(roomName) || isRoomSecond(roomName)) {
            return true;
        }
        return false;
    }

    public boolean isRoomFirst(final String roomName) {
        if (firstRoom.isRoomMatch(roomName)) {
            return true;
        }
        return false;
    }

    public boolean isRoomSecond(final String roomName) {
        if (secondRoom.isRoomMatch(roomName)) {
            return true;
        }
        return false;
    }

    public boolean isFirstRoomCurrentRoom(final Room currentRoom) {
        if (firstRoom.isSameRoom(currentRoom)) {
            return true;
        }

        return false;
    }

    public String gettingPathwithSensor() {

        return firstRoom.getRoomName() + "" + secondRoom.getRoomName();
    }

    public boolean isSecondRoomCurrentRoom(final Room currentRoom) {
        if (secondRoom.isSameRoom(currentRoom)) {
            return true;
        }
        return false;
    }

    public boolean isGateOpen() {
        if (this.gateStatus == GateStatus.OPEN) {
            return true;
        }
        return false;
    }

    public void closingDoor() {
        this.gateStatus = GateStatus.CLOSED;
    }

    public boolean isGateNormal() {
        if (this.gateType == GateType.NORMAL) {
            return true;
        }
        return false;
    }

    public boolean areRoomsAdjacent(final Room currentRoom, final String roomName) {
        if (this.isFirstRoomCurrentRoom(currentRoom) && this.isRoomSecond(roomName)
            || this.isSecondRoomCurrentRoom(currentRoom) && this.isRoomFirst(roomName)) {
            return true;
        }
        return false;
    }
}
