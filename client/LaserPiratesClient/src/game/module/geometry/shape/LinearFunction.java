package game.module.geometry.shape;

import game.module.math.Rational;
import javafx.scene.shape.Line;

/**
 * The <code>LinearFunction</code> class represents a linear function or just line
 * 
 * @author Marco
 */
public class LinearFunction extends Line{

    /**
     * Creates a new instance of Line.
     * @param startX the horizontal coordinate of the start point of the line segment
     * @param startY the vertical coordinate of the start point of the line segment
     * @param endX the horizontal coordinate of the end point of the line segment
     * @param endY the vertical coordinate of the end point of the line segment
     */
    public LinearFunction(int startX, int startY, int endX, int endY) {
        setStartX(startX);
        setStartY(startY);
        setEndX(endX);
        setEndY(endY);
    }
    
    
    /**
     * Creates a new instance of Line.
     * @param startX the horizontal coordinate of the start point of the line segment
     * @param startY the vertical coordinate of the start point of the line segment
     * @param endX the horizontal coordinate of the end point of the line segment
     * @param endY the vertical coordinate of the end point of the line segment
     */
    public LinearFunction(Point x, Point y) {
        if (x.equals(y)) {
            throw new ArithmeticException("The two coordinates do not form a line");
        }
        setStartX(x.getX());
        setStartY(x.getY());
        setEndX(y.getX());
        setEndY(y.getY());
    }
    
    /**
     * Calculates the slope of the two given points
     * @return returns the slope as a <code>Rational</code>
     */
    public Rational getSlope() {
        Rational slope = null;
        int numerator = (int)getEndY() - (int)getStartY();
        int denumerator = (int)getEndX() - (int)getStartX();
        
        try {
            if ((numerator < 0 && denumerator < 0) || denumerator < 0) {
                numerator *= -1;
                denumerator *= -1;
            }
            
            slope = new Rational(numerator, denumerator);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("The calculated slope is not valid");
        }
        
        return slope;
    }
    
    /**
     * 
     * Calculates the intercept of the line
     * @return returns the intercept as an integer
     */
    public int getIntercept() {
        Rational slope = getSlope();
        double intercept = getStartY() - (slope.toDouble() * getStartX());
        
        return (int) intercept;
    }
    
    
    /**
     * 
     * Calculates the intercept of the line
     * @return returns the intercept as an integer
     */
    public double getRawIntercept() {
        Rational slope = getSlope();
        double intercept = getStartY() - (slope.toDouble() * getStartX());
        
        return intercept;
    }
    
    /**
     * This computes the intercept of the line. The result is the same as <code>getIntercept()</code>
     * Used for testing purposes
     * @return intercept of the linear function
     */
    public int getInterceptByPointA() {
        double intercept = getStartY() - (getSlope().toDouble() * getStartX());
        return (int) intercept;
   }
    
    /**
     * 
     * @return returns starting point of line as a <code>Point</code> object
     */
    
    public Point getPointStart() {
        return new Point((int) getStartX(), (int) getStartY());
    }

    /**
     * 
     * @return returns ending point of line as a <code>Point</code> object
     */
    public Point getPointEnd() {
        return new Point((int) getEndX(), (int) getEndY());
    }
    
    /**
     * calculates the y position by a give x
     * @param x
     * @return 
     */
    public double calculateY(int x) {
        Rational multipliedSlope = getSlope().multiply(x);
        return multipliedSlope.toDouble() + getIntercept();
    }
    
    /**
     * calculates the x position by a given y
     * @param y
     * @return 
     */
    public double calculateX(int y) {
        Rational reversedSlope = getSlope().reciprocal();
        return reversedSlope.toDouble() * (y - getIntercept());
    }
}
