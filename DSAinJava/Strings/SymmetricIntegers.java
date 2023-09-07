package DSAinJava.Strings;

public class SymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low;i<=high;i++){
            if(isValid(i)) ans++;
        }
        return ans;
    }
    private boolean isValid(int num){
        String str=Integer.toString(num);
        int n=str.length();
        if(n%2!=0) return false;
        int sum1=0;
        int sum2=0;
        for(int i=0;i<n/2;i++){
            sum1+=(str.charAt(i)-'0');
        }
        for(int i=n/2;i<n;i++){
            sum2+=(str.charAt(i)-'0');
        }
        return sum1==sum2;
    }
}
