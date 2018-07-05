package game.gui.component;

import game.controller.LevelController;
import game.level.SubmitObject;
import javafx.scene.Node;

/**
 * PlayerInput interface
 * @author Marco
 */
public interface PlayerInput {
    public void draw();
    
    public Node getSubmitInput(LevelController controller);
    
    public SubmitObject submitFunction(LevelController levelController);
}
