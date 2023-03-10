package Two_DArrays;

public class RowMax1s {
    private static int rowWithMax1s(int arr[][], int n, int m) {
        int row=-1;
        int col=m-1;
        for(int i=0;i<n;i++){//traversing rows
            for(int j=col;j>=0;j--){//traversing columns in opposite direction
                if(arr[i][j]==1){
                    row=i;
                    col--;
                }
                else{//if we find 0 then move to next row
                    break;
                }
            }
        }
        return row;
    }

    public static void main(String[] args) {
        int N = 4 , M = 4;
        int Arr[][] = {{0, 1, 1, 1},
            {0, 0, 1, 1},
            {1, 1, 1, 1},
            {0, 0, 0, 0}};
        System.out.println(rowWithMax1s(Arr,N,M));
    }
}
