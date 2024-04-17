package DSAinJava.arrays;

public class PivotInt {
    public int pivotInteger(int n) {
        /*
        given , 1+2+.....x=x+....n
        add (1+2+....x) both sides
        => 2*(1+2+...x) = 1+2+....x+x+...n
        => 2 * x*(x+1)/2 = n(n+1)/2 + x
        => x*(x+1) - x  = n(n+1)/2
        => x^2 +x - x = sum(n)
        => x = √sum(n) [we are only concerned about +ve values]
        */
        int sum = n*(n+1)/2;
        int x = (int) Math.sqrt(sum);
        return x*x == sum ? x : -1; // pivot "Integer"
    }
}
