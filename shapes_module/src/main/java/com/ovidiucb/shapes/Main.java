package com.ovidiucb.shapes;

import com.ovidiucb.shapes.helpers.ShapeGenerator;
import com.ovidiucb.shapes.serializers.SerializerBuilder;
import com.ovidiucb.shapes.shapes.CompositeShape;
import com.ovidiucb.shapes.serializers.VisitableShape;

public class Main {
    private static final int MAX_NUMBER_SHAPES = 1;

    public static void main(String[] args) {
        // write your code here
        CompositeShape graphic1 = new CompositeShape("g1");
        CompositeShape graphic2 = new CompositeShape("g2");

        graphic1.addAll(ShapeGenerator.generateShapes(MAX_NUMBER_SHAPES));
        graphic2.addAll(ShapeGenerator.generateShapes(MAX_NUMBER_SHAPES));
        graphic1.add(graphic2);

        System.out.println(graphic1.draw());

        VisitableShape visitableCompositeShape = new VisitableShape(graphic1);

        System.out.println(visitableCompositeShape.accept(SerializerBuilder.buildJSONSerializer()));

    }
}