/** Class that prints the Collatz sequence starting from a given number.
 *  @author zhijiazhang
 */
public class Collatz {

    /** collatz sequence
     * if n is 1 , return 1 (which will stop the loop)
     * if n is even, return n/2
     * if n is odd, return n*3 + 1
     *  */
    public static int nextNumber(int n) {

        if (n == 1) {
             return 1;
        }
        if (n % 2 == 0) {
            return n / 2;
        }
        else {
            return 3 * n + 1;
        }


    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}

