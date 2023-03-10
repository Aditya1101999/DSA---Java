package Strings;
public class Chandni {
    public static int checkOccurance(String str1,String str2){
        int index=-1;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)==str2.charAt(0) && i+str2.length()<=str1.length()){
                if(isSame(str1.substring(i,i+str2.length()),str2)){
                    index=i;
                    break;
                }
            }
        }
        return index;
    }
    private static boolean isSame(String str1,String str2){
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)&& str2.charAt(i)!='*'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String str1="juliasamanthantjulia";
        String str2="ant*ul";
        System.out.println(checkOccurance(str1,str2));
    }
}
