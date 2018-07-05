package game.level;

import game.controller.LevelState;
import game.module.geometry.shape.LinearFunction;
import game.module.sprite.Asset;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Marco
 */
public class Level3 extends AbstractLevel {
    
    public Level3() {
        LinearFunction function = getFunction();
        FunctionGeneratorConfig config = new FunctionGeneratorConfig();
        config.setMaxValue(19);
        
        // Set satellite height
//        config.setBy(10);
        
        function = LinearFunctionGenerator.generateLinearFunction(config);
        setFunction(function);
        
        System.out.println("Level 3 generated");
        System.out.println("Submarine Location: "+function.getPointStart());
        System.out.println("Satellite Location: "+function.getPointEnd());
        System.out.println("Intercept: "+function.getRawIntercept());
    } 

    @Override
    public int getWinCondition() {
        return 5;
    }

    @Override
    public LevelState getCurrentState() {
        return LevelState.LEVEL_3;
    }

    @Override
    public LevelState getNextLevelState() {
        return LevelState.LEVEL_4;
    }    

    @Override
    public Node getDescription() {
        VBox layout = new VBox();
        Image admiral = new Image(Asset.ADMIRAL, 96, 0, true, true);
        ImageView image = new ImageView(admiral);
        
        Label fluff = new Label(
"Sehr gut. Ich bin sehr zufrieden mit deinen Leistungen. Ab dem heutigen Tag\n"
+ "bist du ein Vollmatrose 1. Grades.\n"
+ "Um dieses Scharmützel zu durchstehen, benötigt es aber noch mehr!\n"
+ "Wir haben unseren Kreuzer nach Sektor 3 verlagert, um die restlichen U-Boote zu\n"
+ "zerstören.\n"
+ "Dieses Mal werden wir in die Offensive gehen und diese verdammten U-Boote aus diesem "
+ "Sektor tilgen.\n"
+ "Unserere Ortungs-Satelliten haben bereits die ungefähre Position der U-Boote lokalisiert\n"
+ "und übermittelt uns diese als lineare Funktion ausgehend vom Satelliten.\n"
+ "Uns ist deren Tiefe bereits bekannt, die genaue Position muss aber noch von uns\n"
+ "ermittelt werden. Sichtungen zufolge befinden sich aktuell 5 U-Boote in diesem Sektor\n"
+ "Viel Erfolg!\n"
+ "\n"
+ "Steuerung:\n"
+ "Auf dem Spielfeld siehst du den Satelliten, aber nicht das U-Boot.\n"
+ "Der Satellit ist ein Punkt der Geradengleichung. Als zusätzliche Hilfe dient die\n"
+ "Hilfslinie, auf welchem sich das U-Boot befindet. Berechne die genaue Position\n"
+ "des U-Bootes und gib diese in das leere Feld ein.\n"
+ "Wenn du mit der Eingabe zufrieden bist, klicke auf Bestätigen.\n"
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
}
