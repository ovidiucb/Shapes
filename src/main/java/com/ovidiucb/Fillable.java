package com.ovidiucb;

/**
 * Interface for objects that ca be filled with some color
 * Created by ovidiucb
 */
public interface Fillable {
    void fill(EnumColor color);
    EnumColor getFillColor();
}
