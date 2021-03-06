package com.sqli.Labyrinth.Labyrinth;

public class Room {

    private String roomName;

    Room(final String roomName) {
        this.roomName = roomName;
    }

    public boolean doesntExist() {
        if (this.roomName.contentEquals("")) {
            return true;
        }
        return false;
    }

    public boolean isRoomMatch(final String roomName) {
        if (this.roomName.contentEquals(roomName)) {
            return true;
        }
        return false;
    }

    public boolean isSameRoom(final Room otherRoom) {
        if (this.roomName.equals(otherRoom.roomName)) {
            return true;
        }

        return false;
    }

    public String getRoomName() {
        return new String(roomName);
    }
}
