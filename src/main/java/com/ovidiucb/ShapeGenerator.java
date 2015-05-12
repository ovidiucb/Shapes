package com.ovidiucb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generator of random shapes
 * Created by ovidiucb
 */
public class ShapeGenerator {

    private static final String[] shapeTypes = {"rectangle", "square", "circle", "line"};
    private static final int MAX_SHAPES = 4;

    /**
     * Generates random shapes
     * @param number the number of shapes to be generated
     * @return a list of Shape objects with sub shapes
     */
    public static List generateShapes(int number) {
        List<Shape> shapes = generateNShapes(number);

        for(Shape s : shapes) {
            List<Shape> subShapes = s.getSubShapes();
            subShapes.addAll(generateNShapes(new Random().nextInt(number)));
        }

        return shapes;
    }

    /**
     * Helper method to generate a list of @number shapes
     * @param number
     * @return
     */
    private static List generateNShapes(int number) {
        Random rand = new Random();
        List<Shape> shapes = new ArrayList<Shape>();

        for (int i = 0; i < number; i++) {
            Shape s = ShapeFactory.create(shapeTypes[rand.nextInt(MAX_SHAPES)]);
            if(s != null) {
                shapes.add(s);
            }
        }

        return shapes;
    }
}
