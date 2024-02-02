package DSAinJava.Strings;

public class LongestString {
    public int longestString(int x, int y, int z) {
        int innerAABB=Math.min(x,y);
        int maxAABB=Math.max(x,y);
        int outerAABB=Math.min(innerAABB+1,maxAABB);
        return 2*(innerAABB+outerAABB+z);

    }
}
