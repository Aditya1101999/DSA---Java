package DSAinJava.arrays;

public class CircleRectOverlap {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        //find a point in rectangle closest to the center of circle
        int x;
        int y;
        if(x1<=xCenter && xCenter<=x2){
            x=xCenter;
        }
        else if(xCenter<x1){
            x=x1;
        }
        else{
            x=x2;
        }

        if(y1<=yCenter && yCenter<=y2){
            y=yCenter;
        }
        else if(yCenter<y1){
            y=y1;
        }
        else{
            y=y2;
        }
        double distance = Math.sqrt(Math.pow((x - xCenter), 2) + Math.pow((y - yCenter), 2));
        return distance<=radius;
    }
}
