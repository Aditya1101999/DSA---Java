package BitManipulation;
public class Operations {
    public static int getIthBit(int n, int i){
        int bitmask=1<<i;
        if((n&bitmask)==0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int setIthBit(int n, int i){
        int bitmask=1<<i;
        return n|bitmask;
    }
    public static int clearIthBit(int n, int i){
        int bitmask=~(1<<i);
        return n&bitmask;
    }//new bit=1/0
    public static void updateIthBit(int n, int i,int newBit) {
        if(newBit==1){
            System.out.println(setIthBit(n,i));
        }
        else if(newBit==0){
            System.out.println(clearIthBit(n,i));
        }
        else{
            System.out.println("invalid input!");
        }
        /*approach 2
        n=clearIthBit(n,i);
        int BitMask=newBit<<i;
        return n|BitMask;*/
    }
    public static int clearIthBits(int n, int i) {
        int bitmask = ~0 << i;
        return n & bitmask;
    }
    public static int flipBits(int n){//0 become 1 and 1 become 0
        return n^n;
    }
    public static int clearRangeIthBits(int n, int i, int j) {
        int a=~0<<(j+1);
        int b=(1<<i)-1;
        int bitmask = a|b;
        return n & bitmask;
    }
    public static void main(String args[]){
        System.out.println(getIthBit(10,2));
        System.out.println(setIthBit(10,2));
        updateIthBit(10,2,1);
        System.out.println("clear"+clearIthBit(10,1));
        System.out.println(clearIthBits(10,2));
        System.out.println(clearRangeIthBits(10,2,4));
    }
}
