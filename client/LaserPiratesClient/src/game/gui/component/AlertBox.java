package game.gui.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * An alert box which can be closed by clicking ok. It also blocks the client,
 * as long the alert box is still open.
 * @author Marco
 */
public class AlertBox {
    
    /**
     * 
     * @param title
     * @param message 
     * @return Boolean
     * 
     */
    
    public static void display(String title, String message) {
        
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        
        Label label = new Label();
        label.setText(message);
        
        Button okButton = new Button("Ok");
        
        okButton.setOnAction(e -> {
            window.close();
        });
        
        okButton.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER)
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
        layoutButtons.getChildren().addAll(okButton);
        
        layout.getChildren().add(layoutButtons);
        layout.setId("MsgBox");
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/style/style.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
