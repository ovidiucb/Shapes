package com.ovidiucb.shapes.shapes;

import com.ovidiucb.shapes.interfaces.Fillable;

/**
 * Base class for shapes that can be filled with color
 * Created by ovidiucb
 */
public abstract class FillableShape extends Shape implements Fillable {
    protected EnumColor fillColor;

    public FillableShape() {
        super();
        setDefaultFillColor();
    }

    public FillableShape(int startX, int startY) {
        super(startX, startY);
        setDefaultFillColor();
    }

    public FillableShape(Point p) {
        super(p);
        setDefaultFillColor();
    }

    public void fill(EnumColor color) {
        this.fillColor = color;
    }

    public EnumColor getFillColor() {
        return fillColor;
    }

    private void setDefaultFillColor() {
        fillColor = EnumColor.WHITE;
    }
}
