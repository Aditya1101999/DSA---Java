package DSAinJava.arrays;

public class LastMomentAnts {
    public int getLastMoment(int n, int[] left, int[] right) {
        int max=0;
        for(int ant : left){
            max=Math.max(max,ant);
        }
        for(int ant : right){
            max=Math.max(max,n-ant);
        }
        return max;
    }
}
