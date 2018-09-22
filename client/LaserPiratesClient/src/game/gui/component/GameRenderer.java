package game.gui.component;

import game.controller.GameController;
import game.controller.LevelState;
import game.module.game.SuccessCounter;
import static game.module.save.SaveFile.readFromFile;
import static game.module.save.SaveFile.writeToFile;
import game.module.save.SaveFileLaserPiratesUser;
import game.module.sprite.Asset;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * The <code>GameRenderer</code> is responsible for rendering the current level 
 * and current player score. It receives events only by the <code>GameController</code>.
 * @author Marco
 */
public class GameRenderer extends BorderPane {

    private DoubleProperty scoreRenderer = new SimpleDoubleProperty(0.0);
    
    private IntegerProperty levelProgressRenderer = new SimpleIntegerProperty(0);
    
    private IntegerProperty currentLevelRenderer = new SimpleIntegerProperty(1);
    
    private Node levelDescription;
    
    private GameController gameController;
    
    /**
     * 
     */
    public GameRenderer(GameController gameController) {
        this.gameController = gameController;
        redraw();
    }

    /**
     * 
     * @param level 
     */
    public void setLevelProgressRenderer(int level) {
        this.levelProgressRenderer.set(level);
    }

    /**
     * 
     * @param currentLevel 
     */
    public void setCurrentLevelRenderer(int currentLevel) {
        this.currentLevelRenderer.set(currentLevel);
    }

    /**
     * 
     * @return 
     */
    public IntegerProperty getLevelProgressRenderer() {
        return levelProgressRenderer;
    }

    /**
     * 
     * @return 
     */
    public DoubleProperty getScoreRenderer() {
        return scoreRenderer;
    }

    /**
     * 
     * @return 
     */
    public IntegerProperty getCurrentLevelRenderer() {
        return currentLevelRenderer;
    }
    
    /**
     * (re)draws the GameRenderer onto the client
     */
    public void redraw() {
        BorderPane statusBar = new BorderPane();
        Label statusBarLeft = new Label("Aktuelles Level: " + currentLevelRenderer.get());
        statusBarLeft.setPadding(new Insets(7, 5, 0, 5));
        statusBarLeft.setFont(Font.font(null, FontWeight.BOLD, 15));
        statusBarLeft.setTextFill(Color.web("#40ff00"));
        
        Label statusBarRightInfo = new Label("Fortschritt: " + levelProgressRenderer.get() + " | Punkte: " + scoreRenderer.get() + " ");
        statusBarRightInfo.setFont(Font.font(null, FontWeight.BOLD, 15));
        statusBarRightInfo.setTextFill(Color.web("#40ff00"));
        statusBarRightInfo.setPadding(new Insets(0, 5, 0, 5));
        
        Image helpIcon = new Image(Asset.ICON_HELP_GREEN);
        ImageView statusBarRightTutorial = new ImageView(helpIcon);
        statusBarRightTutorial.setTranslateY(2.0);
        statusBarRightTutorial.setFitHeight(16);
        statusBarRightTutorial.setFitWidth(16);
        statusBarRightTutorial.setSmooth(true);
        
       HBox statusBarRight = new HBox();
        
        HBox statusBarRightGetDescription = new HBox();
        statusBarRightGetDescription.getChildren().add(statusBarRightInfo);
        statusBarRightGetDescription.getChildren().add(statusBarRightTutorial);
        statusBarRightGetDescription.setPadding(new Insets(7, 5, 0, 5));
        statusBarRightGetDescription.setOnMouseClicked(evt -> {
            LevelIntroBox.display(levelDescription);
        });
        
        // Save Button
        Button saveButton = new Button("Speichern");
        saveButton.setMinWidth(120);
        saveButton.setOnAction((evt) -> {
            SaveFileLaserPiratesUser userData = new SaveFileLaserPiratesUser();
            
            LevelState currentLevel = gameController.getLevelController().getLevel().getCurrentState();
            double currentScore = gameController.getScore();
            SuccessCounter currentSuccess = gameController.getLevelController().getSuccessCounter();
            
            userData.setCurrentLevel(currentLevel);
            userData.setCurrentScore(currentScore);
            
            userData.setSuccessesNeeded(currentSuccess.getSuccessesNeeded());
            userData.setFailuresTolerated(currentSuccess.getFailuresTolerated());
            userData.setLastGames(currentSuccess.getLastGames());
            userData.setPointer(currentSuccess.getPointer());
            userData.setProgress(currentSuccess.getProgressValue());

            // Save data to file
            writeToFile(userData.toJson());
        });
        
        statusBarRight.getChildren().add(statusBarRightGetDescription);
        statusBarRight.getChildren().add(saveButton);
        statusBarRight.setSpacing(5);
        
        statusBar.setPadding(new Insets(0, 0, 0, 5));
        statusBar.setLeft(statusBarLeft);
        statusBar.setRight(statusBarRight);
        statusBar.setBackground(new Background(new BackgroundFill(Color.web("#1a1a1a"), CornerRadii.EMPTY, Insets.EMPTY)));

        this.setTop(statusBar);     
    }

    /**
     * 
     * @param levelDescription 
     */
    public void setLevelDescription(Node levelDescription) {
        this.levelDescription = levelDescription;
    }

    public void setScoreRenderer(double scoreRenderer) {
        this.scoreRenderer.setValue(scoreRenderer);
    }
}
