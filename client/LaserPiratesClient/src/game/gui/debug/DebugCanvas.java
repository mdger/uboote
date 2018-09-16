package game.gui.debug;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author Marco
 */
public class DebugCanvas {
    
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
        
        Canvas canvas = new Canvas(window.getWidth(), window.getHeight());
        canvas.getStyleClass().add("game-canvas");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLUE);
        gc.fillRect(75, 75, 100, 100);
        
        canvas.setOnMousePressed(mouseEvent -> {
            System.out.println("setOnMousePressed");
            System.out.println(mouseEvent.getX());
            System.out.println(mouseEvent.getY());
            
            canvas.setOnMouseReleased(mouseEvent2 -> {
                if (mouseEvent.getX() != mouseEvent2.getX() &&
                        mouseEvent.getY() != mouseEvent2.getY()) {
                    System.out.println("setOnMouseReleased");
                    System.out.println(mouseEvent2.getX());
                    System.out.println(mouseEvent2.getY());

                    gc.setStroke(Color.GRAY);
//                    gc.strokeLine(mouseEvent.getX(), mouseEvent.getY(), mouseEvent2.getX(), mouseEvent2.getY());
                    Line line = new Line();
                    gc.moveTo(mouseEvent.getX(), mouseEvent.getY());
                    gc.lineTo(mouseEvent2.getX(), mouseEvent2.getY());
                    gc.stroke();

                    Timeline fadeAnim = new Timeline(new KeyFrame(Duration.millis(20), e -> {
                        gc.setStroke(Color.AQUA);
                    }));

                    fadeAnim.play();
                    System.out.println("fadeAnimeplay");
                }
            });
        });
        
        // Lineare Gleichung
        VBox inputForm = new VBox();
        
        BorderPane layout = new BorderPane();
        layout.setStyle("-fx-border-color: black");
        layout.setCenter(canvas);
        layout.setBottom(inputForm);
        layout.getStyleClass().add("game-canvas-wrapper");
        
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("style/style.css");
        window.setScene(scene);
        window.show();
    }
}
