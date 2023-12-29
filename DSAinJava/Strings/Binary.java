package DSAinJava.Strings;
import java.util.*;
public class Binary {
    public int minOperations(String s) {
        int n=s.length();
        int startWithZero=0;//0101...
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(i%2==0){
                if(ch=='1') startWithZero++;
            }
            else{
                if(ch=='0') startWithZero++;
            }
        }
        int startWithOne=n-startWithZero;//exact opposite
        return Math.min(startWithZero,startWithOne);
    }
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            String binary=Integer.toString(n);
            int number=0;
            for(int i=0;i<binary.length();i++){
                if(binary.charAt(i)=='1'){
                    int pow=binary.length()-i-1;
                    number+=Math.pow(2,pow);
                }
            }
            System.out.println(number);
        }
    }
}
