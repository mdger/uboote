package game.gui.level;

import game.gui.util.Draw2DHelper;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import game.module.sprite.Asset;
import game.module.sprite.Sprite;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Marco
 */
public class LevelAnimationRenderer4 extends LevelAnimationRenderer{
    private Pane animationGroup;

    public LevelAnimationRenderer4(Canvas canvas) {
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
        
        Point submarineLocationCoordinate = Draw2DHelper.denormalizePoint(currentFunction.getPointStart());
        Point submarineLocation = Draw2DHelper.convertPointToCanvas(width, height, submarineLocationCoordinate);
        Rectangle submarine = new Rectangle(submarineLocation.getX()-imageSize/2, submarineLocation.getY()-imageSize/2, imageSize, imageSize);
        submarine.setFill(new ImagePattern(imageSubmarine));
        
        Point airplaneLocationCoordinate = Draw2DHelper.denormalizePoint(currentFunction.getPointEnd());
        Point airplaneLocation = Draw2DHelper.convertPointToCanvas(width, height, airplaneLocationCoordinate);
        Rectangle airplane = new Rectangle(airplaneLocation.getX()-imageSize/2, airplaneLocation.getY()-imageSize/2, imageSize, imageSize);
        airplane.setFill(new ImagePattern(imagePlane));
        
        Point projectileLocation = currentFunction.getPointEnd();
        projectileLocation.setY(0);
        projectileLocation = Draw2DHelper.denormalizePoint(projectileLocation);
        projectileLocation = Draw2DHelper.convertPointToCanvas(width, height, projectileLocation);
        Rectangle projectile = new Rectangle(projectileLocation.getX(), projectileLocation.getY(), 3, 3);
        projectile.setFill(Color.web("#333333"));
        projectile.setOpacity(0.0);
        
        int count = 81;
        int columns = 9;
        int offsetX = 0;
        int offsetY = 0;
        int spriteWidth = 100;
        int spriteHeight = 100;

        ImageView explosionSprite = new ImageView(new Image(Asset.EXPLOSION));
        explosionSprite.setOpacity(0.0);
        explosionSprite.setX(airplaneLocation.getX() - 50);
        explosionSprite.setY(airplaneLocation.getY() - 50);
        explosionSprite.setViewport(new Rectangle2D(offsetX, offsetY, spriteWidth, spriteHeight));

        final Sprite explosion = new Sprite(
                explosionSprite,
                Duration.millis(2500),
                count, columns,
                offsetX, offsetY,
                spriteWidth, spriteWidth
        );
        
        Line projectileTrajectory = new Line(submarine.getX() + imageSize/2, submarine.getY(), airplane.getX() + imageSize/2, airplane.getY());
        double projectileTravelTime = submarine.getY() - airplane.getY();
        
        PathTransition shootAnimation = new PathTransition();
        shootAnimation.setInterpolator(Interpolator.LINEAR);
        shootAnimation.setDuration(Duration.millis(projectileTravelTime * 2));
        shootAnimation.setNode(projectile);
        shootAnimation.setPath(projectileTrajectory);
        
        
        shootAnimation.setOnFinished(evt -> {
            airplane.setOpacity(0.0);
            projectile.setOpacity(0.0);
            explosionSprite.setOpacity(1.0);
            explosion.play();
        });
        
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), animationGroup);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        fadeIn.setOnFinished(evt -> {
            shootAnimation.play();
            projectile.setOpacity(1.0);
        });
        
        animationGroup.getChildren().add(submarine);
        animationGroup.getChildren().add(airplane);
        animationGroup.getChildren().add(projectile);
        animationGroup.getChildren().add(explosionSprite);
        Rectangle clip = new Rectangle(width, height);
        animationGroup.setClip(clip);
        
        Pane animationWrapper = getAnimationWrapper();
        animationWrapper.getChildren().add(animationGroup);
    }

    @Override
    protected void stopAnimation() {
        Pane animationWrapper = getAnimationWrapper();
        animationWrapper.getChildren().remove(animationGroup);
    }        
}
