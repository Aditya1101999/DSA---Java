package DSAinJava.Hashing;
import java.util.*;
public class CinemaBooking {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Integer>map=new HashMap<>();//row,reserved bit vector
        for(int[] seats : reservedSeats){
            int row=seats[0];
            int col=seats[1];
            map.put(row,map.getOrDefault(row,0)|(1<<col));
        }
        int ans=0;
        for (int row : map.values()) {
            int currCount = 0;
            // seats 2 3 4 5 are empty
            if ((row & ((1 << 2) | (1 << 3) | (1 << 4) | (1 << 5))) == 0) currCount++;
            // seats 6 7 8 9 are empty
            if ((row & ((1 << 6) | (1 << 7) | (1 << 8) | (1 << 9))) == 0) currCount++;
            // none of the above conditions met, but 4 5 6 7 are empty
            if (currCount == 0 && (row & ((1 << 4) | (1 << 5) | (1 << 6) | (1 << 7))) == 0) currCount++;
            ans += currCount;
        }

        //places where no seats are reserved
        return ans+2*(n-map.size());
    }
}
