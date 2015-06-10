package com.ovidiucb.shapes.interfaces;

import com.ovidiucb.shapes.shapes.*;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * Interface for objects that can be drawn
 * Created by ovidiucb
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CompositeShape.class, name = "CompositeShape"),
        @JsonSubTypes.Type(value = Circle.class,         name = "Circle"),
        @JsonSubTypes.Type(value = Square.class,         name = "Square"),
        @JsonSubTypes.Type(value = Rectangle.class,      name = "Rectangle"),
        @JsonSubTypes.Type(value = Line.class,           name = "Line"),
        @JsonSubTypes.Type(value = Point.class,          name = "Point") })
public interface Drawable {
    String draw();
}
