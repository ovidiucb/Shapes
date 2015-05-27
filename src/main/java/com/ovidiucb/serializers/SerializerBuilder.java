package com.ovidiucb.serializers;


/**
 * Created by ovidiucb
 */
public class SerializerBuilder {
    public static ShapeSerializer buildJSONSerializer() {
        return new ShapeSerializer.ShapeJSONSerializer();
    }
}
