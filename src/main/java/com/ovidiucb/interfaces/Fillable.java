package com.ovidiucb.interfaces;

import com.ovidiucb.shapes.EnumColor;

/**
 * Interface for objects that ca be filled with some color
 * Created by ovidiucb
 */
public interface Fillable {
    void fill(EnumColor color);
    EnumColor getFillColor();
}
