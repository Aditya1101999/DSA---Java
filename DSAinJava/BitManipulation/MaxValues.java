package BitManipulation;

public class MaxValues {
    public static int MaxAndValue(int[] arr){
        int n= arr.length;
        int ans=0;
        for(int i=31;i>=0;i--){
            int x=ans|(1<<i);//setting ith bit in ans and assigning it to x
            int count=0;
            for(int j=0;j<n;j++){
                if((x&arr[j])==x){//counting set bits;if bit is not set it will give 0
                    count++;
                }
            }
            if(count>=2) ans=x;
        }
        return ans;
    }
    public static int MaxOrValue(int[] arr){
        int max=Integer.MIN_VALUE;
        for(int el:arr){
            max=Math.max(max,el);
        }
        int ans=0;
        for(int el:arr){
            ans=Math.max(ans,(max|el));//taking or with each element in array with max
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = { 4, 8, 12, 16};
        System.out.println(MaxAndValue(arr));
        System.out.println(MaxOrValue(arr));

    }
}
