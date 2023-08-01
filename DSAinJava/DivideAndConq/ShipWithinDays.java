package DSAinJava.DivideAndConq;

public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int max=0;
        int sum=0;
        for(int weight : weights){
            max=Math.max(max,weight);
            sum+=weight;
        }
        int low=max;
        int high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossibleShipping(weights,mid,days)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean isPossibleShipping(int[] weights,int capacity,int days){
        int currWeight=0;
        int currDays=1;
        for(int weight : weights){
            if(currWeight+weight>capacity){
                currDays++;
                currWeight=weight;//reseted current weight
            }
            else{
                currWeight+=weight;
            }
        }
        return currDays<=days;
    }
}
