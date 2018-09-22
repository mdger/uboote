package game.gui.component;

import game.controller.LevelController;
import game.level.SubmitObject;
import game.module.geometry.shape.Point;

/**
 *
 * @author Marco
 */
public class PlayerInputPointDepth extends PlayerInputPoint {

    /**
     * @param levelController
     * @return 
     */
    @Override
    public SubmitObject<Point> submitFunction(LevelController levelController) {   
        NumberFieldInput fieldInput = getFieldInput();
        Point pointSubmit = levelController.getLevel().getFunction().getPointStart();
        int depth = Integer.parseInt(fieldInput.getText());
        pointSubmit.setY(depth);
        
        return new SubmitObject<>(pointSubmit);
    }    
}
