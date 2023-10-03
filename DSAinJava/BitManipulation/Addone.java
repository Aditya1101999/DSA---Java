package DSAinJava.BitManipulation;

public class Addone {
    public static int addOne(int num) {
        int mask = 1;
        while ((num & mask) != 0) {
            num ^= mask;
            mask <<= 1;
        }
        num ^= mask;
        return num;
    }
    public static void main(String args[]){
        int x=4;
        //~x=-(x+1)
        int added=-~x;
        System.out.println(added);
    }

}

