package BitManipulation;

public class SwapNum {
    public static void swap_numbers(int a,int b){
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println(a);
        System.out.println(b);

    }
    public static void main(String args[]){
        swap_numbers(4,3);
    }
}
