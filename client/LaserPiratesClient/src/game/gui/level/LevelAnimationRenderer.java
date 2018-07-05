package game.gui.level;

import game.controller.LevelState;
import game.module.geometry.shape.LinearFunction;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

/**
 *
 * @author Marco
 */
public abstract class LevelAnimationRenderer {

    private Canvas canvas;
    
    public LevelAnimationRenderer(Canvas canvas) {
        this.canvas = canvas;
    }

    private LinearFunction currentFunction;
    
    public abstract void startAnimation(Canvas canvas);

    protected abstract void stopAnimation();

    public void setCurrentFunction(LinearFunction currentFunction) {
        this.currentFunction = currentFunction;
    }

    protected LinearFunction getCurrentFunction() {
        return currentFunction;
    }

    private Canvas getCanvas() {
        return canvas;
    }
    
    protected Pane getAnimationWrapper() {
        final Parent p = canvas.getParent();
        Pane pane = (Pane) p;
        
        return pane;
    }
}
