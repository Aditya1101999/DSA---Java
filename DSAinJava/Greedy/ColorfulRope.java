package DSAinJava.Greedy;

public class ColorfulRope {
    public int minCost(String colors, int[] neededTime) {
        int sum=0;
        int res=0;
        int max=0;
        for(int i=0;i<colors.length();i++){
            if(i>0 && colors.charAt(i)!=colors.charAt(i-1)){
                res+=(sum-max);
                sum=max=0;
            }
            sum+=neededTime[i];
            max=Math.max(max,neededTime[i]);
        }
        res+=(sum-max);//for last group
        return res;
    }
}
