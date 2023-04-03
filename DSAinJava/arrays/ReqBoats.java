package DSAinJava.arrays;
import java.util.Arrays;
public class ReqBoats {
    public int numRescueBoats(int[] people, int limit) {
        int count=0;
        Arrays.sort(people);//1 heavy and 1 light-weighted person at a time
        //two-pointer
        int i=0;
        int j=people.length-1;
        while(i<=j){
            if(people[i]+people[j]<=limit){//2 persons in the boat
                count++;
                i++;
                j--;
            }
            else{//weight exceeded limit , so only one person can go
                count++;
                j--;
            }
        }
        return count;
    }
}
