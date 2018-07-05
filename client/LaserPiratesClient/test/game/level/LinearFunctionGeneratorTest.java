package game.level;

import game.module.geometry.shape.LinearFunction;
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
public class LinearFunctionGeneratorTest {
    
    public LinearFunctionGeneratorTest() {
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
     * Test of generateLinearFunction method, of class LinearFunctionGenerator.
     */
    @Test
    public void testGenerateFunction() {
        int max = 40;
        int iterations = 100000;
        
        System.out.println("generateFunction");
        int coordinateMax = max / 2;
        FunctionGeneratorConfig config = new FunctionGeneratorConfig();
        config.setMaxValue(19);
        LinearFunction linearFunction = LinearFunctionGenerator.generateLinearFunction(config);
        
        
        for (int i = 1; i <= iterations; i++) {
            try {
                linearFunction = LinearFunctionGenerator.generateLinearFunction(new FunctionGeneratorConfig());
            } catch(Exception e) {
                System.out.println(e.getMessage());
                fail("Konnte keine 1000 gültige Geraden generieren.");
            }
            
            if (Math.abs(linearFunction.getPointStart().getX()) > coordinateMax) {
                fail("Point Start X is greater than max");
            }
            
            try {
                linearFunction.getSlope();
            } catch (Exception e) {
                fail(e.getMessage());
            }
            
            if (Math.abs(linearFunction.getPointStart().getY()) > coordinateMax) {
                fail("Point Start Y is greater than max");
            }
            
            if (Math.abs(linearFunction.getPointEnd().getX()) > coordinateMax) {
                fail("Point End X is greater than max");
            }
            
            if (Math.abs(linearFunction.getPointEnd().getY()) > coordinateMax) {
                fail("Point End Y is greater than max");
            }
            
            System.out.println("Function Nr. " + i);
            System.out.println("Point A: " + linearFunction.getPointStart().toString() + " Point B: " + linearFunction.getPointEnd().toString());
            System.out.println("Slope: " + linearFunction.getSlope() + " Intercept: " + linearFunction.getIntercept());
        }
    }
    
}
