package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimes() {

        IntList primes = IntList.of(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        IntList composites = IntList.of(4, 6, 9, 10, 12);

        //test primes
        boolean primesChange = IntListExercises.squarePrimes(primes);
        assertEquals("4 -> 9 -> 25 -> 49 -> 121 -> 169 -> 289 -> 361 -> 529 -> 841 -> 961", primes.toString());
        assertTrue(primesChange);

        boolean compositeChange = IntListExercises.squarePrimes(composites);
        assertEquals("4 -> 6 -> 9 -> 10 -> 12", composites.toString());
        assertFalse(compositeChange);
   

    }
}
