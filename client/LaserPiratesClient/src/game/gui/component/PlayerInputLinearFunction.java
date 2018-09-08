package game.gui.component;

import game.controller.LevelController;
import game.level.SubmitObject;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import game.module.math.Rational;
import javafx.geometry.Insets;
import javafx.scene.Node;
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
 *
 * @author Marco
 */
public class PlayerInputLinearFunction extends AbstractPlayerInput {
    private NumberFieldInput fieldInputNumerator;
    private NumberFieldInput fieldInputDenumerator;
    private NumberFieldInput fieldInputIntercept;
    
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
        int intercept = currentFunction.getIntercept();
        
        Label equation = new Label(String.format("Zielgleichung: f(x) = %d/%d x + %d",
            slope.getNum(), slope.getDen(), intercept
        ));

        fieldInputNumerator = new NumberFieldInput();
        fieldInputNumerator.setRestrict("-?[0-9]*");
        fieldInputNumerator.setPromptText("Zähler");
        fieldInputNumerator.setMinWidth(50);
        
        Label labelSlash = new Label("/");
        labelSlash.setFont(Font.font(null, FontWeight.BOLD, 15));
        labelSlash.setTextFill(Color.web("#40ff00"));
        
        fieldInputDenumerator = new NumberFieldInput();
        fieldInputDenumerator.setRestrict("-?[0-9]*");
        fieldInputDenumerator.setPromptText("Nenner");
        fieldInputDenumerator.setMinWidth(50);
        
        Label labelPlus = new Label("+");
        labelPlus.setFont(Font.font(null, FontWeight.BOLD, 15));
        labelPlus.setTextFill(Color.web("#40ff00"));
        
        fieldInputIntercept = new NumberFieldInput();
        fieldInputIntercept.setPromptText("Konstante");
        fieldInputIntercept.setRestrict("-?[0-9]*");
        fieldInputIntercept.setMinWidth(50);
        
        submit = new Button("Bestätigen");
        submit.setOnAction(evt -> {
            if (!fieldInputNumerator.getText().isEmpty() && 
                    !fieldInputNumerator.getText().equals("-") &&
                    !fieldInputDenumerator.getText().equals("-") &&
                    !fieldInputIntercept.getText().equals("-")) {
                levelController.onInputSubmit(submitFunction(levelController));
                fieldInputNumerator.setDisable(true);
                fieldInputDenumerator.setDisable(true);
                fieldInputIntercept.setDisable(true);
                submit.setDisable(true);
            } else {
                String title = "Eingabe fehlt...";
                String message = "Du hast noch keine Eingabe durchgeführt. "
                        + "Gib bitte die Tiefe an, um weiterzukommen";
                AlertBox.display(title, message);
            }
        });
        
        fieldInputIntercept.setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                evt.consume();
                if (!fieldInputNumerator.getText().isEmpty() && 
                        !fieldInputNumerator.getText().equals("-") &&
                        !fieldInputDenumerator.getText().equals("-") &&
                        !fieldInputIntercept.getText().equals("-")) {
                    levelController.onInputSubmit(submitFunction(levelController));
                    fieldInputNumerator.setDisable(true);
                    fieldInputDenumerator.setDisable(true);
                    fieldInputIntercept.setDisable(true);
                    submit.setDisable(true);
                } else {
                    String title = "Eingabe fehlt...";
                    String message = "Du hast noch keine Eingabe durchgeführt. "
                            + "Gib bitte die Tiefe an, um weiterzukommen";
                    AlertBox.display(title, message);
                }
            }
        });
        
        fieldInputNumerator.setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                evt.consume();
                if (!fieldInputNumerator.getText().isEmpty() && 
                        !fieldInputNumerator.getText().equals("-") &&
                        !fieldInputDenumerator.getText().equals("-") &&
                        !fieldInputIntercept.getText().equals("-")) {
                    levelController.onInputSubmit(submitFunction(levelController));
                    fieldInputNumerator.setDisable(true);
                    fieldInputDenumerator.setDisable(true);
                    fieldInputIntercept.setDisable(true);
                    submit.setDisable(true);
                } else {
                    String title = "Eingabe fehlt...";
                    String message = "Du hast noch keine Eingabe durchgeführt. "
                            + "Gib bitte die Tiefe an, um weiterzukommen";
                    AlertBox.display(title, message);
                }
            }
        });
        
        fieldInputDenumerator.setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                evt.consume();
                if (!fieldInputNumerator.getText().isEmpty() && 
                        !fieldInputNumerator.getText().equals("-") &&
                        !fieldInputDenumerator.getText().equals("-") &&
                        !fieldInputIntercept.getText().equals("-")) {
                    levelController.onInputSubmit(submitFunction(levelController));
                    fieldInputNumerator.setDisable(true);
                    fieldInputDenumerator.setDisable(true);
                    fieldInputIntercept.setDisable(true);
                    submit.setDisable(true);
                } else {
                    String title = "Eingabe fehlt...";
                    String message = "Du hast noch keine Eingabe durchgeführt. "
                            + "Gib bitte die Tiefe an, um weiterzukommen";
                    AlertBox.display(title, message);
                }
            }
        });

        VBox bottomBar = new VBox();
        bottomBar.setPadding(new Insets(5.0));
        bottomBar.setBackground(new Background(new BackgroundFill(Color.web("#1a1a1a"), CornerRadii.EMPTY, Insets.EMPTY)));
        HBox inputRow = new HBox();
        inputRow.setSpacing(10.0);
        inputRow.getChildren().addAll(fieldInputNumerator, labelSlash, fieldInputDenumerator, labelPlus, fieldInputIntercept, submit);
        // FIXME remove debug output
        System.out.println(equation.getText());
//        bottomBar.getChildren().add(equation);
        bottomBar.getChildren().add(inputRow);

        return bottomBar;
    }
        
    @Override
    public SubmitObject<LinearFunction> submitFunction(LevelController levelController) {
        if (fieldInputDenumerator.getText().isEmpty()) 
            fieldInputDenumerator.setText("1");
        
        if (fieldInputIntercept.getText().isEmpty()) 
            fieldInputIntercept.setText("0");
        
        int intercept = Integer.parseInt(fieldInputIntercept.getText());
        // math ;)
        int xOfPointEnd = Integer.parseInt(fieldInputDenumerator.getText());
        int yOfPointEnd = Integer.parseInt(fieldInputNumerator.getText());
        
        Point pointStart = new Point(0, 0 + intercept);
        Point pointEnd = new Point(xOfPointEnd, yOfPointEnd + intercept);
        return new SubmitObject<>(new LinearFunction(pointStart, pointEnd));
    }
}
