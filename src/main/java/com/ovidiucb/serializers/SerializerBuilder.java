package com.ovidiucb.serializers;

import com.ovidiucb.visitors.ShapeVisitor;

/**
 * Created by ovidiucb
 */
public class SerializerBuilder {
    public static ShapeVisitor buildJSONSerializer() {
        return new ShapeSerializer().new ShapeJSONSerializer();
    }
}
