package game.gui.component;

import game.controller.LevelController;
import game.level.SubmitObject;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
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
public class PlayerInputLineTest {
    
    public PlayerInputLineTest() {
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
     * Test of draw method, of class PlayerInputLine.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        PlayerInputLine instance = null;
        instance.draw();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetInput method, of class PlayerInputLine.
     */
    @Test
    public void testResetInput() {
        System.out.println("resetInput");
        PlayerInputLine instance = null;
        instance.resetInput();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNormalizedStartPoint method, of class PlayerInputLine.
     */
    @Test
    public void testGetNormalizedStartPoint() {
        System.out.println("getNormalizedStartPoint");
        PlayerInputLine instance = null;
        Point expResult = null;
        Point result = instance.getNormalizedStartPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNormalizedEndPoint method, of class PlayerInputLine.
     */
    @Test
    public void testGetNormalizedEndPoint() {
        System.out.println("getNormalizedEndPoint");
        PlayerInputLine instance = null;
        Point expResult = null;
        Point result = instance.getNormalizedEndPoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handle method, of class PlayerInputLine.
     */
    @Test
    public void testHandle() {
        System.out.println("handle");
        MouseEvent event = null;
        PlayerInputLine instance = null;
        instance.handle(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubmitInput method, of class PlayerInputLine.
     */
    @Test
    public void testGetSubmitInput() {
        System.out.println("getSubmitInput");
        LevelController levelController = null;
        PlayerInputLine instance = null;
        Node expResult = null;
        Node result = instance.getSubmitInput(levelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of submitFunction method, of class PlayerInputLine.
     */
    @Test
    public void testSubmitFunction() {
        System.out.println("submitFunction");
        LevelController levelController = null;
        PlayerInputLine instance = null;
        SubmitObject<LinearFunction> expResult = null;
        SubmitObject<LinearFunction> result = instance.submitFunction(levelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
