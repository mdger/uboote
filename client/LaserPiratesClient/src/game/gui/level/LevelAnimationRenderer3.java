package game.gui.level;

import game.gui.util.Draw2DHelper;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import game.module.sprite.Asset;
import game.module.sprite.Sprite;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 *
 * @author Marco
 */
public class LevelAnimationRenderer3 extends LevelAnimationRenderer {
    private Pane animationGroup;

    public LevelAnimationRenderer3(Canvas canvas) {
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
        Image imageShip = new Image(Asset.CRUISER_R);
        Image imagePlane = new Image(Asset.PLANE);
        
        if (currentFunction.getPointStart().getX() > currentFunction.getPointEnd().getX()) {
            imageSubmarine = new Image(Asset.SUBMARINE);
            imagePlane = new Image(Asset.PLANE_R);
        }
        
        Point submarineLocationCoordinate = Draw2DHelper.denormalizePoint(currentFunction.getPointStart());
        Point submarineLocation = Draw2DHelper.convertPointToCanvas(width, height, submarineLocationCoordinate);
        Rectangle submarine = new Rectangle(submarineLocation.getX()-imageSize/2, submarineLocation.getY()-imageSize/2, imageSize, imageSize);
        submarine.setFill(new ImagePattern(imageSubmarine));
        
        Point projectileLocation = currentFunction.getPointStart();
        projectileLocation.setY(0);
        projectileLocation = Draw2DHelper.denormalizePoint(projectileLocation);
        projectileLocation = Draw2DHelper.convertPointToCanvas(width, height, projectileLocation);
        Rectangle projectile = new Rectangle(projectileLocation.getX(), projectileLocation.getY(), 3, 3);
        projectile.setFill(Color.web("#333333"));
        projectile.setOpacity(0.0);
        
        double projectileTravelDistance = submarineLocation.getY() - projectileLocation.getY();
        
        int count = 81;
        int columns = 9;
        int offsetX = 0;
        int offsetY = 0;
        int spriteWidth = 100;
        int spriteHeight = 100;

        ImageView explosionSprite = new ImageView(new Image(Asset.EXPLOSION));
        explosionSprite.setOpacity(0.0);
        explosionSprite.setX(submarineLocation.getX() - 50);
        explosionSprite.setY(submarineLocation.getY() - 50);
        explosionSprite.setViewport(new Rectangle2D(offsetX, offsetY, spriteWidth, spriteHeight));

        final Sprite explosion = new Sprite(
                explosionSprite,
                Duration.millis(2500),
                count, columns,
                offsetX, offsetY,
                spriteWidth, spriteWidth
        );
        
        Transition bombDropAnimation = new Transition() {
            {
                setCycleDuration(Duration.millis(projectileTravelDistance * 10));
                setInterpolator(Interpolator.LINEAR);
            }
            
            @Override
            protected void interpolate(double frac) {
                projectile.setLayoutY(projectileTravelDistance * frac);
            }
        };
        
        bombDropAnimation.setOnFinished(evt -> {
            submarine.setOpacity(0.0);
            projectile.setOpacity(0.0);
            explosionSprite.setOpacity(1.0);
            explosion.play();
        });

        // Position out of canvas
        int shipLocationX = (-1*AbstractLevelRenderer.CELL_SIZE/2);
        Point shipLocation = new Point(shipLocationX, 0);
        shipLocation = Draw2DHelper.denormalizePoint(shipLocation);
        shipLocation = Draw2DHelper.convertPointToCanvas(width, height, shipLocation);
        Rectangle ship = new Rectangle(shipLocation.getX()-imageSize/2, shipLocation.getY()-imageSize/2, imageSize, imageSize);
        ship.setFill(new ImagePattern(imageShip));
        
        double shipTravelDistance = submarineLocation.getX() - shipLocation.getX();
        
        Transition moveShipAnimation = new Transition() {
            {
                setCycleDuration(Duration.millis(shipTravelDistance * 8));
                setInterpolator(Interpolator.LINEAR);
            }
            
            @Override
            protected void interpolate(double frac) {
                ship.setLayoutX(shipTravelDistance * frac);
            }
        };
        moveShipAnimation.setOnFinished(evt -> {
            bombDropAnimation.play();
            projectile.setOpacity(1.0);
        });
        
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), animationGroup);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        fadeIn.setOnFinished(evt -> {
            moveShipAnimation.play();
        });
        
        animationGroup.getChildren().add(submarine);
        animationGroup.getChildren().add(projectile);
        animationGroup.getChildren().add(explosionSprite);
        animationGroup.getChildren().add(ship);
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
