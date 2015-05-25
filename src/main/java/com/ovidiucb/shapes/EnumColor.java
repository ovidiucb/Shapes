package com.ovidiucb.shapes;

/**
 * Enum for colors
 * Created by ovidiucb
 */
public enum EnumColor {
    WHITE(0), RED(1), GREEN(1), BLUE(2);

    EnumColor(int color) {
        this.color = color;
    }

    public final int color;
}
