package game.level;

import game.module.geometry.shape.LinearFunction;
import game.module.geometry.shape.Point;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Helper Class for generating linear functions randomly. For example:<br>
 * <code>LinearFunction linearFunction = LinearFunctionGenerator.generateLinearFunction(40);</code><br>
 * generates a valid linear function ranging from -20 to 20 in the x and y axis.<br>
 * The method call <br>
 * <code>LinearFunction linearFunction = LinearFunctionGenerator.generateLinearFunction(20);</code><br>
 * generates a valid linear function ranging from -10 to 10 in the x and y axis.
 * @author Marco
 */
public class LinearFunctionGenerator {
    
    /**
     * <code>generateLinearFunction</code> generates linear functions randomly.
     * @param config Configurator for the function
     * @return 
     */
    public static LinearFunction generateLinearFunction(FunctionGeneratorConfig config) {
        LinearFunction linearFunction;

        linearFunction = generate(config);

        while (!isValidSlope(linearFunction, config.getMaxIntercept())) {
            linearFunction = generate(config);
        }
            
        return linearFunction;
    }
        

    /**
     * Checks whether the given two points have a valid slope. If not, return false
     * @param linearFunction
     * @param settingMaxIntercept
     * @return 
     */
    
    private static boolean isValidSlope(LinearFunction linearFunction, int settingMaxIntercept) {
        boolean isValid = true;
        
        try {
            linearFunction.getSlope();
            // Also check if intecept is an integer
            if (isValid) {
                double intercept = linearFunction.getRawIntercept();
                isValid = (intercept == (int)intercept);
            }
            
            // is intercept lower than the max setting
            if (isValid) {
                isValid = isValidIntercept(linearFunction.getIntercept(), settingMaxIntercept);
            }
        } catch (ArithmeticException e) {
            isValid = false;
        } 
        
        return isValid;
    }
    
    /**
     * Checks whether the linear function´s intercept is absolutely lower than the max intercept setting provided by the config
     * @param currentIntercept
     * @param configMaxIntercept
     * @return 
     */
    
    private static boolean isValidIntercept(int currentIntercept, int configMaxIntercept) {
        boolean isValidIntercept = true;
        
        if (configMaxIntercept != 0)
            isValidIntercept = Math.abs(currentIntercept) <= Math.abs(configMaxIntercept);
        
        return isValidIntercept;
    }
    
    /**
     * 
     * @param min
     * @param max
     * @return random number
     */
    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
    
    /**
     * point a is always below the x axis and point b alway above the x axis
     * @param config
     * @return 
     */
    
    private static LinearFunction generate(FunctionGeneratorConfig config) {
        // Divide by 2 because coordinate space has a negative and postive area (40 -> -20, 20)
        // so for a space size of 40, the max value is -20 and 20
        int  max = config.getMaxValue();
        
        int ax = config.getAx();
        int ay = config.getAy();
        int bx = config.getBx();
        int by = config.getBy();
        
        if (ax == 0)
            ax = getRandomNumber(0-max, max);
        if (ay == 0)
            ay = getRandomNumber(0-max, -1);
        if (bx == 0)
            bx = getRandomNumber(0-max, max);
        if (by == 0)
            by = getRandomNumber(1, max);
        
        if (ax == bx && ay == by) 
            by -= 1;
        
        Point a = new Point(ax, ay);
        Point b = new Point(bx, by);
        
        return new LinearFunction(a, b);        
    }
}
