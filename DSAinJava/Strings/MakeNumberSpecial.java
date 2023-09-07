package DSAinJava.Strings;

public class MakeNumberSpecial {
    public int minimumOperations(String num) {
        int ans=num.length();
        int n=num.length();
        int zero=0;
        for(int i=0;i<n;i++){
            if(num.charAt(i)=='0') zero++;
        }
        ans=Math.min(ans,n-zero);
        ans=Math.min(ans,check(num,0,0));
        ans=Math.min(ans,check(num,2,5));
        ans=Math.min(ans,check(num,5,0));
        ans=Math.min(ans,check(num,7,5));
        return ans;
    }
    private int check(String num,int digit1,int digit2){
        int n=num.length();
        boolean digit2Found=false;
        int deletions=0;
        for(int i=n-1;i>=0;i--){
            int curr=num.charAt(i)-'0';
            if(curr==digit2 && !digit2Found){
                digit2Found=true;
            }
            else if(digit2Found && curr==digit1){
                return deletions;
            }
            else{
                deletions++;
            }
        }
        return digit2Found ? deletions+1 : deletions;
    }
}
