package DSAinJava.Two_DArrays;

public class LongestDiagonalArea {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double longestDiagonal=0;
        int maxArea=0;
        for(int[] dimension : dimensions){
            int height=dimension[0];
            int width=dimension[1];

            double diagonal=Math.sqrt(height*height + width*width);
            if(diagonal>longestDiagonal){
                longestDiagonal=diagonal;
                maxArea=height*width;
            }
            else if(diagonal==longestDiagonal){
                maxArea=Math.max(maxArea,height*width);
            }
        }
        return maxArea;
    }
}

