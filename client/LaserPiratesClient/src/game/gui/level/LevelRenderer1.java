package game.gui.level;

import game.gui.component.PlayerInputLine;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Marco
 */
public class LevelRenderer1 extends AbstractLevelRenderer {
    
    private PlayerInputLine lineInput;

    public LevelRenderer1() {
        super();
    }
    
    @Override
    public void draw() {
        if (lineInput != null)
            lineInput.draw();
    }
    
    public void setPlayerInputLine(PlayerInputLine lineInput) {
        this.lineInput = lineInput;
        addEventHandler(MouseEvent.MOUSE_CLICKED, this.lineInput);
        addEventHandler(MouseEvent.MOUSE_MOVED, this.lineInput);
        addEventHandler(MouseEvent.MOUSE_EXITED, this.lineInput);
    }
}
