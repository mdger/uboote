package game.module.geometry.shape;

import com.sun.javafx.geom.Point2D;
import game.module.math.Rational;

/**
 * The <code>Point</code> class defines a point representing a location
 * in {@code (x,y)} coordinate space.
 * 
 * @author Marco
 * <p>
 */

public class Point extends Point2D {
    /**
     * Constructs and initializes a <code>Point2D</code> with
     * the specified coordinates.
     *
     * @param x the X coordinate of the newly
     *          constructed <code>Point2D</code>
     * @param y the Y coordinate of the newly
     *          constructed <code>Point2D</code>
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Sets the location of this <code>Point2D</code> to the
     * specified <code>float</code> coordinates.
     *
     * @param x the new X coordinate of this {@code Point2D}
     * @param y the new Y coordinate of this {@code Point2D}
     */
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    /**
     * offsets x of  <code>Point2D</code> to the
     * specified <code>float</code> coordinates.
     *
     * @param offsetX the new X coordinate of this {@code Point2D}
     * @param offsetY the new Y coordinate of this {@code Point2D}
     * @return 
     */
    public Point offsetLocation(int offsetX, int offsetY) {
        return new Point((int)this.x + offsetX, (int)this.y + offsetY);
    }
    
    
    /**
     * Sets the location of this <code>Point2D</code> to the
     * specified <code>float</code> coordinates.
     *
     * @param offsetX the new X coordinate of this {@code Point2D}
     * @return 
     */
    public Point offsetX(int offsetX) {
        return new Point((int)this.x + offsetX, (int)this.y);
    }
    
    /**
     * Sets the location of this <code>Point2D</code> to the
     * specified <code>float</code> coordinates.
     *
     * @param offsetY
     * @return 
     */
    public Point offsetY(int offsetY) {
        return new Point((int)this.x, (int)this.y + offsetY);
    }

    /**
     * Sets the location of this <code>Point2D</code> to the same
     * coordinates as the specified <code>Point2D</code> object.
     * @param p the specified <code>Point2D</code> to which to set
     * this <code>Point2D</code>
     */
    public void setLocation(Point p) {
        setLocation(p.x, p.y);
    }
   
    /**
     * 
     * @return x of point
     */
    public int getX() {
        return (int) this.x;
    }
    
    /**
     * 
     * @return y of point
     */
    public int getY() {
        return (int) this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public Point factor(int factor) {
        return new Point((int)(x * factor), (int)(y * factor));
    }
    
    public Point factor(Rational rational) {
        return new Point((int)(x * rational.getNum()), (int)(y * rational.getDen()));
    }
    
    @Override
    public String toString() {
        return getX() + ", " + getY();
    }
}
