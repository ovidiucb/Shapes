package com.ovidiucb.shapes.serializers;

import com.ovidiucb.shapes.interfaces.Drawable;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by ovidiucb
 */
public interface ShapeSerializer {

    String visit(Drawable shape);

    class ShapeJSONSerializer implements ShapeSerializer {

        private ObjectMapper mapper = new ObjectMapper();


        public String visit(Drawable shape) {
            StringBuilder sb = new StringBuilder();

            sb.append(serialize(shape));

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
