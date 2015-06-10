package com.ovidiucb.shapes.interfaces;

import com.ovidiucb.shapes.shapes.EnumColor;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Interface for objects that ca be filled with some color
 * Created by ovidiucb
 */
public interface Fillable {
    @JsonProperty("fillColor")
    void fill(EnumColor color);

    @JsonProperty("fillColor")
    EnumColor getFillColor();
}
