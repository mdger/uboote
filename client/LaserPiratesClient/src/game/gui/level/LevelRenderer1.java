package game.gui.level;

import game.gui.component.PlayerInputLine;
import game.gui.util.Draw2DHelper;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import game.module.sprite.Asset;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

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
