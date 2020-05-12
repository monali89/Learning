package misc;

import java.math.BigInteger;

/**
 * @author Monali L on 4/22/2020
 */

public class NumberTheory {

    // TODO: Modular Exponentiation
    // Problem: Given three numbers x, y and p, compute (xy) % p.
    public int getModExpo(int x, int y, int p) {

        // loop y times and multiply x, then mod p, large o(n) - x*y
        // Recursive, call the power while breaking y to y/2 for each call depending on odd even x value
        // Property (Best): (ab) mod p = ((a mod p) * (b mod p)) mod p
        // Use modulo property with iterative solution
        int rslt = 1;

        while (y > 1) {
            if (y % 2 == 0) {
                x = (x * x) % p;
            } else {
                rslt = (rslt * x) % p;
            }
        }

        return rslt;
    }

    // TODO: Modular multiplicative inverse
    // TODO: Primality Test | Set 2 (Fermat Method)
    // TODO: Euler’s Totient Function
    // TODO: Sieve of Eratosthenes
    // TODO: Convex Hull
    // TODO: Basic and Extended Euclidean algorithms
    // TODO: Segmented Sieve
    // TODO: Chinese remainder theorem
    // TODO: Lucas Theorem
}
