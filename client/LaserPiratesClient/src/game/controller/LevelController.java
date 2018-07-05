package game.controller;

import game.gui.component.AbstractPlayerInput;
import game.gui.level.AbstractLevelRenderer;
import game.gui.level.LevelRenderer1;
import game.gui.component.PlayerInputLine;
import game.gui.component.PlayerInputLinearFunction;
import game.gui.component.PlayerInputPointDepth;
import game.gui.component.PlayerInputPointDistance;
import game.gui.component.StatusMessage;
import game.gui.component.StatusMessageType;
import game.gui.level.LevelAnimationRenderer;
import game.gui.level.BackgroundRenderer;
import game.gui.level.*;
import game.gui.level.LevelRenderer2;
import game.gui.level.LevelRenderer3;
import game.gui.level.LevelRenderer4;
import game.level.AbstractLevel;
import game.level.Level1;
import game.level.Level2;
import game.level.Level3;
import game.level.Level4;
import game.level.SubmitObject;
import java.util.Observable;
import game.module.game.SuccessCounter;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * The <code>LevelController</code> keeps state of the current level and delegates
 * render logic to the <code>AbstractLevelRenderer</code>.
 * @author Marco
 */
public class LevelController extends Observable {
    private SuccessCounter successCounter;
    private AbstractLevel level;
    private AbstractLevelRenderer playerInputRenderer;
    private BackgroundRenderer backgroundRenderer;
    private AbstractPlayerInput playerInput;
    // the wrapper for the canvas, for the responsive window functionality
    private Pane gameWrapper;
    private final GameController gameController;

    public LevelController(GameController gameController) {
        this.gameController = gameController;
        // Background
        backgroundRenderer = new BackgroundRenderer();
        backgroundRenderer.initializeBackground();

        buildLevel(LevelState.LEVEL_3);
        
        successCounter = new SuccessCounter(this.getLevel().getWinCondition(), 1);
        successCounter.progress().addListener(this.gameController);
    }
    
    /**
     * Builds a fully functional game level which is comprised of a renderer, a player input and level object
     * @param state the level to use for building the level
     */
    public void buildLevel(LevelState state) {
        setLevelByLevelState(state);
        setRendererByLevelState(state);
        setPlayerInputByLevelState(state);
        setAnimationRendererByLevelState(state);
        resetGameController();
    }
    
    /**
     * Instantiates a new <code>Level</code> object.
     * @param state the level to use for building the level
     */
    private void setLevelByLevelState(LevelState state) {
        switch (state) {
            case LEVEL_1:
                level = new Level1();
                break;
            case LEVEL_2:
                level = new Level2();
                break;
            case LEVEL_3:
                level = new Level3();
                break;
            case LEVEL_4:
                level = new Level4();
                break;
            default:
                System.out.println("Level not supported (yet)");
                break;
        }
    }
    
    
    /**
     * Instantiates a new <code>AbstractLevelRenderer</code> object by level and binds the
     * <code>BackgroundRenderer</code> to the game´s wrapper. The bindings are 
     * necessary to set the canvas´ size according to the client´s current window 
     * size.
     * @param state the level to use for building the renderer
     */
    private void setRendererByLevelState(LevelState state) {
        switch (state) {
            case LEVEL_1:
                playerInputRenderer = new LevelRenderer1();
                break;
            case LEVEL_2:
                playerInputRenderer = new LevelRenderer2(level.getFunction());
                break;
            case LEVEL_3:
                playerInputRenderer = new LevelRenderer3(level.getFunction());
                break;
            case LEVEL_4:
                playerInputRenderer = new LevelRenderer4(level.getFunction());
                break;
            default:
                System.out.println("LevelRenderer not supported (yet)");
                break;
                
        }
        playerInputRenderer.setCurrentFunction(level.getFunction());
        gameWrapper = new Pane();
        gameWrapper.getStylesheets().add("/style/style.css");
        
        playerInputRenderer.widthProperty().bind(
                           gameWrapper.heightProperty());
        playerInputRenderer.heightProperty().bind(
                           gameWrapper.heightProperty());
        //center on x axis
        playerInputRenderer.layoutXProperty().bind(
                           gameWrapper.widthProperty().subtract(playerInputRenderer.widthProperty()).divide(2.0));
        
        backgroundRenderer.widthProperty().bind(
                           playerInputRenderer.widthProperty());
        backgroundRenderer.heightProperty().bind(
                           playerInputRenderer.heightProperty());
        // center on x axis
        backgroundRenderer.layoutXProperty().bind(
                           gameWrapper.widthProperty().subtract(playerInputRenderer.widthProperty()).divide(2.0));

        gameWrapper.getChildren().add(backgroundRenderer); 
        gameWrapper.getChildren().add(playerInputRenderer); 
    }
    
    /**
     * initializes the required input for solving the level
     * @param state the level to use for building the player input
     */
    private void setPlayerInputByLevelState(LevelState state) {
        GraphicsContext gc = playerInputRenderer.getGraphicsContext2D();
        
        switch (state) {
            case LEVEL_1:
                // FIXME evil hack
                playerInput = new PlayerInputLine(gc, Color.RED);
                LevelRenderer1 level1 = (LevelRenderer1) playerInputRenderer;
                level1.setPlayerInputLine((PlayerInputLine) playerInput);
                break;
            case LEVEL_2:
                playerInput = new PlayerInputPointDepth();
                break;
            case LEVEL_3:
                playerInput = new PlayerInputPointDistance();
                break;
            case LEVEL_4:
                playerInput = new PlayerInputLinearFunction();
                break;
            default:
                System.out.println("PlayerInput for Level not supported (yet)");
                break;
        }
    }
    
    /**
     * sets the Animation which is played after a correct player input
     * @param state the level to use for building the level
     */
    private void setAnimationRendererByLevelState(LevelState state) {
        LevelAnimationRenderer animationRenderer; 
        
        switch (state) {
            case LEVEL_1:
                animationRenderer = new LevelAnimationRenderer1(backgroundRenderer);
                break;
            case LEVEL_2:
                animationRenderer = new LevelAnimationRenderer2(backgroundRenderer);
                break;
            case LEVEL_3:
                animationRenderer = new LevelAnimationRenderer3(backgroundRenderer);
                break;
            case LEVEL_4:
                animationRenderer = new LevelAnimationRenderer4(backgroundRenderer);
                break;
            default:
                animationRenderer = new LevelAnimationRenderer1(backgroundRenderer);
                System.out.println("Level Animation Renderer not supported (yet), use LevelAnimationRenderer1 instead");
                break;
        }
        
        animationRenderer.setCurrentFunction(level.getFunction());
        backgroundRenderer.setAnimation(animationRenderer);
    }
    
    /**
     * When a level is finished, the wrapper and input need to reset to the layout
     */
    private void resetGameController() {
        gameController.getGameRenderer().setCenter(getWrapper());
        gameController.getGameRenderer().setBottom(getPlayerInput());
    }
    
    /**
     * 
     * @return the current player input
     */
    public Node getPlayerInput() {
        return playerInput.getSubmitInput(this);
    }
    
    /**
     * 
     * @return returns the container of the renderer than the renderer by itself
     * The wrapper itself is responsible for the dynamic resizing functionality
     */
    public Pane getWrapper() {
        return gameWrapper;
    }
    
    /**
     * 
     * @return returns the container of the renderer than the renderer by itself
     * The wrapper itself is responsible for the dynamic resizing functionality
     */
    public AbstractLevelRenderer getLevelRenderer() {
        return playerInputRenderer;
    }

    /**
     * 
     * @return the <code>BackgroundRenderer</code>
     */
    public Canvas getBackground() {
        return backgroundRenderer;
    }
    
    /**
     * 
     * @return the current level object
     */
    public AbstractLevel getLevel() {
        return level;
    }
    
    /**
     * this method is triggered, when a submit is entered to be validated.
     * @param submit 
     */
    public void onInputSubmit(SubmitObject submit) {
        boolean isSuccessfulHit = level.validate(submit);

        if(isSuccessfulHit) {
            successCounter.onGame(true);     
            
            StatusMessage.display(playerInputRenderer, StatusMessageType.TYPE_CORRECT);
            backgroundRenderer.startAnimation();
            
            if (level.getCurrentState() == LevelState.LEVEL_4)
                playerInputRenderer.setEnableRenderer(false);
            
            playerInputRenderer.redraw();
        } else {
            successCounter.onGame(false);
            StatusMessage.display(playerInputRenderer, StatusMessageType.TYPE_WRONG);
        }
        
        Scene gameScene = playerInputRenderer.getScene();
        gameScene.setOnKeyPressed(e -> {
            if(successCounter.passLevel()) {
                gameScene.setOnKeyPressed(null);
                if (level.getNextLevelState() == LevelState.LEVEL_END) {
                    gameController.onGameCompleted();
                } else {
                    buildLevel(level.getNextLevelState());
                    // reset counter
                    successCounter.reset(level.getWinCondition(), 1);
                    // start animation
                    gameController.onLevelCompleted();
                }
            } else {
                gameScene.setOnKeyPressed(null);
                buildLevel(level.getCurrentState());
            }
            
            // also stop the animation when generating a new level
            backgroundRenderer.stopAnimation();
        });
    } 

    /**
     * 
     * @return the background and animation canvas
     */
    
    public BackgroundRenderer getBackgroundLayer() {
        return backgroundRenderer;
    }
}
