package DSAinJava.arrays;

public class FlowerGame {
    public long flowerGame(int n, int m) {
        // We want Alice to win, so we need all the odd pairs.
        // All the odd pairs would be the pair of odd and even numbers.

        // Calculate the count of odd numbers in the range [1, n] and [1, m]
        long oddsN = (n + 1) / 2;
        long oddsM = (m + 1) / 2;

        // Calculate the count of even numbers in the range [1, n] and [1, m]
        long evenN = n / 2;
        long evenM = m / 2;

        // Return the total count of pairs where Alice wins
        return oddsN * evenM + oddsM * evenN;
    }
}
