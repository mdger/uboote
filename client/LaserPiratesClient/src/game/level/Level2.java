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
 * @author Marco
 */
public class Level2 extends AbstractLevel {
    
    public Level2() {
        LinearFunction function = getFunction();
        FunctionGeneratorConfig config = new FunctionGeneratorConfig();
        config.setMaxValue(19);
        
        // Set satellite height
        config.setBy(10);
        
        function = LinearFunctionGenerator.generateLinearFunction(config);
        setFunction(function);
        
        System.out.println("Level 2 generated");
        System.out.println("Submarine Location: "+function.getPointStart());
        System.out.println("Satellite Location: "+function.getPointEnd());
    } 

    @Override
    public int getWinCondition() {
        return 5;
    }


    @Override
    public LevelState getCurrentState() {
        return LevelState.LEVEL_2;
    }

    @Override
    public LevelState getNextLevelState() {
        return LevelState.LEVEL_3;
    }

    @Override
    public Node getDescription() {
        VBox layout = new VBox();
        Image admiral = new Image(Asset.ADMIRAL, 96, 0, true, true);
        ImageView image = new ImageView(admiral);
        
        Label fluff = new Label(
"Du hast dich in Sektor 1 gut geschlagen. Ich befördere dich hiermit Kraft meines Amtes\n"
+ "zum Leichtmatrosen\n"
+ "Ich hoffe dass du zukünftig uns weiter gute Dienste leisten wirst.\n"
+ "Ich habe dich hier in Sektor 2 vesetzt, damit du unseren Kriegskreuzer bei der Beseitigung\n"
+ "von feindlichen U-Booten unterstüzt.\n"
+ "...Hä? Oh du heilige quadratische Funktion... Die U-Boote haben uns bereits vollkommen umstellt.\n "
+ "Sie befinden sich direkt unter uns! Ich zähle insgesamt 5 feindliche U-Boote\n"
+ "Unserere Ortungs-Satelliten haben bereits die ungefähre Position der U-Boote lokalisiert\n"
+ "und übermittelt uns diese als lineare Funktion ausgehend vom Satelliten.\n"
+ "Die genaue Tiefe muss aber von dir noch ermittelt werden, damit unsere Seebomben sie\n"
+ "genau dort treffen wo es wehtut. Viel Erfolg!\n"
+ "\n"
+ "Steuerung:\n"
+ "Auf dem Spielfeld siehst du das Schiff und den Satelliten, aber nicht das U-Boot.\n"
+ "Der Satellit ist ein Punkt der Geradengleichung. Als zusätzliche Hilfe dient der\n"
+ "Kriegskreuzer, welches sich direkt über dem U-Boot befindet. Berechne die Tiefe\n"
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
