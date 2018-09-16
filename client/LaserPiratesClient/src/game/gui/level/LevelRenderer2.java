package game.gui.level;

import game.gui.level.AbstractLevelRenderer;
import game.gui.util.Draw2DHelper;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import game.module.sprite.Asset;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**
 *
 * @author Marco
 */
public class LevelRenderer2 extends AbstractLevelRenderer {
    
    private final LinearFunction currentLevelFunction;
    
    public LevelRenderer2(LinearFunction currentLevelFunction) {
        super();
        this.currentLevelFunction = currentLevelFunction;
        setShowHelperLine(false);
    }

    @Override
    public void draw() {
        GraphicsContext gc = this.getGraphicsContext2D();

        int submarineLocationX = currentLevelFunction.getPointStart().getX();
        
        Point shipLocation = Draw2DHelper.denormalizePoint(new Point(submarineLocationX, 0));
        Point satelliteLocation = Draw2DHelper.denormalizePoint(currentLevelFunction.getPointEnd());
        
        Draw2DHelper.drawImage(gc, satelliteLocation, new Image(Asset.SATELLITE), 40);
        Draw2DHelper.drawImage(gc, shipLocation, new Image(Asset.CRUISER), 40);
        Draw2DHelper.drawLabel(gc, satelliteLocation, Draw2DHelper.COLOR_SKY);
        Draw2DHelper.drawLabelWithText(gc, shipLocation, Draw2DHelper.COLOR_WATER, Integer.toString(shipLocation.getX()));
    }   
}
