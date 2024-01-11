package DSAinJava.Backtracking;

public class ProductPalindromicSubseq {
    public int maxProduct(String s) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        int[] result=new int[1];
        dfs(s,0,s1,s2,result);
        return result[0];
    }
    private void dfs(String s ,int i,StringBuilder s1,StringBuilder s2,int[] result){
        if(i==s.length()){
            if(isPalin(s1.toString()) && isPalin(s2.toString())){
                result[0]=Math.max(result[0],s1.length()*s2.length());
            }
            return;
        }
        char curr=s.charAt(i);
        //pick at 1st str
        s1.append(curr);
        dfs(s,i+1,s1,s2,result);
        s1.deleteCharAt(s1.length()-1);
        //pick at 2nd str
        s2.append(curr);
        dfs(s,i+1,s1,s2,result);
        s2.deleteCharAt(s2.length()-1);
        //not pick
        dfs(s,i+1,s1,s2,result);
    }
    private boolean isPalin(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
