package game.gui.level;

import game.controller.LevelState;
import game.gui.component.StatusMessage;
import game.gui.component.StatusMessageType;
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
    
    private boolean animationFinished;
    
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

    public void setAnimationFinished(Canvas canvas, boolean animationFinished) {
        StatusMessage.display(canvas, StatusMessageType.TYPE_CORRECT);
        this.animationFinished = animationFinished;
    }

    public boolean isAnimationFinished() {
        return animationFinished;
    }
}
