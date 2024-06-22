package DSAinJava.arrays;

public class maxK {
    public int findMaxK(int[] nums) {
        boolean[] visited=new boolean[2001];
        int max=-1;
        for (int num : nums) {
            if (visited[-num + 1000]) {
                max = Math.max(max, Math.abs(num));
            }
            visited[num + 1000] = true;
        }
        return max;
    }
}
