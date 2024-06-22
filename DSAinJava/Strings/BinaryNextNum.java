package DSAinJava.Strings;

public class BinaryNextNum {
    String binaryNextNumber(String s) {
        StringBuilder ans=new StringBuilder();
        char[] stringArr=s.toCharArray();
        int n=stringArr.length;
        int i;
        for(i=n-1;i>=0;i--){
            if(stringArr[i]=='1') stringArr[i]='0';
            else{
                stringArr[i]='1';
                break;
            }
        }
        //there can be trailing zeros in input , e.g. 0011111100
        boolean trailingZeros=true;
        if(i<0){//no 0 found
            ans.append('1');
            trailingZeros=false;
        }
        for(i=0;i<n;i++){
            if(stringArr[i]=='1') trailingZeros=false;
            if(trailingZeros) continue;
            ans.append(stringArr[i]);
        }
        return ans.toString();
    }
}
