package DSAinJava.arrays;

public class ReachNumber {
    public int reachNumber(int target) {
        target=Math.abs(target);
        int steps=0;
        int sum=0;
        while(sum<target || (sum-target)%2!=0){//since sum-2*k==target=>sum-target=2*k
            steps++;
            sum+=steps;
        }
        return steps;
    }
}
