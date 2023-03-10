package Recursion;

public class Tiling {
    public static int tilingProblem(int n){//2xn is floor size
        //base case
        if(n==0||n==1){
            return 1;
        }
        int verticalTiles=tilingProblem(n-1);
        int horizontalTiles=tilingProblem(n-2);
        return verticalTiles+horizontalTiles;
    }

    public static void main(String args[]){
        System.out.println(tilingProblem(4));



    }
}
