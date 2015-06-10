package com.ovidiucb.shapes.shapes;

import com.ovidiucb.shapes.interfaces.Drawable;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by ovidiucb
 */
public abstract class Shape implements Drawable {

    private static final int DEFAULT_VALUE = 1;

    protected Point origin;

    public Shape() {
        moveTo(new Point(0, 0));
    }

    public Shape(int startX, int startY) {
        moveTo(new Point(startX, startY));
    }

    public Shape(Point p) {
        moveTo(p);
    }

    @JsonIgnore
    public abstract double getArea();

    public abstract void rotate();

    /**
     * Moves origin of shape
     *
     * @param p new origin
     */
    @JsonProperty("origin")
    public void moveTo(Point p) {
        origin = p;
    }

    public final Point getOrigin() {
        return origin;
    }

    protected int getValidValue(int r) {
        if (r < 0) {
            return Math.abs(r);
        } else {
            return r != 0 ? r : DEFAULT_VALUE;
        }
    }
}
