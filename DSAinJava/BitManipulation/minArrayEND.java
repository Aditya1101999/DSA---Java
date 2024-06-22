package DSAinJava.BitManipulation;

public class minArrayEND {
    public long minEnd(int n, int x) {
        long initialNum = x;
        n--;
        while(n-->0){
            initialNum=(initialNum+1)|x;
        }
        return initialNum;
    }
}
