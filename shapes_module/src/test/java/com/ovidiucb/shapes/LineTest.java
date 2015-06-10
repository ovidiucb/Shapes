package com.ovidiucb.shapes;

import com.ovidiucb.shapes.shapes.Line;
import com.ovidiucb.shapes.shapes.Point;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Created by ovidiucb
 */
public class LineTest extends AppTest {

    private Line line;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LineTest(String testName) {
        super(testName);
        line = (Line) shapeMap.get("line");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(LineTest.class);
    }

    public void testDefaultValues() {
        super.testDefaults(line);

        Point end = line.getEnd();

        assertEquals(end.getX(), 1);
        assertEquals(end.getY(), 1);
    }

    public void testArea() {
        assertEquals(1.4142135623730951, line.getArea());
    }
}