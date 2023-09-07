package DSAinJava.Strings;

public class rotate {
    private static boolean checkRotated(String str1,String str2){
        if(str1.length()!=str2.length()) return false;
        int j=-1;
        for(int i=0;i<str2.length();i++){
            if(str2.charAt(i)==str1.charAt(1)){
                j=i;
                break;
            }
        }
        //if k is given , i.e. how many times String is rotated
        //then instead of finding first character like this , check s.charAt(k) and s.charAt(n-k)
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(j)) return false;
            j=(j+1)%str1.length();
        }
        return true;
    }
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "cdefba";
        System.out.println(checkRotated(str1,str2));
    }
}
