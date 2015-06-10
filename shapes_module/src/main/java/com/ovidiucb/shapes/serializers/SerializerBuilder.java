package com.ovidiucb.shapes.serializers;


/**
 * Created by ovidiucb
 */
public class SerializerBuilder {
    public static ShapeSerializer buildJSONSerializer() {
        return new ShapeSerializer.ShapeJSONSerializer();
    }
}
