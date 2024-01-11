package DSAinJava.Two_DArrays;

public class captureQueen {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        //rook and queen are in same line
        if(a==e || b ==f){
            //bishop is in between
            if(a==e && a==c && (d-b)*(d-f)<0) return 2;
            if(b==f && b==d && (c-a)*(c-e)<0) return 2;
            return 1;
        }

        //bishop and queen are in same line
        if(Math.abs(c-e)==Math.abs(d-f)){//diagonals increase/decrease with 1 unit change in row & col
            if(Math.abs(e-a)==Math.abs(f-b) && (a-c)*(a-e)<0) return 2;//we can also check using cols
            return 1;
        }
        //rest all cases
        return 2;
    }
}
