package DSAinJava.Strings;

public class MinStringBudget {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int left=0;
        int right=0;
        int ans=0;
        int cost=0;
        while(right<n){
            cost+=Math.abs(s.charAt(right)-t.charAt(right));
            if(cost>maxCost){
                cost-=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            ans=Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}
