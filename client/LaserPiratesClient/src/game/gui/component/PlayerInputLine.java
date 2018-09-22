package game.gui.component;

import game.controller.LevelController;
import game.gui.util.Draw2DHelper;
import static game.gui.level.AbstractLevelRenderer.CELL_SIZE;
import game.level.SubmitObject;
import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;
import game.module.math.Rational;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * A <code>PlayerInputLine</code> enables drawing lines on the canvas.
 * @author Marco
 * @author Lukas
 */
public class PlayerInputLine extends AbstractPlayerInput {
    // The graphics context of the canvas
    GraphicsContext gc;

    private Point lineStart = null;
    private Point lineEnd = null;
    private Point cursor = null;
    private Color lineColor;
    private Button submit;

    public PlayerInputLine(GraphicsContext gc, Color lineColor) {
        this.gc = gc;
        this.lineColor = lineColor;
    }

    @Override
    public void draw() {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();

        gc.setStroke(lineColor);
        gc.setLineWidth(2);

        // highlight lineStart
        if (this.lineStart != null) {
            Draw2DHelper.drawCross(gc, lineStart, lineColor);

            if (this.lineEnd != null) {
                Draw2DHelper.drawCross(gc, lineEnd, lineColor);
            }

            Point end = lineEnd != null ? lineEnd : cursor;
            // redraw line
            if (end != null) {
                double x1 = (lineStart.x) * width / CELL_SIZE;
                double y1 = (lineStart.y) * height / CELL_SIZE;
                double x2 = (end.x) * width / CELL_SIZE;
                double y2 = (end.y) * height / CELL_SIZE;
                
                if (x1 == x2) {
                    gc.strokeLine(x1, 0, x2, height);
                } else {

                    double slope = (y2 - y1) / (x2 - x1);
                    double offset = y1 - x1 * slope;

                    x1 = 0;
                    y1 = offset;
                    x2 = width;
                    y2 = width * slope + offset;

                    gc.strokeLine(x1, y1, x2, y2);
                }
            }
        }

        // highlight coordinate under cursor
        if (cursor != null) {
            double cx = (cursor.x) * width / CELL_SIZE;
            double cy = (cursor.y) * height / CELL_SIZE;
            gc.strokeOval(cx - 5, cy - 5, 10, 10);
        }
    }

    public void resetInput() 
    {
        lineStart = null;
        lineEnd = null;      
    }

    public Point getNormalizedStartPoint() {
        return Draw2DHelper.normalizePoint(lineStart);
        
    }

    public Point getNormalizedEndPoint() {
        return Draw2DHelper.normalizePoint(lineEnd);
    }

    @Override
    public void handle(MouseEvent event) {
        EventType eventType = event.getEventType();
        
        if (eventType == MouseEvent.MOUSE_CLICKED) {
            onMouseClicked(event);
        } else if (eventType == MouseEvent.MOUSE_MOVED) {
            onMouseMoved(event);
        } else if (eventType == MouseEvent.MOUSE_EXITED) {
            cursor = null;
        }
    }
    
        
    private void onMouseClicked(MouseEvent event) {
        double x1 = event.getX();
        double y1 = event.getY();
        Point clicked = Draw2DHelper.pointToCoordinate(gc, x1, y1);

        if (lineStart == null) { // NONE SET
            lineStart = clicked; // set start
        } else if (lineEnd == null) { // START SET
            if (clicked.equals(lineStart)) { // start clicked
                lineStart = null; //  unset start
            } else { // free point clicked
                lineEnd = clicked; // set end
            }
        } else { // BOTH SET
            if (clicked.equals(lineEnd)) { // end clicked
                lineEnd = null; // unset end
            } else if (clicked.equals(lineStart)) { // start clicked
                lineStart = lineEnd; // unset start
                lineEnd = null;
            } else { // free point clicked
                lineStart = clicked; // reset and draw new line
                lineEnd = null;
            }
        }
        
        submit.requestFocus();
    }
    
    private void onMouseMoved(MouseEvent event) {
        cursor = Draw2DHelper.pointToCoordinate(gc, event.getX(), event.getY());
    }

    private boolean canValidate() {
        return lineStart != null && lineEnd != null;
    }
    
    @Override
    public Node getSubmitInput(LevelController levelController) {
        LinearFunction currentFunction = levelController.getLevel().getFunction();
        Canvas equation = Draw2DHelper.getLinearFunctionCanvas(currentFunction);
        
        submit = new Button("Bestätigen");
        submit.setOnAction(evt -> {
            if (this.canValidate()) {
                submit.setDisable(true);
                levelController.onInputSubmit(submitFunction(levelController));
            } else {
                String title = "Eingabe fehlt...";
                String message = "Du hast noch keine Eingabe durchgeführt. "
                        + "Zeichne bitte die Gerade ein um weiterzukommen";
                AlertBox.display(title, message);
            }
        });
        
        submit.setOnKeyPressed(evt -> {
            if (evt.getCode() == KeyCode.ENTER) {
                evt.consume();
                if (this.canValidate()) {
                    submit.setOnKeyPressed(null);
                    submit.setDisable(true);
                    levelController.onInputSubmit(submitFunction(levelController));
                } else {
                    String title = "Eingabe fehlt...";
                    String message = "Du hast noch keine Eingabe durchgeführt. "
                            + "Zeichne bitte die Gerade ein um weiterzukommen";
                    AlertBox.display(title, message);
                }
            }
        });
        
        VBox bottomBar = new VBox();
        bottomBar.setBackground(new Background(new BackgroundFill(Color.web("#1a1a1a"), CornerRadii.EMPTY, Insets.EMPTY)));
        bottomBar.setPadding(new Insets(5.0));
        bottomBar.getChildren().add(equation);
        bottomBar.getChildren().add(submit);

        return bottomBar;
    }
    
    @Override
    public SubmitObject<LinearFunction> submitFunction(LevelController levelController) { 
        Point pointStart = getNormalizedStartPoint();
        Point pointEnd = getNormalizedEndPoint();
        return new SubmitObject<>(new LinearFunction(pointStart, pointEnd));
    }

    @Override
    public void setFalseInput(SubmitObject submit) { }
}
