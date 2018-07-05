package game.module.geometry.shape;

import game.module.math.Rational;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mary
 */
public class PointTest {
    
    private static Point instance = null;
    
    public PointTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new Point(2,2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setLocation method, of class Point.
     */
    @Test
    public void testSetLocation_int_int() {
        System.out.println("setLocation");
        instance.setLocation(3, 4);
        assertEquals(instance.getX(), 3);
        assertEquals(instance.getY(), 4);
    }

    /**
     * Test of offsetLocation method, of class Point.
     */
    @Test
    public void testOffsetLocation() {
        System.out.println("offsetLocation");
        int offsetX = 3;
        int offsetY = 4;
        Point offsetPoint = instance.offsetLocation(offsetX, offsetY);
        assertEquals(offsetPoint.getX(), 5);
        assertEquals(offsetPoint.getY(), 6);
    }

    /**
     * Test of offsetX method, of class Point.
     */
    @Test
    public void testOffsetX() {
        System.out.println("offsetX");
        int offsetX = 3;
        Point offsetPoint = instance.offsetX(offsetX);
        assertEquals(offsetPoint.getX(), 5);
        assertEquals(offsetPoint.getY(), 2);
    }

    /**
     * Test of offsetY method, of class Point.
     */
    @Test
    public void testOffsetY() {
        System.out.println("offsetY");
        int offsetY = 3;
        Point offsetPoint = instance.offsetY(offsetY);
        assertEquals(offsetPoint.getX(), 2);
        assertEquals(offsetPoint.getY(), 5);
    }

    /**
     * Test of setLocation method, of class Point.
     */
    @Test
    public void testSetLocation_Point() {
        System.out.println("setLocation");
        Point newPoint = new Point(5,6);
        instance.setLocation(newPoint);
        assertEquals(instance.getX(), 5);
        assertEquals(instance.getY(), 6);
    }

    /**
     * Test of getX method, of class Point.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        assertEquals(instance.getX(), 2);
    }

    /**
     * Test of getY method, of class Point.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        assertEquals(instance.getY(), 2);
    }

    /**
     * Test of setX method, of class Point.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        instance.setX(3);
        assertEquals(instance.getX(), 3);
    }

    /**
     * Test of setY method, of class Point.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        instance.setY(3);
        assertEquals(instance.getY(), 3);
    }

    /**
     * Test of factor method, of class Point.
     */
    @Test
    public void testFactor_int() {
        System.out.println("factor");
        Point factorPoint = instance.factor(4);
        assertEquals(factorPoint.getX(), 8);
        assertEquals(factorPoint.getY(), 8);
    }

    /**
     * Test of factor method, of class Point.
     */
    @Test
    public void testFactor_Rational() {
        System.out.println("factor");
        Rational rational = new Rational(1,2);
        Point factorPoint = instance.factor(rational);
        assertEquals(factorPoint.getX(), 2);
        assertEquals(factorPoint.getY(), 4);
    }
    
}
