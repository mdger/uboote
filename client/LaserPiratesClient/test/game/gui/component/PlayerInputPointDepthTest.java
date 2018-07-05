package game.gui.component;

import game.controller.LevelController;
import game.level.SubmitObject;
import game.module.geometry.shape.Point;
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
public class PlayerInputPointDepthTest {
    
    public PlayerInputPointDepthTest() {
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
     * Test of submitFunction method, of class PlayerInputPointDepth.
     */
    @Test
    public void testSubmitFunction() {
        System.out.println("submitFunction");
        LevelController levelController = null;
        PlayerInputPointDepth instance = new PlayerInputPointDepth();
        SubmitObject<Point> expResult = null;
        SubmitObject<Point> result = instance.submitFunction(levelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
