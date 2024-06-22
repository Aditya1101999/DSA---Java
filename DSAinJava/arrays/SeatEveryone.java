package DSAinJava.arrays;
import java.util.*;
public class SeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        int n=students.length;
        int ans=0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for(int i=0;i<n;i++){
            ans+=Math.abs(seats[i]-students[i]);
        }
        return ans;
    }
}
