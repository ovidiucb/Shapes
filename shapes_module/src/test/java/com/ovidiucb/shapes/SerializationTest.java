package com.ovidiucb.shapes;

import com.ovidiucb.shapes.interfaces.Drawable;
import com.ovidiucb.shapes.serializers.SerializerBuilder;
import com.ovidiucb.shapes.serializers.VisitableShape;
import com.ovidiucb.shapes.shapes.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

/**
 * Created by ovidiucb
 */
public class SerializationTest extends TestCase {

    private CompositeShape composite;
    private VisitableShape visitableShape;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SerializationTest(String testName) {
        super(testName);
        composite = new CompositeShape("");
        setUp();
    }

    @Override
    public void setUp() {
        try {
            super.setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }

        composite.getCompositionElements().clear();

        composite.add(new Circle());
        composite.add(new Rectangle());
        composite.add(new Square());
        composite.add(new Line());

        CompositeShape subComposite = new CompositeShape("");
        subComposite.add(new Point());

        composite.add(subComposite);

        visitableShape = new VisitableShape(composite);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SerializationTest.class);
    }

    public void testSerialization() {
        String actualJSON = visitableShape.accept(SerializerBuilder.buildJSONSerializer());

        String expectedJSON = "{\"@class\":\"com.ovidiucb.shapes.shapes.CompositeShape\", \"name\":\"\", \"children\": [{\"@class\":\"com.ovidiucb.shapes.shapes.Circle\",\"radius\":1,\"fillColor\":\"WHITE\",\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},\n" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Rectangle\",\"height\":1,\"width\":1,\"fillColor\":\"WHITE\",\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},\n" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Square\",\"height\":1,\"width\":1,\"fillColor\":\"WHITE\",\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},\n" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Line\",\"end\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":1,\"y\":1},\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},\n" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.CompositeShape\", \"name\":\"\", \"children\": [{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}]}]}";

        assertEquals(expectedJSON, actualJSON);
    }

    public void testDeserialization() {
        String serializedJSON = "{\"@class\":\"com.ovidiucb.shapes.shapes.CompositeShape\", \"name\":\"\", \"children\": [{\"@class\":\"com.ovidiucb.shapes.shapes.Circle\",\"radius\":1,\"fillColor\":\"WHITE\",\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},\n" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Rectangle\",\"height\":1,\"width\":1,\"fillColor\":\"WHITE\",\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},\n" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Square\",\"height\":1,\"width\":1,\"fillColor\":\"WHITE\",\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},\n" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Line\",\"end\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":1,\"y\":1},\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},\n" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.CompositeShape\", \"name\":\"\", \"children\": [{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}]}]}";

        ObjectMapper mapper = new ObjectMapper();
        Drawable composite = null;

        try {
            composite = mapper.readValue(serializedJSON, Drawable.class);
            System.out.println(composite.draw());
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        String expected = "Sub Shapes:\n" +
                "\n" +
                "Circle::draw(): ((0,0), radius: 1)\n" +
                "Rectangle::draw(): ((0,0), width: 1, height 1)\n" +
                "Square::draw(): ((0,0), length: 1)\n" +
                "Line::draw(): ((0,0),(1,1))\n" +
                "Sub Shapes:\n" +
                "\n" +
                "Point::draw(): (0,0)\n" +
                "\n" +
                "End Sub Shapes\n" +
                "\n" +
                "End Sub Shapes\n";
        String actual = composite.draw();

        assertEquals(expected, actual);
    }
}
