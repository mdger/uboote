package game.level;

import game.gui.level.AbstractLevelRenderer;

/**
 *
 * @author Marco
 */
public class FunctionGeneratorConfig {

    private int maxValue = AbstractLevelRenderer.CELL_SIZE;
    private int maxIntercept = 0;
    private int ax = 0;
    private int ay = 0;
    private int bx = 0;
    private int by = 0;
    
    public FunctionGeneratorConfig() {
        maxValue = AbstractLevelRenderer.CELL_SIZE / 2;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int max) {
        this.maxValue = max;
    }

    public void setAx(int ax) {
        this.ax = ax;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public void setBx(int bx) {
        this.bx = bx;
    }

    public void setBy(int by) {
        this.by = by;
    }

    public int getAx() {
        return ax;
    }

    public int getAy() {
        return ay;
    }

    public int getBx() {
        return bx;
    }

    public int getBy() {
        return by;
    }

    public void setMaxIntercept(int maxIntercept) {
        this.maxIntercept = maxIntercept;
    }

    public int getMaxIntercept() {
        return maxIntercept;
    }
}
