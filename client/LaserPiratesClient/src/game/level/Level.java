package game.level;

import game.controller.LevelState;
import javafx.scene.Node;

/**
 * @author Marco
 */
public interface Level {
    public boolean validate(SubmitObject submit);
    
    public int getWinCondition();
    
    public Node getDescription();
    
    public Node getBriefing();
    
    public LevelState getCurrentState();
    
    public LevelState getNextLevelState(); 
}
