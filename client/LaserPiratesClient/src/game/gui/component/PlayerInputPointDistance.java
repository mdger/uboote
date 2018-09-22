package game.gui.component;

import game.controller.LevelController;
import game.gui.util.Draw2DHelper;
import game.level.SubmitObject;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Marco
 */
public class PlayerInputPointDistance extends PlayerInputPoint {
    
    /**
     * @param levelController
     * @return 
     */
    @Override
    public Node getSubmitInput(LevelController levelController) {
        LinearFunction currentFunction = levelController.getLevel().getFunction();
        Canvas equation = Draw2DHelper.getLinearFunctionCanvas(currentFunction);

        NumberFieldInput fieldInput = getFieldInput();
        fieldInput.setRestrict("-?[0-9]*");
        fieldInput.setPromptText("X Eingeben");
        fieldInput.setMinWidth(50);
        
        Button submit = new Button("Bestätigen");
        submit.setOnAction(evt -> {
            if (!fieldInput.getText().isEmpty()) {
                levelController.onInputSubmit(submitFunction(levelController));
                fieldInput.setDisable(true);
                submit.setDisable(true);
            } else {
                String title = "Eingabe fehlt...";
                String message = "Du hast noch keine Eingabe durchgeführt. "
                        + "Gib bitte Koordinate X an, um weiterzukommen";
                AlertBox.display(title, message);
            }
        });

        fieldInput.setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                evt.consume();
                if (!fieldInput.getText().isEmpty()) {
                    levelController.onInputSubmit(submitFunction(levelController));
                    fieldInput.setDisable(true);
                    submit.setDisable(true);
                } else {
                    String title = "Eingabe fehlt...";
                    String message = "Du hast noch keine Eingabe durchgeführt. "
                            + "Gib bitte Koordinate X an, um weiterzukommen";
                    AlertBox.display(title, message);
                }
            }
        });
        
        VBox bottomBar = new VBox();
        bottomBar.setPadding(new Insets(5.0));
        bottomBar.setBackground(new Background(new BackgroundFill(Color.web("#1a1a1a"), CornerRadii.EMPTY, Insets.EMPTY)));
        HBox inputRow = new HBox();
        inputRow.setSpacing(10.0);
        inputRow.getChildren().addAll(fieldInput, submit);
        bottomBar.getChildren().addAll(equation, inputRow);

        return bottomBar;
    }
    
    @Override
    public SubmitObject<Point> submitFunction(LevelController levelController) {   
        NumberFieldInput fieldInput = getFieldInput();
        Point pointSubmit = levelController.getLevel().getFunction().getPointStart();
        int distance = Integer.parseInt(fieldInput.getText());
        pointSubmit.setX(distance);
        
        return new SubmitObject<>(pointSubmit);
    } 
}
