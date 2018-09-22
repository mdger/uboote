package game.level;

import game.controller.LevelState;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * An <code>AbstractLevel</code> object provides the responsible data for generating
 * a new level, e.g. win condition of a level, tutorial message for the player and
 * validates input data from the player. <br>
 * One class extending from <code>AbstractLevel</code> represents one level.
 * To implement a new level, the methods from <code>Level</code> need to be
 * implemented
 * 
 * @author Marco
 */
public abstract class AbstractLevel implements Level {
    private LinearFunction function;

    /**
     * 
     */    
    public LinearFunction getFunction() {
        return function;
    }

    /**
     * @param function 
     */
    public void setFunction(LinearFunction function) {
        this.function = function;
    }

    /**
     * @param submit
     * @return 
     */
    
    @Override
    public boolean validate(SubmitObject submit) {
        boolean result = false;
        Object submitObject = submit.getSubmit();
        
        if (submitObject instanceof LinearFunction) 
        {
            result = validateLine((LinearFunction) submitObject);
        } 
        else if (submit.getSubmit() instanceof Point) 
        {
            result = validatePoint((Point) submitObject);
        } else 
        {
            throw new IllegalArgumentException("Unsupported submit value type");
        }
        
        return result;
    }
    
    private boolean validateLine(LinearFunction controlFunction) {
        LinearFunction currentFunction = getFunction();
        
        double slopeA = currentFunction.getSlope().toDouble();
        double slopeB = controlFunction.getSlope().toDouble();
        
        return (slopeA == slopeB && 
            currentFunction.getIntercept() == controlFunction.getIntercept());
    }
    
    
    private boolean validatePoint(Point point) {
        LinearFunction currentFunction = getFunction();
        Point submarineLocation = currentFunction.getPointStart();

        return submarineLocation.equals(point);
    }
    
    public static int getLevelByLevelState(LevelState levelState) {
        int result = 0;
        
        switch(levelState) {
            case LEVEL_1:
                result = 1;
                break;
            case LEVEL_2:
                result = 2;
                break;
            case LEVEL_3:
                result = 3;
                break;
            case LEVEL_4:
                result = 4;
                break;
            case LEVEL_END:
                result = 10;
                break;
            default:
                System.out.println("getLevelByLevelState Kapott");
                break;
        }
        
        return result;
    }    
    
    @Override
    public Node getBriefing() {
        VBox layout = new VBox();
        return layout;
    }
            
}
