package DSAinJava.arrays;

public class BookOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int left=0;
        int alreadySatisfied=0;
        int unsatisfied=0;
        int right;
        for(right=0;right<minutes;right++){
            if(grumpy[right]==1) unsatisfied+=customers[right];
            else alreadySatisfied+=customers[right];
        }
        int max=unsatisfied;
        while(right<customers.length){
            if(grumpy[right]==1) unsatisfied+=customers[right];
            else alreadySatisfied+=customers[right];
            if(grumpy[left]==1) unsatisfied-=customers[left];
            max=Math.max(max,unsatisfied);
            left++;
            right++;
        }
        return max+alreadySatisfied;
    }
}
