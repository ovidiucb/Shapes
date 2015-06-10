package com.ovidiucb.shapes.shapes;

/**
 * Created by ovidiucb
 */
public class Rectangle extends Polygon {

    private static final int DEFAULT_WIDTH = 1;
    private static final int DEFAULT_HEIGHT = 1;

    protected int width;
    protected int height;

    public Rectangle() {
        super();
        setWidth(DEFAULT_WIDTH);
        setHeight(DEFAULT_HEIGHT);
    }

    public Rectangle(Point p, int width, int height) {
        super(p);
        setWidth(width);
        setHeight(height);
    }

    public final int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = getValidValue(width);
    }

    public final int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = getValidValue(height);
    }

    public String draw() {
        String drawing = "";

        drawing += "Rectangle::draw(): " + toString() + "\n";

        return drawing;
    }

    @Override
    public void rotate() {
        int tmp = width;
        width = height;
        height = tmp;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "(" + getOrigin().toString() + ", width: "
                + getWidth() + ", height " + getHeight() + ")";
    }
}
