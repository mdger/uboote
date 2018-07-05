package game.gui.level;

import game.controller.LevelController;
import static game.gui.level.AbstractLevelRenderer.CELL_SIZE;
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
public class LevelRenderer4 extends AbstractLevelRenderer {
    
    private final LinearFunction currentLevelFunction;
    
    public LevelRenderer4(LinearFunction currentLevelFunction) {
        super();
        this.currentLevelFunction = currentLevelFunction;
        setShowHelperLine(false);
    }

    @Override
    public void draw() {
        GraphicsContext gc = this.getGraphicsContext2D();

        Point satelliteLocation = Draw2DHelper.denormalizePoint(currentLevelFunction.getPointEnd());
        Draw2DHelper.drawImage(gc, satelliteLocation, new Image(Asset.PLANE), 40);

        Point submarineLocation = Draw2DHelper.denormalizePoint(currentLevelFunction.getPointStart());
        Draw2DHelper.drawImage(gc, submarineLocation, new Image(Asset.SUBMARINE), 40);

        Draw2DHelper.drawLabel(gc, satelliteLocation, Draw2DHelper.COLOR_SKY);
        Draw2DHelper.drawLabel(gc, submarineLocation, Draw2DHelper.COLOR_WATER);
    }   
}
