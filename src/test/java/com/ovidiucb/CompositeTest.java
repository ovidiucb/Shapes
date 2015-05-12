package com.ovidiucb;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by ovidiucb
 */
public class CompositeTest extends TestCase {

    private Shape shape;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CompositeTest(String testName) {
        super(testName);
        shape = new Rectangle();
        setUp();
    }

    @Override
    public void setUp() {
        try {
            super.setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        shape.getSubShapes().clear();

        Circle circle = new Circle();

        circle.addSubShape(new Line());
        shape.addSubShape(circle);

        Square square = new Square();
        square.addSubShape(new Circle());

        shape.addSubShape(square);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CompositeTest.class);
    }

    public void testComposite()
    {
        String actual = shape.draw();
        String expected = "Rectangle::draw(): ((0,0), width: 1, height 1)\n" +
                "Sub Shapes:\n" +
                "Circle::draw(): ((0,0), radius: 1)\n" +
                "Sub Shapes:\n" +
                "Line::draw(): ((0,0),(1,1))\n" +
                "End Sub Shapes\n" +
                "\n" +
                "Square::draw(): ((0,0), length: 1)\n" +
                "Sub Shapes:\n" +
                "Circle::draw(): ((0,0), radius: 1)\n" +
                "End Sub Shapes\n" +
                "\n" +
                "End Sub Shapes\n" +
                "\n";

        assertEquals(expected, actual);
    }

    public void testCompositeAdd()
    {
        shape.addSubShape(new Line());

        String actual = shape.draw();
        String expected = "Rectangle::draw(): ((0,0), width: 1, height 1)\n" +
                "Sub Shapes:\n" +
                "Circle::draw(): ((0,0), radius: 1)\n" +
                "Sub Shapes:\n" +
                "Line::draw(): ((0,0),(1,1))\n" +
                "End Sub Shapes\n" +
                "\n" +
                "Square::draw(): ((0,0), length: 1)\n" +
                "Sub Shapes:\n" +
                "Circle::draw(): ((0,0), radius: 1)\n" +
                "End Sub Shapes\n" +
                "\n" +
                "Line::draw(): ((0,0),(1,1))\n" +
                "End Sub Shapes\n" +
                "\n";

        assertEquals(expected, actual);
    }

    public void testCompositeRemove()
    {
        Shape toRemove = shape.getSubShapes().get(0);

        shape.remove(toRemove);

        String actual = shape.draw();
        String expected = "Rectangle::draw(): ((0,0), width: 1, height 1)\n" +
                "Sub Shapes:\n" +
                "Square::draw(): ((0,0), length: 1)\n" +
                "Sub Shapes:\n" +
                "Circle::draw(): ((0,0), radius: 1)\n" +
                "End Sub Shapes\n" +
                "\n" +
                "End Sub Shapes\n" +
                "\n";

        assertEquals(expected, actual);
    }

    public void testCompositeRemoveAll()
    {
        shape.getSubShapes().clear();

        String actual = shape.draw();
        String expected = "Rectangle::draw(): ((0,0), width: 1, height 1)\n";

        assertEquals(expected, actual);
    }
}