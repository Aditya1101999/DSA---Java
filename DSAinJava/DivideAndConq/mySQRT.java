package DSAinJava.DivideAndConq;

public class mySQRT {
    public int mySqrt(int x) {
        long low=1;
        long high=x;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(mid*mid<=x){//possible ans
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return (int)high;
    }
    public int NthRoot(int n, int m) {
        int low=1;
        int high=m;
        while(low<=high){
            int mid=low+(high-low)/2;
            //or manually , run a loop from 1 to n , currPow*=mid;
            int currPow=(int)Math.pow(mid,n);
            if(currPow==m) return mid;
            else if(currPow<m) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}
