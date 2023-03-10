package Greedy;
import java.util.*;
public class MaxBags {//O(n log n)->loop+sorting
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n=capacity.length;
        int[] vacancy=new int[n];
        for(int i=0;i<n;i++){
            vacancy[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(vacancy);
        int fullBagsCount=0;
        for(int i=0;i<n;i++){
            if(additionalRocks>=vacancy[i]){
                additionalRocks-=vacancy[i];
                fullBagsCount++;
            }
            else{
                break;
            }
        }
        return fullBagsCount;
    }
    public static void main(String[] args) {
        int[] capacity={2,3,4,5};
        int[] rocks={1,2,4,4};
        int additionalRocks=2;
        System.out.println(maximumBags(capacity,rocks,additionalRocks));
    }
}
