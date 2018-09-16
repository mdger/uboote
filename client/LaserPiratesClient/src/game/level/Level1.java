package game.level;

import game.controller.LevelState;
import game.gui.level.AbstractLevelRenderer;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import game.module.sprite.Asset;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.beans.InvalidationListener;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * @author Marco
 */
public class Level1 extends AbstractLevel {
    
    public Level1() {
        LinearFunction function = getFunction();
        FunctionGeneratorConfig config = new FunctionGeneratorConfig();
        config.setMaxValue(10);
        int maxIntercept = AbstractLevelRenderer.CELL_SIZE / 2;
        config.setMaxIntercept(maxIntercept);
        function = LinearFunctionGenerator.generateLinearFunction(config);
        setFunction(function);
        
        System.out.println("Level 1 generated");
        System.out.println("Submarine Location: "+function.getPointStart());
        System.out.println("Satellite Location: "+function.getPointEnd());
    } 

    @Override
    public int getWinCondition() {
        return 5;
    }

    @Override
    public Node getDescription() {
        VBox layout = new VBox();
        
        Image admiral = new Image(Asset.ADMIRAL, 96, 0, true, true);
        ImageView image = new ImageView(admiral);
        
        Label fluff = new Label(
"Moin Schiffsjunge. Als neuer \"freiwilliger\" Rekrut der Seeflotte ist es deine Aufgabe,\n"
+ "uns bei der Bekämpfung der bösen π-raten zu unterstützen.\n"
+ "Mir wurde zugebracht, dass du als Waffenspezialist, dich bestens mit unserem Arsenal auskennst\n"
+ "und mit einem blitzschnellen Verstand gesegnet bist. Die Zeit wird zeigen, ob du der Seeflotte würdig bist. \n\n"
+ "Du befindest dich aktuell in Sektor 1 in einem unserer Aufkärungs-U-Boote\n"
+ "Deine erste Aufgabe ist das Dokumentieren von Schusslinien.\n"
+ "Dir wird eine lineare Funktion übergeben, die du einzeichnen sollst.\n"
+ "Mir ist zu Ohren gekommen, dass sich aktuell 5 Flugzeuge in diesem Sektor befinden.\n\n"
+ "Steuerung:\n"
+ "Klicke einmal auf dem Spielfeld und ziehe eine Gerade mit der erforderlichen Steigung\n"
+ "und klicke ein zweites Mal um die Gerade festzuhalten. Klicke auf Bestätigen\n"
+ "wenn du mit der Gerade zufrieden bist.\n"
+ "");
        
        layout.getChildren().add(image);
        layout.getChildren().add(fluff);
        layout.setAlignment(Pos.CENTER);
        return layout;
    }

    @Override
    public Node getBriefing() {
        VBox layout = new VBox();
        return layout;
    }
    
    @Override
    public LevelState getCurrentState() {
        return LevelState.LEVEL_1;
    }

    @Override
    public LevelState getNextLevelState() {
        return LevelState.LEVEL_2;
    }
}
