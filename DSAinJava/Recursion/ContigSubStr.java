package Recursion;

public class ContigSubStr {
    public static int countContSubStr(String str,int i,int j,int n){
        //i will be first index and j is last index, n is string length
        //base condition
        if(n==0||n==1){//or n<=0 then return 0;
            return n;
        }
        //Here , AUB=A+B-A intersect B
        int res=//AUB
                countContSubStr(str, i+1, j, n-1)+//A
                countContSubStr(str, i, j-1, n-1)-//B
                countContSubStr(str, i+1, j-1, n-2);// A intersect B
        //first and last characters are same
        if(str.charAt(i)==str.charAt(j)){
            res++;
        }
        return res;
    }
    public static void main(String args[]){
        String str="abcab";
        int n=str.length();
        System.out.println(countContSubStr(str,0,n-1,n));
    }
}
