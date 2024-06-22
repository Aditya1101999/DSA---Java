package DSAinJava.arrays;

public class Rectangles {
    int rectanglesInCircle(int r) {
        int ans=0;
        int diagonal=2*r;
        for(int l=1;l<=diagonal;l++){
            for(int b=1;b<=diagonal;b++){
                if(l*l + b*b <=diagonal*diagonal) ans++;
            }
        }
        return ans;
    }
}
