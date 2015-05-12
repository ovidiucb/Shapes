package com.ovidiucb;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int MAX_NUMBER_SHAPES = 10;

    public static void main(String[] args) {
        // write your code here
        List<Shape> shapes = (ArrayList<Shape>) ShapeGenerator.generateShapes(MAX_NUMBER_SHAPES);

        for(Shape s : shapes) {
            s.draw();
        }
    }
}
