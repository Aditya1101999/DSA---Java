package Strings;

public class GCDStrings {
    public static String gcdOfStrings(String str1, String str2) {
        if((str1+str2).equals(str2+str1)){//gcd exists
            int gcd=GCD(str1.length(),str2.length());
            return str2.substring(0,gcd);
        }
        return "";
    }
    private static int GCD(int a,int b){//Euclidean algo
        if(b==0){
            return a;
        }
        return GCD(b,a%b);
    }
    public static void main(String[] args){
        String str1 = "ABCABC", str2 = "ABC";
        System.out.println(gcdOfStrings(str1,str2));
    }
}
