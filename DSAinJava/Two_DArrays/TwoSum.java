package DSAinJava.Two_DArrays;

public class TwoSum {
    int countPairs(int[][] mat1, int[][] mat2, int n, int x) {
        int r1=0;
        int c1=0;
        int r2=n-1;
        int c2=n-1;

        int count=0;
        while(r1<n && r2>=0){
            int value=mat1[r1][c1]+mat2[r2][c2];

            if(value==x){
                count++;
                c1++;
                c2--;
            }
            else if(value<x){
                c1++;
            }
            else{
                c2--;
            }
            if(c1==n){
                c1=0;
                r1++;
            }
            if(c2==-1){
                c2=n-1;
                r2--;
            }
        }
        return count;
    }
}
