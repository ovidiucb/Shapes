package com.ovidiucb.shapes;

/**
 * Base class for curved shapes
 * Created by ovidiucb
 */
public abstract class Curve extends FillableShape {

    public Curve() {
        super();
    }

    public Curve(int startX, int startY) {
        super(startX, startY);
    }

    public Curve(Point p) {
        super(p);
    }
}
