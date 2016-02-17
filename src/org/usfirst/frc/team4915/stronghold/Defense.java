package org.usfirst.frc.team4915.stronghold;

public enum Defense {

    LOW_BAR("Low Bar"),
    PORTCULLIS("Portcullis"),
    CHEVAL_DE_FRIES("Cheval de Fries"),
    MOAT("Moat"),
    RAMPARTS("Ramparts"),
    DRAWBRIDGE("Drawbridge"),
    SALLY_PORT("Sally Port"),
    ROUGH_TERRAIN("Rough Terrain"),
    ROCK_WALL("Rock Wall");

    private final String name;

    private Defense(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
