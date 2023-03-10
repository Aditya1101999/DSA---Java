package Greedy;
import java.util.*;
public class NMeetings {
    public static int maxMeetings(int start[], int end[], int n)
    {
        int[][] meets=new int[n][2];
        for(int i=0;i<n;i++){
            meets[i][0]=start[i];
            meets[i][1]=end[i];
        }
        Arrays.sort(meets,(a,b)->a[1]-b[1]);
        int lastEnd=meets[0][1];
        int meetings=1;
        for(int i=1;i<n;i++){
            if(meets[i][0]>lastEnd){
                meetings++;
                lastEnd=meets[i][1];
            }
        }
        return meetings;
    }

    public static void main(String[] args) {
        int N = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] =  {2,4,6,7,9,9};
        System.out.println(maxMeetings(start,end,N));
    }
}
