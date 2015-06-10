package com.ovidiucb.shapes.shapes;

/**
 * Base class for multiple line shapes
 * Created by ovidiucb
 */
public abstract class Polygon extends FillableShape {
    public Polygon() {
        super();
    }

    public Polygon(int startX, int startY) {
        super(startX, startY);
    }

    public Polygon(Point p) {
        super(p);
    }
}
