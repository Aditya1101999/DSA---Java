package DSAinJava.Strings;

public class LargestGoodInteger {
    public String largestGoodInteger(String s) {
        String ans="";
        int curr=0;
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i-1)==s.charAt(i) && s.charAt(i)==s.charAt(i+1)){
                int temp=Character.getNumericValue(s.charAt(i));
                if(ans==""||temp>curr){
                    ans=s.substring(i-1,i+2);
                    curr=temp;
                }
            }
        }
        return ans;

    }
}
