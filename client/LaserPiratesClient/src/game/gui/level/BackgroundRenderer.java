package game.gui.level;

import game.gui.util.Draw2DHelper;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author Marco
 */
public class BackgroundRenderer extends Canvas {
    
    private Transition coordinateSpaceTransition;
    private LevelAnimationRenderer animation;

    public void initializeBackground() {
        GraphicsContext gc = getGraphicsContext2D();
        
        coordinateSpaceTransition = new Transition() {
            {
                setCycleDuration(Duration.millis(100000));
                setInterpolator(Interpolator.LINEAR);
            }

            @Override
            protected void interpolate(double frac) {
                Draw2DHelper.drawCoordinateSpace(gc, frac);
            }
        };
        coordinateSpaceTransition.setCycleCount(Transition.INDEFINITE);
        coordinateSpaceTransition.play();
    }
    
    public void stopBackgroundAnimation() {
        coordinateSpaceTransition.stop();
    }
    
    public void setAnimation(LevelAnimationRenderer animation) {
        this.animation = animation;
    }
    
    public void startAnimation() {
        animation.startAnimation(this);
    }
    
    
    public void stopAnimation() {
        animation.stopAnimation();
    }

    public LevelAnimationRenderer getAnimation() {
        return animation;
    }
    
    @Override
    public boolean isResizable() {
      return true;
    }

    @Override
    public double prefWidth(double height) {
      return getWidth();
    }

    @Override
    public double prefHeight(double width) {
      return getHeight();
    }
}
