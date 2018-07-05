package game.module.game;

import org.junit.Assert;
import org.junit.Test;

public class SuccessCounterTest {
    
    @Test
    public void testCounter() {
        SuccessCounter counter = new SuccessCounter(5, 1);
        Assert.assertFalse(counter.passLevel());
        
        for (int i = 0; i < 5; i++) {
            counter.onGame(true);
        }
        Assert.assertTrue(counter.passLevel());
        
        counter.onGame(false);
        counter.onGame(false);
        Assert.assertFalse(counter.passLevel());
    }
    
    @Test
    public void testMultipleFailures() {
        SuccessCounter counter = new SuccessCounter(2, 2);
        Assert.assertFalse(counter.passLevel());
        
        counter.onGame(true);
        counter.onGame(false);
        counter.onGame(false);
        counter.onGame(true);
        Assert.assertTrue(counter.passLevel());
        
        counter.onGame(false);
        Assert.assertFalse(counter.passLevel());
    }
}
