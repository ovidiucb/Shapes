package com.ovidiucb.shapes;

import com.ovidiucb.shapes.shapes.Circle;
import com.ovidiucb.shapes.shapes.EnumColor;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by ovidiucb
 */
public class CircleTest extends AppTest {

    private Circle circle;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CircleTest(String testName) {
        super(testName);
        circle = (Circle) shapeMap.get("circle");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CircleTest.class);
    }

    public void testDefaultValues() {
        super.testDefaults(circle);

        assertEquals(1, circle.getRadius());

        assertEquals(EnumColor.WHITE, circle.getFillColor());
    }

    public void testArea() {
        assertEquals(3.14, circle.getArea());
    }
}