package com.ovidiucb.serializers;

import com.ovidiucb.interfaces.Drawable;
import com.ovidiucb.visitors.ShapeVisitor;
import com.ovidiucb.shapes.*;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.*;

/**
 * Created by ovidiucb
 */
class ShapeSerializer {

    class ShapeJSONSerializer implements ShapeVisitor {

        private ObjectMapper mapper;
        private BufferedWriter writer;

        ShapeJSONSerializer() {
            mapper = new ObjectMapper();
            try {
                writer = new BufferedWriter(new FileWriter("shapes.json"));
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        public void visit(Drawable shape) {
            if (shape instanceof CompositeShape) {
                CompositeShape compositeShape = (CompositeShape) shape;
                compositeShape.setWasAccessed(true);

                if (!compositeShape.getCompositionElements().isEmpty()) {
                    for (Drawable s : compositeShape.getCompositionElements()) {
                        if(s instanceof CompositeShape) {
                            CompositeShape toSerialize = (CompositeShape) s;
                            if(toSerialize.getWasAccessed()) {
                                continue;
                            }
                            serialize(compositeShape);
                        }
                    }
                }

                compositeShape.setWasAccessed(false);
            } else {
                serialize(shape);
            }
        }

        private void serialize(Drawable drawable) {
            try {
                String serialized = mapper.writeValueAsString(drawable);
                writer.write(serialized);
                writer.flush();
                System.out.println(serialized);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
