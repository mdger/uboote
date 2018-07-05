package game.gui.debug;

import com.sun.javafx.geom.Point2D;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Marco
 */
public class DebugGroup {
    
     /**
     * 
     * @param parentWindow
     * 
     */
    
    public static void display() {
        Stage window = new Stage();
        window.initModality(Modality.NONE);
        window.setTitle(DebugBox.DEBUG_CANVAS);
        window.setWidth(640);
        window.setHeight(480);
        
        Group group = new Group();
        group.getStyleClass().add("game-canvas");
        
        Line line = new Line(0, 0, window.getWidth(), window.getHeight());
        Rectangle box = new Rectangle(50, 50, 200, 200);
        
        group.getChildren().addAll(line, box);
        
        group.setOnMouseEntered(mouseEvent -> {
            System.out.println("Hüyaa");
        });
        
        Point2D point = new Point2D(0, 0);
        
        group.setOnMousePressed(mouseEvent -> {
            System.out.println("setOnMousePressed");
            System.out.println((int) mouseEvent.getX());
            System.out.println((int) mouseEvent.getY());
            
            group.setOnMouseReleased(mouseEvent2 -> {
                if (mouseEvent.getX() != mouseEvent2.getX() &&
                        mouseEvent.getY() != mouseEvent2.getY()) {
                    System.out.println("setOnMouseReleased");
                    System.out.println(mouseEvent2.getX());
                    System.out.println(mouseEvent2.getY());


                    Timeline fadeAnim = new Timeline(new KeyFrame(Duration.millis(20), e -> {
                    }));

                    fadeAnim.play();
                }
                
                
                
            });
        });
        
        // Lineare Gleichung
        VBox inputForm = new VBox();
        
        BorderPane layout = new BorderPane();
        layout.setStyle("-fx-border-color: black");
        layout.setCenter(group);
        layout.setBottom(inputForm);
        layout.getStyleClass().add("game-canvas-wrapper");
        
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("style/style.css");
        window.setScene(scene);
        window.show();
    }    
}
