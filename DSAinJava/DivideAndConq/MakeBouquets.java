package DSAinJava.DivideAndConq;

public class MakeBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length) return -1;//required flowers are more
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int day : bloomDay){
            min=Math.min(min,day);
            max=Math.max(max,day);
        }
        int low=min;
        int high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossibleMakeBouquets(bloomDay,mid,m,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean isPossibleMakeBouquets(int[] bloomDay,int day,int m,int k){
        int count=0;
        int bouquets=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){//can bloom
                count++;
            }
            else{
                bouquets+=count/k;
                count=0;
            }
        }
        //for last bouquet
        bouquets+=count/k;
        return bouquets>=m;

    }
}
