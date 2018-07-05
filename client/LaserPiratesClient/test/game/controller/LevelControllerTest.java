package game.controller;

import game.gui.level.AbstractLevelRenderer;
import game.gui.level.BackgroundRenderer;
import game.level.AbstractLevel;
import game.level.SubmitObject;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
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
public class LevelControllerTest {
    
    public LevelControllerTest() {
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
     * Test of buildLevel method, of class LevelController.
     */
    @Test
    public void testBuildLevel() {
        System.out.println("buildLevel");
        LevelState state = null;
        LevelController instance = null;
        instance.buildLevel(state);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayerInput method, of class LevelController.
     */
    @Test
    public void testGetPlayerInput() {
        System.out.println("getPlayerInput");
        LevelController instance = null;
        Node expResult = null;
        Node result = instance.getPlayerInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWrapper method, of class LevelController.
     */
    @Test
    public void testGetWrapper() {
        System.out.println("getWrapper");
        LevelController instance = null;
        Pane expResult = null;
        Pane result = instance.getWrapper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevelRenderer method, of class LevelController.
     */
    @Test
    public void testGetLevelRenderer() {
        System.out.println("getLevelRenderer");
        LevelController instance = null;
        AbstractLevelRenderer expResult = null;
        AbstractLevelRenderer result = instance.getLevelRenderer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBackground method, of class LevelController.
     */
    @Test
    public void testGetBackground() {
        System.out.println("getBackground");
        LevelController instance = null;
        Canvas expResult = null;
        Canvas result = instance.getBackground();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevel method, of class LevelController.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        LevelController instance = null;
        AbstractLevel expResult = null;
        AbstractLevel result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of onInputSubmit method, of class LevelController.
     */
    @Test
    public void testOnInputSubmit() {
        System.out.println("onInputSubmit");
        SubmitObject submit = null;
        LevelController instance = null;
        instance.onInputSubmit(submit);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBackgroundLayer method, of class LevelController.
     */
    @Test
    public void testGetBackgroundLayer() {
        System.out.println("getBackgroundLayer");
        LevelController instance = null;
        BackgroundRenderer expResult = null;
        BackgroundRenderer result = instance.getBackgroundLayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
