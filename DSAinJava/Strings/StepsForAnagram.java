package DSAinJava.Strings;

public class StepsForAnagram {
    public int minSteps(String s, String t) {//replace
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        int ans=0;
        for(int el : freq){
            ans+=Math.max(0,el);
        }
        return ans;
    }
    public int minStepsII(String s, String t) {//append
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)-'a']--;
        }
        int ans=0;
        for(int el : freq){
            ans+=Math.abs(el);
        }
        return ans;
    }
}
