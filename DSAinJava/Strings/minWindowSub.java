package DSAinJava.Strings;

public class minWindowSub {
    public String minWindow(String s, String t) {
        int[] freq=new int[128];//input includes both upper and lower case letters
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        int start=0,end=0,minStart=0,minLen=Integer.MAX_VALUE,counter=t.length();
        while(end<s.length()){
            char c=s.charAt(end);
            if(freq[c]>0){//character present in t
                counter--;
            }
            freq[c]--;
            end++;
            while(counter==0){//it means all character of t are in window and it is a valid answer
                if(minLen>end-start){
                    minLen=end-start;
                    minStart=start;
                }
                char st=s.charAt(start);
                freq[st]++;
                if(freq[st]>0){
                    counter++;
                }
                start++;
            }

        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLen);
    }
    public int smallestSubstring(String s) {
        boolean zero=false,one=false,two=false;
        int zeroIndex=-1,oneIndex=-1,twoIndex=-1;
        int res=Integer.MAX_VALUE;
        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr=='0'){
                zeroIndex=i;
                zero=true;
            }
            else if(curr=='1'){
                oneIndex=i;
                one=true;
            }
            else{
                twoIndex=i;
                two=true;
            }
            if(zero && one && two){
                int diff=Math.max(zeroIndex,Math.max(oneIndex,twoIndex))-Math.min(zeroIndex,Math.min(oneIndex,twoIndex))
                        +1;
                res=Math.min(res,diff);
            }
        }
        return res==Integer.MAX_VALUE ? -1 : res;
    }
}
