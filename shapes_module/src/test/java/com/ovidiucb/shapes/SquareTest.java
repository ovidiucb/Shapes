package com.ovidiucb.shapes;

import com.ovidiucb.shapes.shapes.EnumColor;
import com.ovidiucb.shapes.shapes.Square;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by ovidiucb
 */
public class SquareTest extends AppTest {

    private Square square;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SquareTest(String testName) {
        super(testName);
        square = (Square) shapeMap.get("square");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SquareTest.class);
    }

    public void testDefaultValues() {
        super.testDefaults(square);

        assertEquals(1, square.getWidth());
        assertEquals(1, square.getHeight());

        square.setWidth(2);
        assertEquals(2, square.getHeight());

        square.setHeight(3);
        assertEquals(3, square.getWidth());

        assertEquals(EnumColor.WHITE, square.getFillColor());
    }

    public void testArea() {
        assertEquals(1.0, square.getArea());
    }
}