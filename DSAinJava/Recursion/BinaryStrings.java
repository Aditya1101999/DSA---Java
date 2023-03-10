package Recursion;

public class BinaryStrings {
    public static void printBinaryString(int n,int last,String str){
        //base condition
        if(n==0){
            System.out.println(str);
            return;
        }
        printBinaryString(n-1,0,str+"0");
        if(last==0){
            printBinaryString(n-1,1,str+"1");
        }
    }
    public static void main(String args[]){
        printBinaryString(3,0,"");
    }
}
