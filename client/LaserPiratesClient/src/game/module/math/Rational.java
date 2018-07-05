package game.module.math;

/**
 * The <code>Rational</code> class is a helper class to represent rational numbers.
 * It also provides mathematical utility
 * 
 * @author Marco
 */
public class Rational implements Comparable<Rational> {
    private static Rational zero = new Rational(0, 1);
    
    // numerator
    private int num;
    // denominator
    private int den;

    /**
     * 
     * @param num
     * @param den
     */
    public Rational(int num, int den) throws ArithmeticException {
        if (den == 0) {
            throw new ArithmeticException("denominator is zero");
        }
        
        // get greatest common divisor
        int gcd = calculateGreatestCommonDivisor(num, den);
        this.num = num / gcd;
        this.den = den / gcd;
    }
    
    /**
     * Calculates the greatest common divisor between two integers
     * @param m
     * @param n
     * @return 
     */
    public static int calculateGreatestCommonDivisor(int m, int n) {
        // normalise first
        if (m < 0) m = -m;
        if (n < 0) n = -n;
        
        // calculate recursively
        if (n == 0) { // end condition
            return m;
        }
        else {
            return calculateGreatestCommonDivisor(n, m % n);
        }
    }
    
    /**
     * 
     * @return return double precision representation of the rational number
     */
    
    public double toDouble() {
        return (double) num / den;
    }
    
    @Override
    public int compareTo(Rational b) {
        int result = 0;
        Rational a = this;
        
        int leftSide = a.num * b.den;
        int rightSide = a.den * b.num;
        
        if (leftSide > rightSide) result = 1;
        else if (leftSide < rightSide) result = -1;
        
        return result;
    }
    
    public Rational multiply(int factor) {
        return new Rational(num * factor, den);
    }

    public Rational reciprocal() { 
        return new Rational(den, num);  
    }
    
    /**
     * Checks if RationalA equals RationalB 
     * 
     * @param b Another Rational object
     * @return bool
     */
    @Override
    public boolean equals(Object b) {
        if ((b == null) ||
            (b.getClass() != this.getClass())) {
            return false;
        }
        
        Rational rationalB = (Rational) b;
        return compareTo(rationalB) == 0;
    }
    
    /**
     * @return getter of num
     */
    public int getNum() {
        return num;
    }

    /**
     * @return getter of den
     */
    public int getDen() {
        return den;
    }

    public String toString() {
        return num + " / " + den;
    }
}
