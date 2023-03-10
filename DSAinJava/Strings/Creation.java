package Strings;
import java.util.*;
public class Creation {
    public static void print_letters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
       /* char arr[]={'a','b','c','d'};
        String str="abcd";
        String str2=new String("xyz");
        //Strings are immutable
        Scanner sc=new Scanner(System.in);
        String name= sc.nextLine();
        System.out.println(name);
        String fullName="acp pradyuman";
        System.out.println(fullName.length());*/

        //concatenation
        String firstName="ACP";
        String lastName="Pradyuman";
        String FullName=firstName+" "+lastName;
        System.out.println(FullName);
        //charAt prints the character at respective index
        System.out.println(FullName.charAt(1));
        print_letters(FullName);

    }
}
