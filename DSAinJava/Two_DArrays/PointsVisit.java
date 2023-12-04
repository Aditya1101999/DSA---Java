package DSAinJava.Two_DArrays;

public class PointsVisit {
    public int minTimeToVisitAllPoints(int[][] points) {
        //equation -> min(dx,dy)+abs(dx-dy)
        int n=points.length;
        int time=0;
        for(int i=0;i<n-1;i++){//no time after last point reached
            int x1=points[i][0];
            int y1=points[i][1];

            int x2=points[i+1][0];
            int y2=points[i+1][1];

            int dx=Math.abs(x2-x1);
            int dy=Math.abs(y2-y1);

            time+=Math.min(dx,dy)+Math.abs(dx-dy);

        }
        return time;
    }
}
