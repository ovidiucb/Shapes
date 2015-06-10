package com.ovidiucb.shapes.shapes;

import com.ovidiucb.shapes.interfaces.Drawable;

/**
 * Created by ovidiucb
 */
public class Point implements Drawable {

    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("Negative X coordinate");
        }
        if (y < 0) {
            throw new IllegalArgumentException("Negative Y coordinate");
        }

        this.x = x;
        this.y = y;
    }

    public final int getX() {
        return x;
    }

    public final void setX(int x) {
        this.x = x;
    }

    public final int getY() {
        return y;
    }

    public final void setY(int y) {
        this.y = y;
    }

    public String draw() {
        String drawing = "";

        drawing += "Point::draw(): " + toString() + "\n";

        return drawing;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }
}
