package Arithmetic;

import static org.junit.Assert.*;
import org.junit.Test;

public class ArithmeticTest {

    //unit tests follow this format
    //tests must bve non-static

    /*
    @Test
    public void testMethodName() {

        //tests
    }
    */

    /** Performs a few arbitrary tests to see if the product method is
     * correct */
    @Test
    public void testProduct() {
        /* assertEquals for comparison of ints takes two arguments:
        assertEquals(expected, actual).
        if it is false, then the assertion will be false,
        and this test will fail.
        */

        assertEquals(30, Arithmetic.product(5, 6));
        assertEquals(-30, Arithmetic.product(5, -6));
        assertEquals(0, Arithmetic.product(0, -6));
    }

    /** Performs a few arbitrary tests to see if the sum method is correct */
    @Test
    public void testSum() {

        assertEquals(11, Arithmetic.sum(5, 6));
        assertEquals(-1, Arithmetic.sum(5, -6));
        assertEquals(-6, Arithmetic.sum(0, -6));
        assertEquals(0, Arithmetic.sum(6, -6));
    }
}
