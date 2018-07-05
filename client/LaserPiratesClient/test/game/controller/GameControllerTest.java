package game.controller;

import game.gui.component.GameRenderer;
import javafx.beans.value.ObservableValue;
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
public class GameControllerTest {
    
    public GameControllerTest() {
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
     * Test of onLevelCompleted method, of class GameController.
     */
    @Test
    public void testOnLevelCompleted() {
        System.out.println("onLevelCompleted");
        GameController instance = new GameController();
        instance.onLevelCompleted();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameRenderer method, of class GameController.
     */
    @Test
    public void testGetGameRenderer() {
        System.out.println("getGameRenderer");
        GameController instance = new GameController();
        GameRenderer expResult = null;
        GameRenderer result = instance.getGameRenderer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevelController method, of class GameController.
     */
    @Test
    public void testGetLevelController() {
        System.out.println("getLevelController");
        GameController instance = new GameController();
        LevelController expResult = null;
        LevelController result = instance.getLevelController();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changed method, of class GameController.
     */
    @Test
    public void testChanged() {
        System.out.println("changed");
        ObservableValue<? extends Object> observable = null;
        Object oldValue = null;
        Object newValue = null;
        GameController instance = new GameController();
        instance.changed(observable, oldValue, newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentLevel method, of class GameController.
     */
    @Test
    public void testSetCurrentLevel() {
        System.out.println("setCurrentLevel");
        int currentLevel = 0;
        GameController instance = new GameController();
        instance.setCurrentLevel(currentLevel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
