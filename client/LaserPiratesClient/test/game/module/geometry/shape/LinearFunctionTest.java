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
 * @author Marco
 */
public class LinearFunctionTest {
    
    public LinearFunctionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSlope method, of class LinearFunction.
     */
    @Test
    public void testGetSlope() {
        System.out.println("getSlope");

        Point x = new Point(0, 0);
        Point y = new Point(1, 1);
        LinearFunction instance = new LinearFunction(x, y);
        Rational slopeOfRational = instance.getSlope();
        double expResult = 1.0;
        double result = slopeOfRational.toDouble();
        assertEquals(expResult, result, 0.0);

        x = new Point(0, 4);
        y = new Point(2, 0);
        instance = new LinearFunction(x, y);
        slopeOfRational = instance.getSlope();
        expResult = -2.0;
        result = slopeOfRational.toDouble();
        assertEquals(expResult, result, 0.0);

        x = new Point(0, 0);
        y = new Point(1, 2);
        instance = new LinearFunction(x, y);
        slopeOfRational = instance.getSlope();
        expResult = 2.0;
        result = slopeOfRational.toDouble();
        assertEquals(expResult, result, 0.0);

        x = new Point(1, 1);
        y = new Point(2, 2);
        instance = new LinearFunction(x, y);
        slopeOfRational = instance.getSlope();
        expResult = 1.0;
        result = slopeOfRational.toDouble();
        assertEquals(expResult, result, 0.0);

        x = new Point(0, 0);
        y = new Point(2, 3);
        instance = new LinearFunction(x, y);
        slopeOfRational = instance.getSlope();
        expResult = 1.5;
        result = slopeOfRational.toDouble();
        assertEquals(expResult, result, 0.0);

        x = new Point(0, 0);
        y = new Point(1, 0);
        instance = new LinearFunction(x, y);
        slopeOfRational = instance.getSlope();
        expResult = 0.0;
        result = slopeOfRational.toDouble();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of getIntercept method, of class LinearFunction.
     */
    @Test
    public void testGetIntercept() {
        System.out.println("getIntercept");

        Point x = new Point(0, 0);
        Point y = new Point(1, 1);
        LinearFunction instance = new LinearFunction(x, y);
        int expResult = 0;
        int result = instance.getIntercept();
        assertEquals(expResult, result);

        x = new Point(0, 1);
        y = new Point(1, 1);
        instance = new LinearFunction(x, y);
        expResult = 1;
        result = instance.getIntercept();
        assertEquals(expResult, result);

        x = new Point(2, 8);
        y = new Point(3, 9);
        instance = new LinearFunction(x, y);
        expResult = 6;
        result = instance.getIntercept();
        assertEquals(expResult, result);
    }
    
}
