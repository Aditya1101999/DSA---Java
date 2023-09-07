package DSAinJava.Strings;
import java.util.*;
public class Binary {
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
