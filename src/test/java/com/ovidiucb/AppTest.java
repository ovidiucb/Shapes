package com.ovidiucb;

import com.ovidiucb.shapes.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;
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
        super(testName);
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

    protected void testDefaults(Shape shape) {
        Point origin  = shape.getOrigin();

        assertEquals(origin.getX(), 0);
        assertEquals(origin.getY(), 0);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
