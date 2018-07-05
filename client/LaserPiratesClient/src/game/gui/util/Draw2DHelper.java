package game.gui.util;

import com.sun.javafx.geom.Line2D;
import static game.gui.level.AbstractLevelRenderer.CELL_SIZE;
import game.module.geometry.shape.Point;
import game.module.sprite.Asset;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Affine;

/**
 *
 * @author Marco
 */
public class Draw2DHelper {
    
    private static final int WIDTH_CLOUDS = -544;
    private static final int HEIGHT_CLOUDS = 236;
    private static final Image CLOUD_IMAGE = new Image(Asset.CLOUDS, WIDTH_CLOUDS, HEIGHT_CLOUDS, true, true);
    
    private static final int HEIGHT_SKY = 304;
    private static final Image SKY_IMAGE = new Image(Asset.SKY, 0, HEIGHT_SKY, true, true);
    
    private static final int HEIGHT_SEA = 96;
    private static final Image SEA_IMAGE = new Image(Asset.SEA, 0, HEIGHT_SEA, true, true);
    
    public static final String COLOR_SKY = "#a1f2ec";
    public static final String COLOR_WATER = "#71baaa";
    
    /**
     * Draws a coordinate space
     * @param gc 
     * @param tick 
     */
    
    public static void drawCoordinateSpace(GraphicsContext gc, double tick) {
        Canvas backgroundCanvas = gc.getCanvas();
        double width = backgroundCanvas.getWidth();
        double height = backgroundCanvas.getHeight();
        gc.clearRect(0, 0, width, height);
        
        // clear with sky colour
        gc.setFill(Color.web("#a1f2ec"));
        gc.fillRect(0, 0, width, height);
        
        // redraw water
        gc.setFill(Color.web("#71baaa"));
        gc.fillRect(0, height / 2, width, height);
        
        // redraw coordinate system
        gc.setStroke(Color.web("#444"));
        gc.setLineWidth(.5);
        
        // Background Sky
       int widthSky = 0;
       double offsetSkyY = (height / 2) - HEIGHT_SKY;
        while(widthSky < width) {
            gc.drawImage(SKY_IMAGE, widthSky, offsetSkyY);
            widthSky += 112;
        }
        
        // Background clouds
       int widthClouds = WIDTH_CLOUDS;
       double offsetCouldsY = (height / 2) - HEIGHT_CLOUDS;
        while(widthClouds < width) {
            gc.drawImage(CLOUD_IMAGE, widthClouds + (tick*544), offsetCouldsY);
            widthClouds += 544;
        }
        
        // Background Sea horizon
       int widthSea = 0;
        while(widthSea < width) {
            gc.drawImage(SEA_IMAGE, widthSea, height / 2);
            widthSea += 112;
        }
        
        // Coordinate system lines and numbers
        gc.setFill(Color.web("#444"));
        gc.setStroke(Color.web("#444"));
        for (int i = 0; i <= CELL_SIZE; i++) {
            
            if (i == CELL_SIZE / 2) {
                // thicker lines for the center
                gc.setLineWidth(1.5);
            } else {
                gc.setLineWidth(.5);
            }
            
            // vertical
            double x = width * ((double)i / CELL_SIZE);
            gc.strokeLine(x, 0, x, height);
            // horizontal
            double y = height * ((double)i / CELL_SIZE);
            gc.strokeLine(0, y, width, y);
            
            // draw labels
            if (i % 5 == 0) {
                gc.fillText(String.valueOf(i - CELL_SIZE / 2), x, height / 2);
                gc.fillText(String.valueOf(-i + CELL_SIZE / 2), width / 2, y);
            }
        }
    }
    
    /**
     * Draws a cross on point.
     * @param gc
     * @param p location of the point
     * @param color color of the cross
     */
    
    public static void drawCross(GraphicsContext gc, Point p, Color color) {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();
        double sx = (p.getX()) * width / CELL_SIZE;
        double sy = (p.getY()) * height / CELL_SIZE;

        // redraw cross
        gc.setStroke(color);
        gc.setLineWidth(2);
        gc.strokeLine(sx - 5, sy - 5, sx + 5, sy + 5);
        gc.strokeLine(sx - 5, sy + 5, sx + 5, sy - 5);        
    }
    
    
    /**
     * Draws a cross on point.
     * @param gc
     * @param p location of the point
     * @param color color of the cross
     */
    
    public static Point convertPointToCanvas(double width, double height, Point p) {
        int sx = (p.getX()) * (int) width / CELL_SIZE;
        int sy = (p.getY()) * (int) height / CELL_SIZE;
        
        return new Point(sx, sy);
    }
    
    
    /**
     * Calculates a coordinate on the coordinate space by the cell size, width and height of the
     * parent element
     * @param width of the parent element
     * @param height of the parent element
     * @param p 
     */
    
    public static Point pointToCoordinate(double width, double height , Point p) {
        int pointX = (int)Math.round(p.getX() / width * CELL_SIZE);
        int pointY = (int)Math.round(p.getY() / height * CELL_SIZE);
        
        return new Point(pointX, pointY);
    }    
    
    /**
     * Draws a line
     * @param gc
     * @param from starting position
     * @param to end position
     * @param color 
     */
    
    public static void drawLine(GraphicsContext gc, Point from, Point to, Color color) {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();
        double cellWidth = width / CELL_SIZE;
        double cellHeight = height / CELL_SIZE;
        
        double sx = (from.getX()) * cellWidth;
        double sy = (from.getY()) * cellHeight;
        
        double tx = (to.getX()) * cellWidth;
        double ty = (to.getY()) * cellHeight;

        // redraw cross
        gc.setStroke(color);
        gc.setLineWidth(2);
        gc.strokeLine(sx, sy, tx, ty);
    }    
    
    
    /**
     * Draws an image
     * @param gc
     * @param p position of the image
     * @param image the image
     */
    
    public static void drawImage(GraphicsContext gc, Point p, Image image) {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();
        double imageWidth = width / CELL_SIZE;
        double imageHeight = height / CELL_SIZE;
        double x = (p.getX() * width / CELL_SIZE) - imageWidth / 2;
        double y = (p.getY() * height / CELL_SIZE) - imageHeight / 2;
        
        // redraw cross
        gc.drawImage(image, x, y, imageWidth, imageHeight);
    }    
    
    
    /**
     * Draws an image
     * @param gc
     * @param p position of the image
     * @param image the image
     * @param imageSize size of the image
     */
    
    public static void drawImage(GraphicsContext gc, Point p, Image image, double imageSize) {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();
        double imageWidth = imageSize;
        double imageHeight = imageSize;
        double x = (p.getX() * width / CELL_SIZE) - imageWidth / 2;
        double y = (p.getY() * height / CELL_SIZE) - imageHeight / 2;
        
        // redraw cross
        gc.drawImage(image, x, y, imageWidth, imageHeight);
    }    
    
    
    /**
     * Draws a label
     * @param gc
     * @param p position of the label
     * @param colorWeb color of the background in web format e.g. #333
     */
    
    public static void drawLabel(GraphicsContext gc, Point p, String colorWeb) {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();
        double x = (p.getX() - .5) * width / CELL_SIZE;
        double y = (p.getY() + .5) * height / CELL_SIZE;
        
        gc.setStroke(Color.web("#111"));
        gc.setFill(Color.web(colorWeb));
        gc.setLineWidth(.8);
        gc.fillRect(x, y, 38, 12);
        gc.strokeText(normalizePoint(p).toString(), x + 3, y + 11);
    }    
    
    /**
     * method to get a <code>Point</code> by two doubles to help rendering
     * a single location on a coordinate space
     * @param gc
     * @param x
     * @param y
     * @return 
     */
    
    public static Point pointToCoordinate(GraphicsContext gc, double x, double y) {
        double width = gc.getCanvas().getWidth();
        double height = gc.getCanvas().getHeight();
        int pointX = (int)Math.round(x / width * CELL_SIZE);
        int pointY = (int)Math.round(y / height * CELL_SIZE);
        
        return new Point(pointX, pointY);
    }    
    
    /**
     * method to get a <code>Point</code> by two doubles to help rendering
     * a single location on a coordinate space
     * @param gc
     * @param p
     * @return 
     */
    public static Point pointToCoordinate(GraphicsContext gc, Point p) {
        int pointX = intToX(gc, p.getX());
        int pointY = intToY(gc, p.getY());
        
        return new Point(pointX, pointY);
    }    
    
    /**
     * method to get a <code>Point</code> by two doubles to help rendering
     * a single location on a coordinate space
     * @param gc
     * @param y
     * @return 
     */
    public static int intToY(GraphicsContext gc, int y) {
        double height = gc.getCanvas().getHeight();
        int result = (int)Math.round(y / height * CELL_SIZE);
        
        return result;
    }     
    
    /**
     * method to get a <code>Point</code> by two doubles to help rendering
     * a single location on a coordinate space
     * @param gc
     * @param x
     * @return 
     */
    public static int intToX(GraphicsContext gc, int x) {
        double width = gc.getCanvas().getWidth();
        int result = (int)Math.round(x / width * CELL_SIZE);
        
        return result;
    }    
    
    public static int normalizeX(int x) {
        return ((x - (CELL_SIZE / 2))) % CELL_SIZE;
    }
    
    private static int denormalizeX(int x) {
        return (x % CELL_SIZE + (CELL_SIZE / 2)) ;
    }
    
    public static int normalizeY(int y) {
        return (-1*y   % CELL_SIZE + (CELL_SIZE / 2));
    }      
        
    public static int denormalizeY(int y) {
        return ((-1*y % CELL_SIZE) + (CELL_SIZE / 2));
    }      
        
    public static Point normalizePoint(Point p) {
        return new Point(normalizeX(p.getX()), normalizeY(p.getY()));
    }
        
    public static Point denormalizePoint(Point p) {
        return new Point(denormalizeX(p.getX()), denormalizeY(p.getY()));
    }
}
