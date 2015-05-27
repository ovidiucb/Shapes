package com.ovidiucb.helpers;

import com.ovidiucb.shapes.*;

import java.util.Random;

/**
 * Factory class for Shape objects
 * Created by ovidiucb
 */
public class ShapeFactory {

    private static final int MAX_VALUE = 10;

    /**
     * Creates a Shape based on type
     *
     * @param type Shape type
     * @return the newly created Shape
     */
    public static Shape create(String type) {

        type = type.trim();
        Random rand = new Random();

        if (type.equalsIgnoreCase("circle")) {
            Circle circle = new Circle();

            circle.moveTo(new Point(rand.nextInt(MAX_VALUE), rand.nextInt(MAX_VALUE)));
            circle.setRadius(rand.nextInt(MAX_VALUE));

            return circle;
        } else if (type.equalsIgnoreCase("rectangle")) {
            Rectangle rectangle = new Rectangle();

            rectangle.moveTo(new Point(rand.nextInt(MAX_VALUE), rand.nextInt(MAX_VALUE)));
            rectangle.setWidth(rand.nextInt(MAX_VALUE));
            rectangle.setHeight(rand.nextInt(MAX_VALUE));

            return rectangle;
        } else if (type.equalsIgnoreCase("square")) {
            Square square = new Square();

            square.moveTo(new Point(rand.nextInt(MAX_VALUE), rand.nextInt(MAX_VALUE)));
            square.setWidth(rand.nextInt(MAX_VALUE));

            return square;
        } else if (type.equalsIgnoreCase("line")) {
            Line line = new Line();

            line.moveTo(new Point(rand.nextInt(MAX_VALUE), rand.nextInt(MAX_VALUE)));

            return line;
        } else {
            return null;
        }
    }
}
