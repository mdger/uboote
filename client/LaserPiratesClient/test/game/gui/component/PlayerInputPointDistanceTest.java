package game.gui.component;

import game.controller.LevelController;
import game.level.SubmitObject;
import game.module.geometry.shape.Point;
import javafx.scene.Node;
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
public class PlayerInputPointDistanceTest {
    
    public PlayerInputPointDistanceTest() {
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
     * Test of getSubmitInput method, of class PlayerInputPointDistance.
     */
    @Test
    public void testGetSubmitInput() {
        System.out.println("getSubmitInput");
        LevelController levelController = null;
        PlayerInputPointDistance instance = new PlayerInputPointDistance();
        Node expResult = null;
        Node result = instance.getSubmitInput(levelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of submitFunction method, of class PlayerInputPointDistance.
     */
    @Test
    public void testSubmitFunction() {
        System.out.println("submitFunction");
        LevelController levelController = null;
        PlayerInputPointDistance instance = new PlayerInputPointDistance();
        SubmitObject<Point> expResult = null;
        SubmitObject<Point> result = instance.submitFunction(levelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFieldInput method, of class PlayerInputPointDistance.
     */
    @Test
    public void testGetFieldInput() {
        System.out.println("getFieldInput");
        PlayerInputPointDistance instance = new PlayerInputPointDistance();
        NumberFieldInput expResult = null;
        NumberFieldInput result = instance.getFieldInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
