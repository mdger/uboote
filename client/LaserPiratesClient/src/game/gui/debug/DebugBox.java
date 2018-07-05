package game.gui.debug;

import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * A Debug Mode / Sandbox to spawn different GUI implementations to test with. <br>
 * It is integrated into the client itself but can also be started standalone. <br>
 * To do this, just run this file by itself by starting the main method. <br>
 * In Netbeans right click on this file and select "Run File..." or press SHIFT + F6 <br>
 * 
 * To add more options, you should add a new constant and add it to getDebugOptions() as well. See DEBUG_CANVAS
 *
 * @author Marco
 * 
 */
public class DebugBox extends Application {
    
    public static final String DEBUG_CANVAS = "Debug Canvas";
    
    public static final String DEBUG_GROUP = "Debug Group";
    
    public static final String DEBUG_ANIMATION = "Debug Animation";
    
    public static final String DEBUG_HTTP = "Debug HTTP";

    public static final String DEBUG_LATEX = "Debug Latex";

    /**
     * 
     * @param parentWindow
     * 
     */
    
    public static void display(Stage parentWindow) {
        Stage window = new Stage();
        window.initModality(Modality.NONE);
        window.setTitle("Debug Modus (Sandbox)");
        window.setMinWidth(250);
        window.setWidth(300);
        window.setX(parentWindow.getX() + parentWindow.getWidth());
        window.setY(parentWindow.getY());
        window.setHeight(parentWindow.getHeight());
        
        ListView<String> listview = new ListView<>();
        listview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listview.getItems().addAll(getDebugOptions());
        
        // On selecting one item perform the following action...
        listview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            spawnWindow(newValue);
        });
        
        VBox layout = new VBox();
        layout.getChildren().addAll(listview);
        
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("style/style.css");
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }    

    @Override
    public void start(Stage primaryStage) throws Exception {
        DebugBox.display(primaryStage);
    }
    
    /**
     * 
     * @return List<String>
     * 
     */
    
    private static List<String> getDebugOptions() {
        String[] options = {
            DEBUG_CANVAS,
            DEBUG_GROUP,
            DEBUG_ANIMATION,
            DEBUG_HTTP,
            DEBUG_LATEX,
        };
        
        List<String> list = Arrays.asList(options);
        return list;
    }
    
    /**
     * 
     * @param windowToSpawn 
     * 
     */
    
    private static void spawnWindow(String windowToSpawn) {
        switch (windowToSpawn) {
            case DEBUG_CANVAS:
                DebugCanvas.display();
                break;
            case DEBUG_GROUP:
                DebugGroup.display();
                break;
            case DEBUG_ANIMATION:
                DebugAnimation.display();
                break;
            case DEBUG_HTTP:
                DebugHttp.display();
                break;
            case DEBUG_LATEX:
                DebugLatex.display();
                break;
        }
    }
}
