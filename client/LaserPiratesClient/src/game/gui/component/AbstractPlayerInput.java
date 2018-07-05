package game.gui.component;

import static game.gui.level.AbstractLevelRenderer.CELL_SIZE;
import game.module.geometry.shape.Point;
import java.beans.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

/**
 * The base class for all player inputs
 * @author Marco
 */
public abstract class AbstractPlayerInput implements PlayerInput, javafx.event.EventHandler<MouseEvent>{
    
    /**
     * Gets a node which is a math equation e.g. 1/2*x + 1 = y
     * @param num numerator
     * @param den denumerator
     * @param intercept intercept
     * @return 
     */
    
//    protected LateXMathControl getLinearyFunctionEquation(int num, int den, int intercept) {
//        
//        String latex = "\\begin{array}{l}";
//        
//        if (den != 1) {
//            latex += "\\frac{"+num+"}{"+den+"}x";
//        } else {
//            latex += num+"x";
//        }
//        
//        if (intercept != 0) {
//            if (intercept > 0) {
//                latex += "+"+intercept; 
//            } else {
//                latex += intercept; 
//            }
//        }
//        latex += "= y\\\\";
//        latex += "\\end{array}";
//        
//        LateXMathControl lc = new LateXMathControl(latex);
//        lc.sizeProperty().setValue(18);
//        lc.textColorProperty().set(Color.web("#40ff00"));
//        lc.setMinWidth(100);        
//        lc.setMaxHeight(40);
//        
//        return lc;
//    }
}
