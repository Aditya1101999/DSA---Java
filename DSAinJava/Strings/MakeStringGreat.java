package DSAinJava.Strings;

public class MakeStringGreat {
    public String makeGood(String s) {
        StringBuilder ans=new StringBuilder(); // or use a stack
        for(char c : s.toCharArray()){
            int len=ans.length();
            if(len>0 && Math.abs(ans.charAt(len-1)-c)==32){
                ans.deleteCharAt(len-1);//in c++ this is constant , here it takes o(n) time
            }
            else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
