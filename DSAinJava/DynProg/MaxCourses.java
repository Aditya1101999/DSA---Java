package DSAinJava.DynProg;
import java.util.*;
public class MaxCourses {
    public int max_courses(int n, int total, int[] cost) {
        int[][] dp=new int[total+1][cost.length];
        for(int i=0;i<total+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxCoursesHelper(total,cost,0,dp);
    }
    private int maxCoursesHelper(int total,int[] cost,int index,int[][] dp){
        if(index==cost.length){
            return 0;
        }
        if(dp[total][index]!=-1){
            return dp[total][index];
        }
        int include=0;
        if(cost[index]<=total){
            int price=total-cost[index]+(9*cost[index]/10);
            include=1+maxCoursesHelper(price,cost,index+1,dp);
        }
        int exclude=maxCoursesHelper(total,cost,index+1,dp);
        return dp[total][index]=Math.max(include,exclude);
    }
}
