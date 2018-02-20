package org.usfirst.frc.team5870.autonomous;

public enum Direction {
	RIGHT(90), LEFT(-90), STARTING_LEFT, STARTING_CENTRE, STARTING_RIGHT;
	
	private final int value;
	
	private Direction() {
		value = 0;
	}
	
    private Direction(int value) {
        this.value = value;
    }

    public int val() {
        return value;
    }
}
