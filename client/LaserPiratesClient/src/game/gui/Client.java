package game.gui;

import game.controller.GameController;
import game.gui.component.ConfirmBox;
import game.gui.component.GameRenderer;
import game.gui.component.LevelIntroBox;
import game.gui.debug.DebugBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The client application which sets up the menu bar and the GameController.
 * The game itself is completely encapsulated in the GameController.
 * @author Marco
 * 
 */

public class Client extends Application {
    
    Stage window;

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("U-Boote mit Geraden");
        window.setOnCloseRequest(e -> {
            e.consume();
            String title = "Möchtest du das Spiel wirklich schließen?";
            String message = "Bist du dir sicher, dass du das Spiel schließen möchtest?";
            
            Boolean answer = ConfirmBox.display(title, message);
            if (answer)
                window.close();
        });
        
        BorderPane root = new BorderPane();

//        MenuBar mainMenu = constructMenuBar();
//        root.setTop(mainMenu);
        
        GameController gameController = new GameController();
        root.setCenter(gameController.getGameRenderer());
        
        Scene gameScene = new Scene(root, 800, 600);
        gameScene.getStylesheets().add("/style/style.css");
        
        // Intro
        Button btn = new Button();
        btn.setText("Spiel starten");
        btn.setOnAction((e) -> {
            primaryStage.setScene(gameScene);
            LevelIntroBox.display(gameController.getLevelController().getLevel().getDescription());
        });
        
        StackPane introScreen = new StackPane();
        introScreen.getChildren().addAll(btn);
        introScreen.setId("Intro");
        Scene introScene = new Scene(introScreen, 800, 600);
        introScene.getStylesheets().add("/style/style.css");
        
        primaryStage.setScene(introScene);
        primaryStage.show();
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(480);
    }

    /**
     * 
     * @return assembles the menu bar of the client
     */
    
    private MenuBar constructMenuBar() {
       // Menu
        // Game Menu
        Menu menuGame = new Menu("Spiel");
        MenuItem menuGameLogin = new MenuItem("Login (Statistik)");
        menuGame.getItems().add(menuGameLogin);

        // Game Options
        Menu menuOptions = new Menu("Option");
        MenuItem menuOptionsConnect = new MenuItem("Mit Server verbinden");

        menuOptions.getItems().addAll(menuOptionsConnect);
        
        // Game Help
        Menu menuHelp = new Menu("Hilfe");
        menuHelp.setOnAction(e -> {
            e.consume();
            DebugBox.display(window);
        });
        
        MenuItem menuHelpDebug = new MenuItem("Sandbox (Debug)");

        menuHelp.getItems().addAll(menuHelpDebug);
        
        // Fasse zusammen
        MenuBar mainMenu = new MenuBar();
        mainMenu.setId("MainMenu");
        mainMenu.setPadding(Insets.EMPTY);
        mainMenu.getMenus().addAll(menuGame, menuOptions, menuHelp);    
        
        return mainMenu;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void launchClient(String[] args) {
        launch(args);
    }
}
