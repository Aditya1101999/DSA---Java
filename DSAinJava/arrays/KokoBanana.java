package DSAinJava.arrays;

public class KokoBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        long low=1;
        long high=piles[0];
        for(int pile : piles){
            high=Math.max(high,pile);
        }
        while(low<=high){
            long mid=low+(high-low)/2;
            if(validDivisionPossible(piles,h,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return (int)low;
    }
    private static boolean validDivisionPossible(int[] piles,long h,long mid){
        long count=0;
        for(int pile : piles){
            count+=pile/mid;
            if(pile%mid!=0){
                count++;//one more hour to finish the rest bananas in the pile
            }
        }
        return (count<=h);
    }
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(piles,h));
    }
}
