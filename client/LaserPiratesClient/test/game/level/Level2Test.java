package game.level;

import game.controller.LevelState;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
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
public class Level2Test {
    
    private static Level2 instance = null;
    
    public Level2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
        instance = new Level2();
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
     * Test of getWinCondition method, of class Level2.
     */
    @Test
    public void testGetWinCondition() {
        System.out.println("getWinCondition");
        Level2 instance = new Level2();
        int expResult = 5;
        int result = instance.getWinCondition();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCurrentState method, of class Level2.
     */
    @Test
    public void testGetCurrentState() {
        System.out.println("getCurrentState");
        LevelState expResult = LevelState.LEVEL_2;
        LevelState result = instance.getCurrentState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNextLevelState method, of class Level2.
     */
    @Test
    public void testGetNextLevelState() {
        System.out.println("getNextLevelState");
        LevelState expResult = LevelState.LEVEL_3;
        LevelState result = instance.getNextLevelState();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBriefing method, of class Level2.
     */
    @Test
    public void testGetBriefing() {
        System.out.println("getBriefing");
        Node result = instance.getBriefing();
        assertTrue(result instanceof VBox);
    }
    
}
