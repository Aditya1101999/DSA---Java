package BitManipulation;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];//gives the element which is not found...same elements will turn 0
        }

        return xor ^ i;//last element
    }
    public int[] repeatedNumber(final int[] A) {
        int xor= A[0];
        int x=0;
        int y=0;
        for(int i=1;i<A.length;i++){
            xor^=A[i];//Xor with all elements
        }
        for(int i=1;i<=A.length;i++){
            xor^=i;//xor with indices
        }
        int setBit=xor& -xor;//rightmost setBit
        for(int i=0;i<A.length;i++){
            if((A[i]&setBit)!=0){
                x^=A[i];
            }
            else{
                y^=A[i];
            }
        }
        for(int i=1;i<=A.length;i++){
            if((i&setBit)!=0){
                x^=i;
            }
            else{
                y^=i;
            }
        }
        int count=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==x) count++;
        }
        int[] ans=new int[2];
        if(count==2){
            ans[0]=x;
            ans[1]=y;
        }
        else{
            ans[0]=y;
            ans[1]=x;
        }
        return ans;

    }
    public static void main(String[] args){
        int[] arr={0,3,4,1};
        System.out.println(missingNumber(arr));
    }
}
