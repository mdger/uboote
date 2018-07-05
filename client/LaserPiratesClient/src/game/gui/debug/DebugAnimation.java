package game.gui.debug;

import com.sun.javafx.geom.Point2D;
import game.module.sprite.Sprite;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Marco
 */
public class DebugAnimation {
    
     /**
     * 
     * @param parentWindow
     * 
     */
    
    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.NONE);
        window.setTitle(DebugBox.DEBUG_ANIMATION);
        window.setWidth(640);
        window.setHeight(480);

        // COINTENT
        
        int count = 81;
        int columns = 9;
        int offsetX = 0;
        int offsetY = 0;
        int width = 100;
        int height = 100;
        
        final ImageView imageView = new ImageView(new Image("asset/explosion.png"));
        imageView.setViewport(new Rectangle2D(offsetX, offsetY, width, height));

        final Animation animation = new Sprite(
                imageView,
                Duration.millis(2500),
                count, columns,
                offsetX, offsetY,
                width, height
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        window.setOnCloseRequest(evt -> {
            animation.stop();
        });
        // Content END
        
        window.setScene(new Scene(new Group(imageView)));
        window.show();
    }     
}
