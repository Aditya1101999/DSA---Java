package Recursion;

public class FriendsTiling {
    public static int friendsPairingProblem(int n){
        //base case
        if(n==2||n==1){
            return n;
        }
        int single=friendsPairingProblem(n-1);
        //no. of ways
        int doubles=(n-1)*friendsPairingProblem(n-2);
        return single+doubles;
    }

    public static void main(String args[]){
        System.out.println("no.of ways are "+friendsPairingProblem(3));



    }


}
