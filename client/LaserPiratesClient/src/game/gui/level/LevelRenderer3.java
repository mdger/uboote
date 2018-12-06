package game.gui.level;

import game.controller.LevelController;
import game.gui.level.AbstractLevelRenderer;
import game.gui.util.Draw2DHelper;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import game.module.math.Rational;
import game.module.sprite.Asset;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author Marco
 */
public class LevelRenderer3 extends AbstractLevelRenderer {
    
    private final LinearFunction currentLevelFunction;
    
    public LevelRenderer3(LinearFunction currentLevelFunction) {
        super();
        this.currentLevelFunction = currentLevelFunction;
        setShowHelperLine(false);
    }

    @Override
    public void draw() {
        GraphicsContext gc = this.getGraphicsContext2D();
        Point satelliteLocation = Draw2DHelper.denormalizePoint(currentLevelFunction.getPointEnd());
        Draw2DHelper.drawImage(gc, satelliteLocation, new Image(Asset.SATELLITE), 40);
        
        Point submarineLocation = currentLevelFunction.getPointStart();
        int maxSize = CELL_SIZE / 2;
        Point pointFrom = Draw2DHelper.denormalizePoint(new Point(-1*maxSize, submarineLocation.getY()));
        Point pointTo = Draw2DHelper.denormalizePoint(new Point(maxSize, submarineLocation.getY()));
        Draw2DHelper.drawLine(gc, pointFrom, pointTo, Color.CORAL);
        
//        Draw2DHelper.drawLabel(gc, satelliteLocation, Draw2DHelper.COLOR_SKY);
        Point labelPosition = Draw2DHelper.denormalizePoint(new Point(0, submarineLocation.getY()));
        Draw2DHelper.drawLabelWithText(gc, labelPosition, Draw2DHelper.COLOR_WATER, Integer.toString(submarineLocation.getY()));
    }   
}
