package Strings;
import java.util.*;
public class Lowervowel {
        public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            System.out.println("please enter string");
            String str=sc.next();
            int count=0;
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    count++;
                }
            }
            System.out.println("count of vowels is "+count);
    }
}
