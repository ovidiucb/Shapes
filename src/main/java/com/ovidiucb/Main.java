package com.ovidiucb;

import com.ovidiucb.serializers.SerializerBuilder;
import com.ovidiucb.shapes.CompositeShape;
import com.ovidiucb.helpers.ShapeGenerator;
import com.ovidiucb.visitors.VisitableShape;

public class Main {
    private static final int MAX_NUMBER_SHAPES = 1;

    public static void main(String[] args) {
        // write your code here
        CompositeShape graphic1 = new CompositeShape();
        CompositeShape graphic2 = new CompositeShape();

        graphic1.addAll(ShapeGenerator.generateShapes(MAX_NUMBER_SHAPES));
        graphic2.addAll(ShapeGenerator.generateShapes(MAX_NUMBER_SHAPES));
        graphic1.add(graphic2);

        System.out.println(graphic1.draw());

        VisitableShape visitableCompositeShape = new VisitableShape(graphic1);

        visitableCompositeShape.accept(SerializerBuilder.buildJSONSerializer());
    }
}
