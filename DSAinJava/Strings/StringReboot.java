package DSAinJava.Strings;

public class StringReboot {
    public static boolean AreEqual(String a, String b) {
        int n=a.length();
        for(int i=1;i<n;i++){
            if(a.charAt(i-1)=='0' && b.charAt(i-1)=='0' && a.charAt(i)=='1' && b.charAt(i)=='1'){
                return true;
            }
        }
        return false;
    }
}
