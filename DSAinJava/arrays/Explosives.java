package DSAinJava.arrays;

public class Explosives {
    static int maxBoxes(int n, int K, int C, int col[]) {
        int ans=0;
        int curr=0;
        for(int i=0;i<n-1;i++){
            if(col[i]==col[i+1] && col[i]==C){
                curr=2;//explode 2 boxes
                int left=i-1;
                int right=i+2;
                while(left>=0 && right<n && col[left]==col[right]){
                    int count=2;
                    left--;
                    right++;

                    if(left>=0 && col[left]==col[left+1]){
                        count++;
                        left--;
                    }
                    if(right<n && col[right]==col[right-1]){
                        count++;
                        right++;
                    }
                    if(count>=3){
                        curr+=count;
                    }
                    else break;
                }
                ans=Math.max(ans,curr);

            }
        }
        return ans;
    }
}
