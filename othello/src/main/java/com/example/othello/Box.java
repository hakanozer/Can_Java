package com.example.othello;

import szte.mi.Move;

public class Box {

    private Move coordinate;
    private EBoard type;

    public Box(Move coordinate, EBoard type) {
        this.coordinate = coordinate;
        this.type = type;
    }

    public Move getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Move coordinate) {
        this.coordinate = coordinate;
    }

    public EBoard getType() {
        return type;
    }

    public void setType(EBoard type) {
        this.type = type;
    }
}
