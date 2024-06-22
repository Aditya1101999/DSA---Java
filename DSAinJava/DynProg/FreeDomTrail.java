package DSAinJava.DynProg;

public class FreeDomTrail {
    public int findRotateSteps(String ring, String key) {
        int[][] dp=new int[ring.length()][key.length()+1];
        return solve(ring,key,0,0,dp);
    }
    private int solve(String ring,String key, int ringIndex, int keyIndex, int[][] dp){
        if(keyIndex==key.length()){
            return 0;
        }
        if(dp[ringIndex][keyIndex]!=0) return dp[ringIndex][keyIndex];

        int minSteps=Integer.MAX_VALUE;
        for(int i=0;i<ring.length();i++){
            if(ring.charAt(i)==key.charAt(keyIndex)){
                int steps=getSteps(i,ringIndex,ring.length()) + 1 + solve(ring,key,i,keyIndex+1,dp);
                minSteps=Math.min(minSteps,steps);
            }
        }
        return dp[ringIndex][keyIndex]=minSteps;
    }
    private int getSteps(int index,int ringIndex , int ringLength){
        int rotate=Math.abs(ringIndex-index);
        int antiRotate=ringLength-rotate;
        return Math.min(rotate,antiRotate);
    }
}
