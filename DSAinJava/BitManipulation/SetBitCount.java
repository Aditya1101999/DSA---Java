package BitManipulation;

public class SetBitCount {
    public static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    public static int setBitCountInRangeN(int n){
        if(n==0) return 0;
        int i=largestPower(n);
        int bitsTillLargestPow=(1<<(i-1))*i;//(2^i-1)*i
        int MSBCount=n-(1<<i)+1;
        int leftBits=n-(1<<i);
        return bitsTillLargestPow+MSBCount+setBitCountInRangeN(leftBits);
    }
    private static  int largestPower(int n){
        int i=0;
        while((1<<i)<=n){//increasing power of 2^i
            i++;
        }
        return i-1;
    }
    public static void main(String[] args){
        System.out.println(countSetBits(11111101));
        System.out.println(setBitCountInRangeN(11));
    }

}
