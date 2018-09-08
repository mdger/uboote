package game.gui.component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * A box which is used for displaying level information for the player which can
 * only be closed by clicking on the ok button. 
 * @author Marco
 */
public class LevelIntroBox {
    /**
     * 
     * @param title
     * @param message 
     * 
     */
    
    public static void display(Node message) {
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);
        
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10));
        
        Button okButton = new Button("Ok");
        HBox layoutButton = new HBox();
        layoutButton.setAlignment(Pos.CENTER);
        layoutButton.setPadding(new Insets(10));
        layoutButton.setSpacing(10);
        layoutButton.getChildren().addAll(okButton);
        
        okButton.setOnAction(e -> {
            window.close();
        });
        
        layout.getChildren().addAll(message, layoutButton);
        layout.setId("LvIntro");
        layout.setBackground(new Background(new BackgroundFill(Color.web("#1a1a1a"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("/style/style.css");
        window.setScene(scene);
        window.showAndWait();
    }    
}
