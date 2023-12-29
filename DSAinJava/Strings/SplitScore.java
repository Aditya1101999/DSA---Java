package DSAinJava.Strings;

public class SplitScore {
    public int maxScore(String s) {
        int n=s.length();
        int leftOnes=0;
        int leftZeros=0;
        int max=Integer.MIN_VALUE;
        //we can't partition the last character
        for(int i=0;i<n-1;i++){
            //score=leftzeros+rightones , rightones=totalones-leftones
            //=>score=leftzeros+totalones-leftones
            char ch=s.charAt(i);
            if(ch=='1') leftOnes++;
            else leftZeros++;

            max=Math.max(max,leftZeros-leftOnes);
        }
        if(s.charAt(n-1)=='1') leftOnes++;
        return max+leftOnes;//leftzeros-leftones+totalOnes
    }
}
