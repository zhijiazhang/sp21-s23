package Arithmetic;

/** Simple Arithmetic Class.
 * @author Josh Hug
 * */
public class Arithmetic {

    /** Computes product of two ints.
     * @param a Value 1
     * @param b Value 2
     * @return Product of a and b
     * */
    public static int product(int a, int b) {
        return a * b;
    }

    /** Computes sum of two ints (incorrectly).
     * @param a Value 1
     * @param b Value 2
     * @return Sum of a and b
     * */
    public static int sum(int a, int b) {

        return a + b;
    }

    public static void main(String[] args) {

        int x = 5;

        int y = 6;

        System.out.println(Arithmetic.sum(x, y));

    }
}
