package com.ovidiucb.helpers;

import com.ovidiucb.shapes.Shape;

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
        List<Shape> shapes = new ArrayList<Shape>();
        Random rand = new Random();

        for (int i = 0; i < number; i++) {
            Shape s = ShapeFactory.create(shapeTypes[rand.nextInt(MAX_SHAPES)]);
            if(s != null) {
                shapes.add(s);
            }
        }

        return shapes;
    }
}
