package BitManipulation;

public class Modularexp {
    public static int modExp(int a,int n,int p){
        int ans = 1;
        while (n > 0) {
            if ((n & 1) != 0) {//check LSB
                ans *= a;

            }
            a = a * a;
            n = n >> 1;

        }
        int ans1=ans%p;
        return ans1;
    }
    public static void main(String args[]){

        System.out.println(modExp(2,3,5));
    }
}



