package com.ovidiucb.visitors;

/**
 * Created by ovidiucb
 */
public interface Visitable {
    void accept(ShapeVisitor visitor);
}
