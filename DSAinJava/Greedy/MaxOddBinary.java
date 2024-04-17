package DSAinJava.Greedy;

public class MaxOddBinary {
    public String maximumOddBinaryNumber(String s) {
        char[] arr=s.toCharArray();
        int n=s.length();
        int left=0;
        int right=n-1;
        while(left<=right){
            if(arr[left]=='1'){
                left++;
            }
            if(arr[right]=='0'){
                right--;
            }
            if(left<=right && arr[left]=='0' && arr[right]=='1'){//swap
                arr[left]='1';
                arr[right]='0';
            }
        }
        arr[left-1]='0';
        arr[n-1]='1';//make string odd
        return new String(arr);
    }
}
