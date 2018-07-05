package game.gui.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * A ConfirmBox is used, when you need to ask for the user´s decision. If yes
 * is clicked, the method display() returns true, which then the developer can
 * use to execute code based on that decision
 * @author Marco
 */
public class ConfirmBox {
    static Boolean answer;
    
    /**
     * 
     * @param title
     * @param message 
     * @return Boolean
     * 
     */
    
    public static Boolean display(String title, String message) {
        
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        
        Label label = new Label();
        label.setText(message);
        
        Button yesButton = new Button("Ja");
        Button noButton = new Button("Nein");
        
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });
        
        VBox layout = new VBox();
        layout.getChildren().addAll(label);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        
        HBox layoutButtons = new HBox();
        layoutButtons.setAlignment(Pos.CENTER);
        layoutButtons.setPadding(new Insets(10));
        layoutButtons.setSpacing(10);
        layoutButtons.getChildren().addAll(yesButton, noButton);
        
        layout.getChildren().add(layoutButtons);
        layout.setId("MsgBox");
        
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/style/style.css");
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
    }
}
