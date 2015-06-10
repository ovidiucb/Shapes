package com.ovidiucb.shapes.serializers;

import com.ovidiucb.shapes.interfaces.Drawable;

/**
 * Created by ovidiucb
 */
public class VisitableShape {
    protected Drawable shape;

    public VisitableShape(Drawable shape) {
        this.shape = shape;
    }

    public String accept(ShapeSerializer visitor) {
        return visitor.visit(shape);
    }
}
