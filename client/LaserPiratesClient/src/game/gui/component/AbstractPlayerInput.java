package game.gui.component;

import static game.gui.level.AbstractLevelRenderer.CELL_SIZE;
import game.module.geometry.shape.Point;
import java.beans.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * The base class for all player inputs
 * @author Marco
 */
public abstract class AbstractPlayerInput implements PlayerInput, javafx.event.EventHandler<MouseEvent>{
    
}
