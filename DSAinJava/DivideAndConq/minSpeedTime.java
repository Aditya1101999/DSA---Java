package DSAinJava.DivideAndConq;

public class minSpeedTime {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        int minSpeed=-1;
        int low = 1;
        int high = (int) (1e9);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (validDivisionPossible(mid, dist, hour)) {
                high = mid - 1;
                minSpeed=mid;
            } else {
                low = mid + 1;
            }
        }
        return minSpeed;
    }

    private boolean validDivisionPossible(int speed, int[] dist, double hour) {
        double time = 0.0;
        for (int i = 0; i < dist.length; i++) {
            if (i != dist.length - 1) {
                time += Math.ceil((double) dist[i] / (double) speed);
            } else {
                // we don't have to wait for any train after the last train
                time += (double) dist[i] / (double) speed;
            }
        }
        return time <= hour;
    }
}
