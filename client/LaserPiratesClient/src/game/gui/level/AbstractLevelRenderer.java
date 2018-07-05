package game.gui.level;

import game.gui.component.PlayerInputLine;
import game.module.geometry.shape.LinearFunction;
import javafx.event.EventType;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
 
/**
 * The <code>AbstractLevelRenderer</code> is responsible for rendering the game canvas
 * and the objects with it. One concrete class of the <code>AbstractLevelRenderer</code> 
 * is needed for each level. <br>
 * To extend the renderer, the subclass needs to call super(); in the constructor
 * and implement draw()
 * 
 * @author Marco
 */
public abstract class AbstractLevelRenderer extends Canvas implements LevelRenderer {
    // When true, disply the helper line and the helper line input options
    boolean showHelperLine = false;
    
    public static final int CELL_SIZE = 40;
    
    private boolean canValidate = false;
    
    private PlayerInputLine lineHelper;
    
    private boolean enableRenderer = true;
    
    private boolean drawAfterInput = false;
    
    private LinearFunction currentFunction;
    
    /**
     * Constructor initializes the coordinate system
     */
    public AbstractLevelRenderer() {
        GraphicsContext gc = getGraphicsContext2D();
        
        // TODO implement help mode correctly
//        if (showHelperLine) {
//            lineHelper = new PlayerInputLine(gc, Color.RED);
//            addEventHandler(MouseEvent.MOUSE_CLICKED, lineHelper);
//            addEventHandler(MouseEvent.MOUSE_MOVED, lineHelper);
//            addEventHandler(MouseEvent.MOUSE_EXITED, lineHelper);
//        }

        setOnMouseClicked(evt -> {
            evt.consume();
            redraw();
        });
        
        setOnMouseMoved(evt -> {
            evt.consume();
            redraw();
        });
        
        widthProperty().addListener(evt -> redraw());
        heightProperty().addListener(evt -> redraw());
    }

    public void redraw() {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, this.getWidth(), this.getHeight());
        
        if (enableRenderer) 
            draw();
        
        if (showHelperLine) 
            lineHelper.draw();
    }
    
    public void setShowHelperLine(boolean showHelperLine) {
        GraphicsContext gc = getGraphicsContext2D();
        this.showHelperLine = showHelperLine;
        if (showHelperLine) {
            lineHelper = new PlayerInputLine(gc, Color.RED);
            addEventHandler(MouseEvent.MOUSE_CLICKED, lineHelper);
            addEventHandler(MouseEvent.MOUSE_MOVED, lineHelper);
            addEventHandler(MouseEvent.MOUSE_EXITED, lineHelper);
        } else {
            if (lineHelper != null) {
                removeEventHandler(MouseEvent.MOUSE_CLICKED, lineHelper);
                removeEventHandler(MouseEvent.MOUSE_MOVED, lineHelper);
                removeEventHandler(MouseEvent.MOUSE_EXITED, lineHelper);
            }
        }
    }

    public void setCurrentFunction(LinearFunction currentFunction) {
        this.currentFunction = currentFunction;
    }

    protected LinearFunction getCurrentFunction() {
        return currentFunction;
    }
    
    @Override
    public boolean isResizable() {
      return true;
    }

    @Override
    public double prefWidth(double height) {
      return getWidth();
    }

    @Override
    public double prefHeight(double width) {
      return getHeight();
    }

    public void setEnableRenderer(boolean enableRenderer) {
        this.enableRenderer = enableRenderer;
    }
}
