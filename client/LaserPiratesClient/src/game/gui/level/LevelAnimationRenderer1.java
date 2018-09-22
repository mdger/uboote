package game.gui.level;

import game.gui.component.StatusMessage;
import game.gui.component.StatusMessageType;
import game.gui.util.Draw2DHelper;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import game.module.sprite.Asset;
import javafx.animation.FadeTransition;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Marco
 */
public class LevelAnimationRenderer1 extends LevelAnimationRenderer {
    private Pane animationGroup;

    public LevelAnimationRenderer1(Canvas canvas) {
        super(canvas);
    }

    @Override
    public void startAnimation(Canvas canvas) {
        LinearFunction currentFunction = getCurrentFunction();
        double width = canvas.getWidth();
        double height = canvas.getHeight();
        animationGroup = new Pane();
        animationGroup.setLayoutX(canvas.getLayoutX());
        
        double imageSize = 48; 
        
        Image imageSubmarine = new Image(Asset.SUBMARINE_R);
        Image imagePlane = new Image(Asset.PLANE);
        
        if (currentFunction.getPointStart().getX() > currentFunction.getPointEnd().getX()) {
            imageSubmarine = new Image(Asset.SUBMARINE);
            imagePlane = new Image(Asset.PLANE_R);
        }
            
        Point submarineLocation = Draw2DHelper.denormalizePoint(currentFunction.getPointStart());
        submarineLocation = Draw2DHelper.convertPointToCanvas(width, height, submarineLocation);
        Rectangle submarine = new Rectangle(submarineLocation.getX()-imageSize/2, submarineLocation.getY()-imageSize/2, imageSize, imageSize);
        submarine.setFill(new ImagePattern(imageSubmarine));
        
        Point airplaneLocation = Draw2DHelper.denormalizePoint(currentFunction.getPointEnd());
        airplaneLocation = Draw2DHelper.convertPointToCanvas(width, height, airplaneLocation);
        Rectangle airplane = new Rectangle(airplaneLocation.getX()-imageSize/2, airplaneLocation.getY()-imageSize/2, imageSize, imageSize);
        airplane.setFill(new ImagePattern(imagePlane));
        
        animationGroup.getChildren().add(airplane);
        animationGroup.getChildren().add(submarine);
        Rectangle clip = new Rectangle(width, height);
        animationGroup.setClip(clip);
        
        Pane animationWrapper = getAnimationWrapper();
        animationWrapper.getChildren().add(animationGroup);
        
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(2), animationGroup);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        fadeIn.setOnFinished((event) -> {
            setAnimationFinished(canvas, true);
        });
    }

    @Override
    protected void stopAnimation() {
        Pane animationWrapper = getAnimationWrapper();
        animationWrapper.getChildren().remove(animationGroup);
    }
    
}
