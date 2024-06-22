package DSAinJava.Strings;

public class EncryptedInt {
    public int sumOfEncryptedInt(int[] nums) {
        int sum=0;
        for(int el : nums){
            sum+=encrypt(el);
        }
        return sum;
    }
    private int encrypt(int num){
        String s=Integer.toString(num);
        int size=s.length();
        char max='1';
        for(char c : s.toCharArray()){
            if(c>max){
                max=c;
            }
        }
        StringBuilder ans=new StringBuilder();
        while(size-->0){
            ans.append(max);
        }
        return Integer.parseInt(ans.toString());
    }
}
