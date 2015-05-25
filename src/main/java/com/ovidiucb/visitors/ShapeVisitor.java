package com.ovidiucb.visitors;

import com.ovidiucb.interfaces.Drawable;

/**
 * Created by ovidiucb
 */
public interface ShapeVisitor {
    void visit(Drawable shape);
}
