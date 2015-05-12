package com.ovidiucb;

/**
 * Created by ovidiucb
 */
public class Line extends Shape {

    private Point end;

    public Line() {
        super();
        end = new Point(1, 1);
    }

    public Line(Point start, Point end) {
        super(start);
        this.end = end;
    }

    public Line(Line l) {
        origin = l.getOrigin();
        end = l.getEnd();
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public String draw() {
        String drawing = "";

        drawing += "Line::draw(): " + toString() + "\n";
        System.out.println(drawing);

        return drawing;
    }

    @Override
    public double getArea() {
        return Math.sqrt(Math.pow(Math.abs(origin.getX() - end.getX()),2)
                + Math.pow(Math.abs(origin.getY() - end.getY()), 2));
    }

    @Override
    public void rotate() {
        Point tmp = origin;
        origin = end;
        end = tmp;
    }

    @Override
    public String toString() {
        return "(" + getOrigin().toString() + "," + getEnd().toString() + ")";
    }
}
