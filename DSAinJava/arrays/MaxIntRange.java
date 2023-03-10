package arrays;
import java.util.*;
public class MaxIntRange {
    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer>set=new HashSet<>();
        for(int num:banned){
            set.add(num);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i))
                continue;
            if (i <= maxSum) {
                count++;
                maxSum -= i;
            } else {
                break;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] banned ={1,6,5};
        int n = 5;
        int maxSum = 6;
        System.out.println(maxCount(banned,n,maxSum));
    }
}
