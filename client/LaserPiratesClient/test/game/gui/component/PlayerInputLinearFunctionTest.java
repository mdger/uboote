package game.gui.component;

import game.controller.LevelController;
import game.level.SubmitObject;
import game.module.geometry.shape.LinearFunction;
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
public class PlayerInputLinearFunctionTest {
    
    public PlayerInputLinearFunctionTest() {
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
     * Test of draw method, of class PlayerInputLinearFunction.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        PlayerInputLinearFunction instance = new PlayerInputLinearFunction();
        instance.draw();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handle method, of class PlayerInputLinearFunction.
     */
    @Test
    public void testHandle() {
        System.out.println("handle");
        MouseEvent event = null;
        PlayerInputLinearFunction instance = new PlayerInputLinearFunction();
        instance.handle(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubmitInput method, of class PlayerInputLinearFunction.
     */
    @Test
    public void testGetSubmitInput() {
        System.out.println("getSubmitInput");
        LevelController levelController = null;
        PlayerInputLinearFunction instance = new PlayerInputLinearFunction();
        Node expResult = null;
        Node result = instance.getSubmitInput(levelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of submitFunction method, of class PlayerInputLinearFunction.
     */
    @Test
    public void testSubmitFunction() {
        System.out.println("submitFunction");
        LevelController levelController = null;
        PlayerInputLinearFunction instance = new PlayerInputLinearFunction();
        SubmitObject<LinearFunction> expResult = null;
        SubmitObject<LinearFunction> result = instance.submitFunction(levelController);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
