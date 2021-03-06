package game.controller;

import game.gui.Client;
import game.gui.component.GameRenderer;
import game.gui.component.LevelIntroBox;
import game.level.AbstractLevel;
import game.module.save.SaveFile;
import game.module.save.SaveFileLaserPiratesUser;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The <code>GameController</code> encapsulates the <code>LevelController</code>.
 * It is responsible for keeping the actual state of a level and keeping track
 * of the player score and delegates events to the <code>GameRenderer</code> if needed.
 * e.g. When the level is completed, the game needs to transition to the next level
 * and tells the <code>GameRenderer</code> to present the current level in the
 * status bar
 * @author Marco
 */
public class GameController implements ChangeListener<Object> {
    
    private IntegerProperty level;
    private DoubleProperty score;
    private GameRenderer gameRenderer;
    private LevelController levelController;
    
    public GameController() {
        initialize();
    }
    
    private void initialize() {
        gameRenderer = new GameRenderer(this);
        levelController = new LevelController(this);
        gameRenderer.setCenter(levelController.getWrapper());
        gameRenderer.setLevelDescription(levelController.getLevel().getDescription());
        gameRenderer.setId("Wrapper");
        // retrieve save data
        SaveFileLaserPiratesUser userData = null;
        
        try {
            userData = SaveFile.readFromFile();
        } catch(NullPointerException e) {
            
        }
        
        score = new SimpleDoubleProperty(0.0);
        if (userData != null) {
            score.set(userData.getCurrentScore());
            gameRenderer.setScoreRenderer(userData.getCurrentScore());
            gameRenderer.setLevelProgressRenderer(userData.getProgress());
        }
            
        score.bindBidirectional(gameRenderer.getScoreRenderer());
        
        level = new SimpleIntegerProperty(1);
        level.bindBidirectional(gameRenderer.getCurrentLevelRenderer());
        
        // Render current level
        this.setCurrentLevel(AbstractLevel.getLevelByLevelState(levelController.getLevel().getCurrentState()));
    }
    
    /**
     * this is triggered, when the win condition of the current level is reached.
     * Sends events to the GameRenderer to accommodate for the next level´s changes on the GUI
     */
    
    public void onLevelCompleted() {
        gameRenderer.setLevelDescription(levelController.getLevel().getDescription());
        int currentLevel = AbstractLevel.getLevelByLevelState(levelController.getLevel().getCurrentState());
        this.setCurrentLevel(currentLevel);
        
        LevelIntroBox.display(getLevelController().getLevel().getDescription());
    }
    
    public void onGameCompleted() {
        Stage stage = (Stage) levelController.getLevelRenderer().getScene().getWindow();

        VBox box = new VBox(new Label("Sie haben das Spiel beendet.\n Vielen Dank fürs Spielen!"));
        
        Button restartButton = new Button("Nochmal spielen");
        restartButton.setOnAction((event) -> {
            SaveFile.writeToFile("");
            
            BorderPane root = new BorderPane();
            GameController gameController = new GameController();
            root.setCenter(gameController.getGameRenderer());
            
            Scene gameScene = new Scene(root, 800, 600);
            gameScene.getStylesheets().add("/style/style.css");
            stage.setMaximized(true);
            stage.setScene(gameScene);
        });
        
        box.getChildren().add(new Label("Ihre Gesamtpunktzahl ist: " + score.getValue()));
        box.getChildren().add(restartButton);
        box.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(box));
    }
    
    public void showHighscoreChart() {
        // TODO
    }
    
    public void savePlayerScore() {
        // TODO
    }
    
    /**
     * 
     * @return the GameRenderer
     */
    public GameRenderer getGameRenderer() {
        return gameRenderer;
    }

    /**
     * 
     * @return the LevelController
     */
    public LevelController getLevelController() {
        return levelController;
    }

    @Override
    public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
        
        // TODO Implement correct score calculation
        if (observable instanceof SimpleIntegerProperty) {
            double scoreValue = calculateScore((int)oldValue, (int)newValue);
            addToScore(scoreValue);
        } else if (observable instanceof SimpleDoubleProperty) {
        }
        
        gameRenderer.getLevelProgressRenderer().set((int)newValue);
        gameRenderer.redraw();
    }
    
    public void setCurrentLevel(int currentLevel) {
        this.level.set(currentLevel);
        gameRenderer.redraw();
    }
    
    private double calculateScore(int oldValue, int newValue) {
        double scoreValue = 0.0;
        
        if (oldValue < newValue) {
            scoreValue += 15.0;
        } else if (newValue == 0) {
            scoreValue -= 5.0;
        }
        
        return scoreValue;
        
    }
    
    private void addToScore(double score) {
        this.score.set(this.score.get() + score);
    }

    public double getScore() {
        return score.getValue();
    }
}
