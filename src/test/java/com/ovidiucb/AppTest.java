package com.ovidiucb;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    protected Map<String, Shape> shapeMap;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        shapeMap = new HashMap<String,Shape>();
        setUp();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Initial setup
     */
    @Override
    public void setUp() {
        try {
            super.setUp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        shapeMap.clear();
        shapeMap.put("circle", new Circle());
        shapeMap.put("rectangle", new Rectangle());
        shapeMap.put("square", new Square());
        shapeMap.put("line", new Line());
    }

    protected void setUpSubShapes(Shape s) {
        s.addSubShape(new Circle());
        s.addSubShape(new Rectangle());
        s.addSubShape(new Square());
        s.addSubShape(new Line());
    }

    protected void removeSubShapesByIndex(Shape s) {
        while(!s.getSubShapes().isEmpty()) {
            s.remove(0);
        }
    }

    protected void removeSubShapesByObject(Shape s) {
        while(!s.getSubShapes().isEmpty()) {
            Shape shape = s.getSubShapes().get(0);
            s.remove(shape);
        }
    }

    protected void testDefaults(Shape shape) {
        Point origin  = shape.getOrigin();

        assertEquals(origin.getX(), 0);
        assertEquals(origin.getY(), 0);
    }

    protected void testSubShapes(Shape shape) {
        setUpSubShapes(shape);

        assertEquals(4, shape.getSubShapes().size());
        assertEquals(false, shape.isLeaf());

        removeSubShapesByIndex(shape);

        assertEquals(0, shape.getSubShapes().size());
        assertEquals(true, shape.isLeaf());

        setUpSubShapes(shape);

        assertEquals(4, shape.getSubShapes().size());
        assertEquals(false, shape.isLeaf());

        removeSubShapesByObject(shape);

        assertEquals(0, shape.getSubShapes().size());
        assertEquals(true, shape.isLeaf());
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
