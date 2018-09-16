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
public class Level4 extends AbstractLevel{
    
    public Level4() {
        LinearFunction function = getFunction();
        FunctionGeneratorConfig config = new FunctionGeneratorConfig();
        config.setMaxValue(19);
        
        function = LinearFunctionGenerator.generateLinearFunction(config);
        setFunction(function);
        
        System.out.println("Level 4 generated");
        System.out.println("Submarine Location: "+function.getPointStart());
        System.out.println("Airplane Location: "+function.getPointEnd());
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
"Wir haben es fast geschafft. Deine Errungenschaften bis jetzt erfüllen mich mit Stolz.\n"
+ "Es ist mir eine Ehre dir den Titel Vollmatrose 2. Grades zu verleihen.\n"
+ "Hier in Sektor 4 werden wir die letzten feindlichen Kampfflugzeuge von der Luft holen!\n"
+ "Wir werden sie in unserem Anti-Luft-U-Boot überraschen und sie dann mit Raketen in\n"
+ "tausende Teile dividieren! Ha, sie werden uns erst bemerken, wenn es zu spät ist.\n"
+ "Die Flugzeuge sind klar sichtbar. Du musst den genauen Schusswinkel als lineare Funktion\n"
+ "ermitteln. Aktuell haben wir insgesamt 10 Kampfflugzeuge vom Typ 'Schwach-Gegen-Geraden' gesichtet.\n"
+ "Wenn das alles vorbei ist, trinken wir gemeinsam auf die Linearen Funktionen.\n"
+ "Ein Hoch auf die Geraden und die Mathematik!\n"
+ "Viel Erfolg Vollmatrose!\n"
+ "\n"
+ "Steuerung:\n"
+ "Auf dem Spielfeld siehst du das U-Boot und das gegnerische Flugzeug.\n"
+ "Berechne die Steigungsgerade und die Verschiebungskonstante und gib diese\n"
+ "in die drei leeren Felder ein.\n"
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
    
    @Override
    public LevelState getCurrentState() {
        return LevelState.LEVEL_4;
    }

    @Override
    public LevelState getNextLevelState() {
        return LevelState.LEVEL_END;
    }        
}
