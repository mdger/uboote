package game.module.math;

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
public class RationalTest {
    
    public RationalTest() {
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
     * Test of calculateGreatestCommonDivisor method, of class Rational.
     */
    @Test
    public void testCalculateGreatestCommonDivisor() {
        System.out.println("calculateGreatestCommonDivisor");
        int m = 2;
        int n = 4;
        int expResult = 2;
        int result = Rational.calculateGreatestCommonDivisor(m, n);
        assertEquals(expResult, result);
        
        m = 4;
        n = 2;
        expResult = 2;
        result = Rational.calculateGreatestCommonDivisor(m, n);
        assertEquals(expResult, result);
        
        m = 3;
        n = 2;
        expResult = 1;
        result = Rational.calculateGreatestCommonDivisor(m, n);
        assertEquals(expResult, result);
        
        m = 5;
        n = 4;
        expResult = 1;
        result = Rational.calculateGreatestCommonDivisor(m, n);
        assertEquals(expResult, result);
        
        m = 25;
        n = 5;
        expResult = 5;
        result = Rational.calculateGreatestCommonDivisor(m, n);
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class Rational.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        
        Rational a = new Rational(1, 1);
        Rational b = new Rational(2, 2);
        int expResult = 0;
        int result = a.compareTo(b);
        assertEquals(expResult, result);
        
        a = new Rational(2, 1);
        b = new Rational(2, 2);
        expResult = 1;
        result = a.compareTo(b);
        assertEquals(expResult, result);
        
        a = new Rational(1, 2);
        b = new Rational(1, 3);
        expResult = 1;
        result = a.compareTo(b);
        assertEquals(expResult, result);
        
        a = new Rational(1, 5);
        b = new Rational(1, 4);
        expResult = -1;
        result = a.compareTo(b);
        assertEquals(expResult, result);
        
        a = new Rational(2, 10);
        b = new Rational(2, 7);
        expResult = -1;
        result = a.compareTo(b);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Rational.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");

        Rational a = new Rational(2, 10);
        Rational b = new Rational(2, 7);
        boolean expResult = false;
        boolean result = a.equals(b);
        assertEquals(expResult, result);

        a = new Rational(1, 1);
        b = new Rational(2, 2);
        expResult = true;
        result = a.equals(b);
        assertEquals(expResult, result);
    }
}
