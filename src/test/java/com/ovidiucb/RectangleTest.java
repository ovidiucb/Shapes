package com.ovidiucb;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by ovidiucb
 */
public class RectangleTest extends AppTest {

    private Rectangle rectangle;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RectangleTest(String testName)
    {
        super( testName );
        rectangle = (Rectangle) shapeMap.get("rectangle");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RectangleTest.class );
    }

    public void testDefaultValues() {
        super.testDefaults(rectangle);

        assertEquals(1, rectangle.getWidth());
        assertEquals(1, rectangle.getHeight());

        assertEquals(EnumColor.WHITE, rectangle.getFillColor());
    }

    public void testSubShapes() {
        super.testSubShapes(rectangle);
    }

    public void testArea() {
        assertEquals(1.0, rectangle.getArea());
    }
}