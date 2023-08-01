package DSAinJava.DivideAndConq;
import java.util.Arrays;
public class AggressiveCows {
    public static int solve(int n, int cows, int[] stalls) {
        Arrays.sort(stalls);//we need consecutive stall distances
        int low=1;//low can also be taken as min of all consecutive differences
        int high=stalls[n-1]-stalls[0];//max-min
        while(low<=high){
            int mid=low+(high-low)/2;
            if(placeCows(stalls,cows,mid)){
                low=mid+1;//look for maximum distance
            }
            else{
                high=mid-1;
            }
        }
        return high;//max valid distance
    }
    private static boolean placeCows(int[] stalls,int cows,int distance){
        int currentPlacedCows=1;
        int lastCowLocation=stalls[0];//first cow at first index
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastCowLocation>=distance){//place the cow
                currentPlacedCows++;
                lastCowLocation=stalls[i];
                if(currentPlacedCows==cows) return true;
            }
        }
        return false;
    }
}
