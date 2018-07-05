package game.level;

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
public class FunctionGeneratorConfigTest {
    
    private static FunctionGeneratorConfig instance = null;
    
    public FunctionGeneratorConfigTest() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
        instance = new FunctionGeneratorConfig();
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
     * Test of getMaxValue method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testGetMaxValue() {
        System.out.println("getMaxValue");
        int expResult = 20;
        int result = instance.getMaxValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxValue method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testSetMaxValue() {
        System.out.println("setMaxValue");
        int max = 20;
        instance.setMaxValue(max);
    }

    /**
     * Test of setAx method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testSetAx() {
        System.out.println("setAx");
        int ax = 10;
        instance.setAx(ax);
        assertEquals(instance.getAx(), ax);
    }

    /**
     * Test of setAy method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testSetAy() {
        System.out.println("setAy");
        int ay = 10;
        instance.setAy(ay);
        assertEquals(instance.getAy(), ay);
    }

    /**
     * Test of setBx method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testSetBx() {
        System.out.println("setBx");
        int bx = 5;
        instance.setBx(bx);
        assertEquals(instance.getBx(), bx);
    }

    /**
     * Test of setBy method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testSetBy() {
        System.out.println("setBy");
        int by = 6;
        instance.setBy(by);
        assertEquals(instance.getBy(), by);
    }

    /**
     * Test of getAx method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testGetAx() {
        System.out.println("getAx");
        int expResult = 0;
        int result = instance.getAx();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAy method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testGetAy() {
        System.out.println("getAy");
        int expResult = 0;
        int result = instance.getAy();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBx method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testGetBx() {
        System.out.println("getBx");
        int expResult = 0;
        int result = instance.getBx();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBy method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testGetBy() {
        System.out.println("getBy");
        int expResult = 0;
        int result = instance.getBy();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMaxIntercept method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testSetMaxIntercept() {
        System.out.println("setMaxIntercept");
        int maxIntercept = 20;
        instance.setMaxIntercept(maxIntercept);
        assertEquals(instance.getMaxIntercept(), maxIntercept);
    }

    /**
     * Test of getMaxIntercept method, of class FunctionGeneratorConfig.
     */
    @Test
    public void testGetMaxIntercept() {
        System.out.println("getMaxIntercept");
        int expResult = 0;
        int result = instance.getMaxIntercept();
        assertEquals(expResult, result);
    }
    
}
