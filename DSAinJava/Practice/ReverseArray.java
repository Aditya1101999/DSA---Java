package DSAinJava.Practice;

public class ReverseArray {
    public static void reverse(int numbers[]) {
        int start=0,end= numbers.length-1;
        while(start<end){
            //swap
            int temp=numbers[end];
            numbers[end]=numbers[start];
            numbers[start]=temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        int[] numbers = {1,2,3,4,5};
        reverse(numbers);
        for(int el:numbers){
            System.out.print(el+" ");
        }
    }
}
