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

        String expectedJSON = "{\"@class\":\"com.ovidiucb.shapes.shapes.CompositeShape\",\"name\":\"\",\"children\"" +
                ":[{\"@class\":\"com.ovidiucb.shapes.shapes.Circle\",\"radius\":1,\"fillColor\":\"WHITE\",\"origin\":" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}}," +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Rectangle\",\"height\":1,\"width\":1,\"fillColor\":\"WHITE\"," +
                "\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}}," +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Square\",\"height\":1,\"width\":1,\"fillColor\":\"WHITE\"," +
                "\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},{\"@class\":" +
                "\"com.ovidiucb.shapes.shapes.Line\",\"end\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\"," +
                "\"x\":1,\"y\":1},\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}}," +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.CompositeShape\",\"name\":\"\"," +
                "\"children\":[{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}]}]}";

        assertEquals(expectedJSON, actualJSON);
    }

    public void testDeserialization() {
        String serializedJSON = "{\"@class\":\"com.ovidiucb.shapes.shapes.CompositeShape\",\"name\":\"\",\"children\"" +
                ":[{\"@class\":\"com.ovidiucb.shapes.shapes.Circle\",\"radius\":1,\"fillColor\":\"WHITE\",\"origin\":" +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}}," +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Rectangle\",\"height\":1,\"width\":1,\"fillColor\":\"WHITE\"," +
                "\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}}," +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.Square\",\"height\":1,\"width\":1,\"fillColor\":\"WHITE\"," +
                "\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}},{\"@class\":" +
                "\"com.ovidiucb.shapes.shapes.Line\",\"end\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\"," +
                "\"x\":1,\"y\":1},\"origin\":{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}}," +
                "{\"@class\":\"com.ovidiucb.shapes.shapes.CompositeShape\",\"name\":\"\"," +
                "\"children\":[{\"@class\":\"com.ovidiucb.shapes.shapes.Point\",\"x\":0,\"y\":0}]}]}";

        ObjectMapper mapper = new ObjectMapper();
        Drawable composite = null;

        try {
            composite = mapper.readValue(serializedJSON, Drawable.class);
            System.out.println(composite.draw());
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        CompositeShape shape = (CompositeShape) composite;
        assertEquals(5, shape.getCompositionElements().size());

        assertEquals(true, shape.getCompositionElements().get(0) instanceof Circle);
        Circle circle = (Circle) shape.getCompositionElements().get(0);
        assertEquals(1, circle.getRadius());
        assertEquals(0, circle.getOrigin().getX());
        assertEquals(0, circle.getOrigin().getY());
        assertEquals(EnumColor.WHITE, circle.getFillColor());

        assertEquals(true, shape.getCompositionElements().get(1) instanceof Rectangle);
        Rectangle rectangle = (Rectangle) shape.getCompositionElements().get(1);
        assertEquals(1, rectangle.getHeight());
        assertEquals(1, rectangle.getWidth());
        assertEquals(0, rectangle.getOrigin().getX());
        assertEquals(0, rectangle.getOrigin().getY());
        assertEquals(EnumColor.WHITE, rectangle.getFillColor());

        assertEquals(true, shape.getCompositionElements().get(2) instanceof Square);
        Square square = (Square) shape.getCompositionElements().get(2);
        assertEquals(1, square.getHeight());
        assertEquals(1, square.getWidth());
        assertEquals(0, square.getOrigin().getX());
        assertEquals(0, square.getOrigin().getY());
        assertEquals(EnumColor.WHITE, square.getFillColor());

        assertEquals(true, shape.getCompositionElements().get(3) instanceof Line);
        Line line = (Line) shape.getCompositionElements().get(3);
        assertEquals(1, line.getEnd().getX());
        assertEquals(1, line.getEnd().getY());
        assertEquals(0, line.getOrigin().getX());
        assertEquals(0, line.getOrigin().getY());

        assertEquals(true, shape.getCompositionElements().get(4) instanceof CompositeShape);
        CompositeShape c = (CompositeShape) shape.getCompositionElements().get(4);
        assertEquals(1, c.getCompositionElements().size());
    }
}
