package com.ovidiucb;

/**
 * Created by ovidiucb
 */
public class Circle extends Curve {

    private static final int DEFAULT_RADIUS = 1;
    private static final double PI = 3.14;
    private int radius;

    public Circle() {
        super();
        setRadius(DEFAULT_RADIUS);
    }
    public Circle(int startX, int startY) {
        super(startX, startY);
        setRadius(DEFAULT_RADIUS);
    }

    public Circle(int startX, int startY, int radius) {
        super(startX, startY);
        setRadius(radius);
    }

    public Circle(Point p, int radius) {
        super(p);
        setRadius(radius);
    }

    public final int getRadius() {
        return radius;
    }

    public final void setRadius(int radius) {
        this.radius = getValidValue(radius);;
    }

    public void draw() {
        System.out.println("Circle::draw(): " + toString());
        drawSubShapes();
    }

    @Override
    public String toString() {
        return "(" + getOrigin().toString() + ", radius: " + radius + ")";
    }

    @Override
    public void rotate() {}

    @Override
    public double getArea() {
        return PI * Math.pow(radius, 2);
    }
}
