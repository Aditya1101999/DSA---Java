package DSAinJava.arrays;

public class IntersectingLines {
    class Point{
        int x;
        int y;
        private Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    boolean onSegment(Point p, Point q, Point r){
        return (q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y));
    }
    // Function to find the orientation of the ordered triplet (p, q, r)
    // Returns 0 if p, q, r are colinear
    // Returns 1 if p, q, r are clockwise
    // Returns 2 if p, q, r are counterclockwise
    private int orientation(Point p, Point q, Point r) {
        long val = (long)(q.y - p.y) * (r.x - q.x) -
                (long)(q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0; // collinear
        return (val > 0) ? 1 : 2; // clock or counterclockwise
    }
    String doIntersect(int p1Arr[], int q1Arr[], int p2Arr[], int q2Arr[]) {
        Point p1 = new Point(p1Arr[0], p1Arr[1]);
        Point q1 = new Point(q1Arr[0], q1Arr[1]);
        Point p2 = new Point(p2Arr[0], p2Arr[1]);
        Point q2 = new Point(q2Arr[0], q2Arr[1]);

        // Find the four orientations needed for general and special cases
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4) return "true";

        // Special Cases
        // p1, q1 and p2 are colinear and p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1)) return "true";

        // p1, q1 and q2 are colinear and q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) return "true";

        // p2, q2 and p1 are colinear and p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2)) return "true";

        // p2, q2 and q1 are colinear and q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) return "true";

        // Doesn't fall in any of the above cases
        return "false";
    }
}
