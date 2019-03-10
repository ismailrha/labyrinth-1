package com.sqli.Labyrinth.Labyrinth;

import java.util.ArrayList;
import java.util.List;

public class PathTaken {

	List<Gate> pathTaken;

	public PathTaken() {
		pathTaken = new ArrayList<Gate>();
	}

	public void addMove(Gate gate) {

		pathTaken.add(gate);
	}

	public List<String> getTrackedPath() {
		List<String> trackedPath = new ArrayList<String>();
		for (Gate gate : pathTaken)
			if (!gate.isGateNormal())
				trackedPath.add(gate.gettingSensoredPath());

		return trackedPath;
	}
}
