package game.gui.component;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author Marco
 */
public class StatusMessage {
    
    public static void display(Node node, StatusMessageType messageType) { 
        display(node, messageType, "");
    }
    
    public static void display(Node node, StatusMessageType messageType, String message) {
        Color boxColor = Color.GREY;
        Color textColor = Color.WHITE;
        double duration = 700;
        
        switch(messageType) {
            case TYPE_CORRECT:
                message = "Richtig.\nBeliebige Taste drücken, um fortzufahren.";
                boxColor = Color.GREENYELLOW;
                
                break;
            case TYPE_WRONG:
                message = "Falsch\nBeliebige Taste drücken, um fortzufahren.";
                boxColor = Color.RED;
                break;
            case TYPE_PROCEED_ON_WAIT:
                message = "Beliebige Taste drücken, um fortzufahren.";
                boxColor = Color.GAINSBORO;
                break;
            case TYPE_NEUTRAL:
                break;
        }
        
        Font font = Font.font("Verdana", FontWeight.NORMAL, 20);
        double arcH = 5;
        double arcW = 5;

        final Rectangle rectangle = new Rectangle();
        final Text text = new Text(message);

        double x = 0;
        double y = 0;
        text.setLayoutX(x);
        text.setLayoutY(y);
        text.setFont(font);
        text.setFill(textColor);

        Scene scene = node.getScene();
        final Parent p = scene.getRoot();
        p.requestFocus();

        if (p instanceof Group) 
        {
            Group group = (Group) p;
            group.getChildren().add(rectangle);
            group.getChildren().add(text);
        }
        if (p instanceof Pane) 
        {
            Pane group = (Pane) p;
            group.getChildren().add(rectangle);
            group.getChildren().add(text);
        }

        p.setOnKeyPressed(evt -> {
            if (p instanceof Group) {
                Group group = (Group) p;
                group.getChildren().remove(rectangle);
                group.getChildren().remove(text);
            }
            if (p instanceof Pane) {
                Pane group = (Pane) p;
                group.getChildren().remove(rectangle);
                group.getChildren().remove(text);
            }
        });

        Bounds bounds = text.getBoundsInParent();

        double sWidth = scene.getWidth();
        double sHeight = scene.getHeight();

        x = sWidth / 2 - (bounds.getWidth() / 2);
        y = sHeight - (bounds.getHeight() / 2) - 100;
        text.setLayoutX(x);
        text.setLayoutY(y);
        bounds = text.getBoundsInParent();
        double baseLineOffset = text.getBaselineOffset();

        rectangle.setFill(boxColor);
        rectangle.setLayoutX(x - arcW);
        rectangle.setLayoutY(y - baseLineOffset - arcH);
        rectangle.setArcHeight(arcH);
        rectangle.setArcWidth(arcW);
        rectangle.setWidth(bounds.getWidth() + arcW * 2);
        rectangle.setHeight(bounds.getHeight() + arcH * 2);

        FadeTransition ft = new FadeTransition(
                Duration.millis(duration), rectangle);
        ft.setFromValue(0.7);
        ft.setToValue(0.5);
        ft.setAutoReverse(true);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.play();
        ft.setOnFinished(evt -> {
            if (p instanceof Group) {
                Group group = (Group) p;
                group.getChildren().remove(rectangle);
                group.getChildren().remove(text);
            }
            if (p instanceof Pane) {
                Pane group = (Pane) p;
                group.getChildren().remove(rectangle);
                group.getChildren().remove(text);
            }
        });
        FadeTransition ft2 = new FadeTransition(
                Duration.millis(duration + (duration * .1)), text);
        ft2.setFromValue(1.0);
        ft2.setToValue(1.0);
        ft2.setAutoReverse(true);
        ft2.setCycleCount(Timeline.INDEFINITE);
        ft2.play();
        
    }   
}
