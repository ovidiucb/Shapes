package com.ovidiucb;

/**
 * Created by ovidiucb
 */
public class Square extends Rectangle {
    public Square() {
        super();
    }

    public Square(Point p, int length) {
        super(p, length, length);
    }

    @Override
    public void rotate() {
    }

    @Override
    public void setHeight(int val) {
        super.setHeight(val);
        width = getHeight();
    }

    @Override
    public void setWidth(int val) {
        super.setWidth(val);
        height = getWidth();
    }

    @Override
    public String draw() {
        String drawing = "";
        drawing += "Square::draw(): " + toString() + "\n";
        drawing += drawSubShapes();

        System.out.println(drawing);

        return drawing;
    }

    @Override
    public String toString() {
        return "(" + getOrigin().toString() + ", length: " + getWidth() + ")";
    }
}
