package BitManipulation;
public class Oddeven {
    public static void oddOrEven(int n){
        int bitMask=1;
        if((n&bitMask)==0){
            System.out.println("no. is even");
        }
        else{
            System.out.println("no. is odd");
        }
    }
    public static void main(String args[]){
        oddOrEven(3);
        oddOrEven(14);

    }

}
