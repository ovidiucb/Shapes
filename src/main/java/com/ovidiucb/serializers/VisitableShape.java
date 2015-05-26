package com.ovidiucb.serializers;

import com.ovidiucb.interfaces.Drawable;

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
