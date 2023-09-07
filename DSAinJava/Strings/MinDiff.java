package DSAinJava.Strings;

public class MinDiff {
    private static int getMin(String[] words, String str1, String str2) {
        int ans=Integer.MAX_VALUE;
        int s1=-1;
        int s2=-1;
        for(int i=0;i< words.length;i++){
            if(words[i]==str1) s1=i;
            else if(words[i]==str2) s2=i;
            if(s1!=-1 && s2!=-1){
                ans=Math.min(ans,Math.abs(s1-s2));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[] words={"a","b","c","f","d","e","a","d"};
        String str1="a";
        String str2="d";
        int minDiff=getMin(words,str1,str2);
        System.out.println(minDiff);
    }


}
