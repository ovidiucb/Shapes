package com.ovidiucb.serializers;

import com.ovidiucb.interfaces.Drawable;
import com.ovidiucb.shapes.CompositeShape;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * Created by ovidiucb
 */
public interface ShapeSerializer {

    String visit(Drawable shape);

    class ShapeJSONSerializer implements ShapeSerializer {

        private ObjectMapper mapper = new ObjectMapper();


        public String visit(Drawable shape) {
            StringBuilder sb = new StringBuilder();

            if (shape instanceof CompositeShape) {
                // TODO: add logic for serializing cyclic dependencies
                CompositeShape compositeShape = (CompositeShape) shape;
                List<Drawable> elements = compositeShape.getCompositionElements();

                sb.append("{name:\""+compositeShape.getName()+"\", children: [");

                for (Drawable drawable : elements) {
                    sb.append(visit(drawable));
                    sb.append(",\n");
                }
                sb.delete(sb.length()-2,sb.length());
                sb.append("]" +
                        "}");

            } else {
                sb.append(serialize(shape));
            }
            return sb.toString();
        }

        private String serialize(Drawable drawable) {
            try {
                return mapper.writeValueAsString(drawable);
            } catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
