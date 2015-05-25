package com.ovidiucb;

import com.ovidiucb.interfaces.Drawable;
import com.ovidiucb.shapes.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by ovidiucb
 */
public class CompositeTest extends TestCase {

    private CompositeShape composite;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CompositeTest(String testName) {
        super(testName);
        composite = new CompositeShape();
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

        CompositeShape subComposite = new CompositeShape();
        subComposite.add(new Point());

        composite.add(subComposite);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CompositeTest.class);
    }

    public void testComposite()
    {
        String actual = composite.draw();
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

        assertEquals(expected, actual);
        assertEquals(5, composite.getCompositionElements().size());
    }

    public void testCompositeAdd()
    {
        composite.add(new Line());

        String actual = composite.draw();
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
                "Line::draw(): ((0,0),(1,1))\n" +
                "\n" +
                "End Sub Shapes\n";

        assertEquals(expected, actual);
        assertEquals(6, composite.getCompositionElements().size());
    }

    public void testCompositeRemove()
    {
        Drawable toRemove = composite.getCompositionElements().get(0);

        composite.remove(toRemove);

        String actual = composite.draw();
        String expected = "Sub Shapes:\n" +
                "\n" +
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

        assertEquals(expected, actual);
        assertEquals(4, composite.getCompositionElements().size());

        composite.remove(0);
        actual = composite.draw();
        expected = "Sub Shapes:\n" +
                "\n" +
                "Square::draw(): ((0,0), length: 1)\n" +
                "Line::draw(): ((0,0),(1,1))\n" +
                "Sub Shapes:\n" +
                "\n" +
                "Point::draw(): (0,0)\n" +
                "\n" +
                "End Sub Shapes\n" +
                "\n" +
                "End Sub Shapes\n";

        assertEquals(expected, actual);
        assertEquals(3, composite.getCompositionElements().size());

    }

    public void testCompositeRemoveAll()
    {
        composite.getCompositionElements().clear();

        String actual = composite.draw();
        String expected = "";

        assertEquals(expected, actual);
        assertEquals(0, composite.getCompositionElements().size());
    }
}