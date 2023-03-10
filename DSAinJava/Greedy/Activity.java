package Greedy;
import java.util.*;
public class Activity {
    public static void main(String[] args){//o(n)+log(n)
        int[] start={1,3,0,5,8,5};
        int[] end={2,4,6,7,9,9};
        //sorting,log n complexity
        int[][] activities=new int[start.length][3];
        for(int i=0;i< start.length;i++){
            activities[i][0]=i;//index
            activities[i][1]=start[i];//start
            activities[i][2]=end[i];//end
        }
        //lambda function,sorting on basis of column 2 i.e. end
        Arrays.sort(activities,Comparator.comparingDouble(o->o[2]));

        //end time basis sorted
        int maxAct=0;
        //arraylist to store indices of activities
        ArrayList<Integer>ans=new ArrayList<>();

        //1st activity
        maxAct=1;
        ans.add(activities[0][0]);
        int lastEnd=activities[0][2];//end[0]
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>=lastEnd){//start[i]
                //activity select
                maxAct++;
                ans.add(activities[i][0]);//index
                lastEnd=activities[i][2];//end[i];
            }
        }
        System.out.println("max activities "+maxAct);
        for(int i=0;i<ans.size();i++){
            System.out.print("A"+ans.get(i)+" ");
        }
        System.out.println();
    }
}
