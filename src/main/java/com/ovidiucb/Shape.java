package com.ovidiucb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ovidiucb
 */
public abstract class Shape implements Drawable {

    private static final int DEFAULT_VALUE = 1;

    protected Point origin;
    protected List<Shape> subShapes;

    public Shape() {
        moveTo( new Point(0, 0));
        initSubShapes();
    }

    public Shape(int startX, int startY) {
        moveTo(new Point(startX, startY));
        initSubShapes();
    }

    public Shape(Point p) {
        moveTo(p);
        initSubShapes();
    }

    public final void addSubShape(Shape s) {
        subShapes.add(s);
    }

    public final void remove(int index) {
        subShapes.remove(index);
    }

    public final void remove(Shape s) {
        subShapes.remove(s);
    }

    public final List<Shape> getSubShapes() {
        return subShapes;
    }

    public final boolean isLeaf() {
        return subShapes.isEmpty();
    }

    public abstract double getArea();
    public abstract void rotate();

    /**
     * Moves origin of shape
     * @param p new origin
     */
    public void moveTo(Point p) {
        origin = p;
    }

    public final Point getOrigin() {
        return origin;
    }

    protected int getValidValue(int r) {
        if(r < 0) {
            return Math.abs(r);
        } else {
            return r != 0 ? r : DEFAULT_VALUE;
        }
    }

    protected String drawSubShapes() {
        String drawing = "";
        if(!isLeaf()) {
            drawing += "Sub Shapes:\n";
            for(Shape s : getSubShapes()) {
                drawing += s.draw();
            }
            drawing += "End Sub Shapes\n\n";
            System.out.println(drawing);
        }

        return  drawing;
    }

    private void initSubShapes() {
        subShapes = new ArrayList<Shape>();
    }
}
