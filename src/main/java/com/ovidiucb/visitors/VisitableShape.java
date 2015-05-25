package com.ovidiucb.visitors;

import com.ovidiucb.interfaces.Drawable;

/**
 * Created by ovidiucb
 */
public class VisitableShape {
    protected Drawable shape;

    public VisitableShape(Drawable shape) {
        this.shape = shape;
    }

    public void accept(ShapeVisitor visitor) {
        visitor.visit(shape);
    }
}
