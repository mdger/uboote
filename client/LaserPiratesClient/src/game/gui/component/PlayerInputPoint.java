package game.gui.component;

import game.controller.LevelController;
import game.gui.util.Draw2DHelper;
import game.level.SubmitObject;
import game.module.geometry.shape.LinearFunction;
import game.module.math.Rational;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * A <code>PlayerInputLine</code>
 * @author Marco
 */
public abstract class PlayerInputPoint extends AbstractPlayerInput {
    // The graphics context of the canvas
    private NumberFieldInput fieldInput;
    private Button submit;
    
    @Override
    public void draw() {
        // TODO draw point by clicking?
    }

    @Override
    public void handle(MouseEvent event) {
    }
    
    @Override
    public Node getSubmitInput(LevelController levelController) {
        LinearFunction currentFunction = levelController.getLevel().getFunction();
        Rational slope = currentFunction.getSlope();
        Canvas equation = Draw2DHelper.getLinearFunctionCanvas(currentFunction);

        fieldInput = new NumberFieldInput();
        fieldInput.setRestrict("-?[0-9]*");
        fieldInput.requestFocus();
        fieldInput.setPromptText("Tiefe Eingeben");
        fieldInput.setMinWidth(50);
        
        fieldInput.setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                evt.consume();
                if (!fieldInput.getText().isEmpty() &&
                        !fieldInput.getText().equals("-")) {
                    levelController.onInputSubmit(submitFunction(levelController));
                    fieldInput.setDisable(true);
                    submit.setDisable(true);
                } else {
                    String title = "Eingabe fehlt...";
                    String message = "Du hast noch keine Eingabe durchgeführt. "
                            + "Gib bitte die Tiefe an, um weiterzukommen";
                    AlertBox.display(title, message);
                }
            }
        });
        
        submit = new Button("Bestätigen");
        submit.setOnAction(evt -> {
            if (!fieldInput.getText().isEmpty() &&
                    !fieldInput.getText().equals("-")) {
                levelController.onInputSubmit(submitFunction(levelController));
                fieldInput.setDisable(true);
                submit.setDisable(true);
            } else {
                String title = "Eingabe fehlt...";
                String message = "Du hast noch keine Eingabe durchgeführt. "
                        + "Gib bitte die Tiefe an, um weiterzukommen";
                AlertBox.display(title, message);
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

    /**
     * @return 
     */
    protected NumberFieldInput getFieldInput() {
        if (fieldInput == null) {
            fieldInput = new NumberFieldInput();
        }
        
        return fieldInput;
    }
    
    /**
     * @param submit 
     */
    
    @Override
    public void setFalseInput(SubmitObject submit) {
        NumberFieldInput numberFieldInput = getFieldInput();
        numberFieldInput.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
}
