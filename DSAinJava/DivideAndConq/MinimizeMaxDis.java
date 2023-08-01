package DSAinJava.DivideAndConq;

public class MinimizeMaxDis {
    public static double findSmallestMaxDist(int stations[],int K) {
        double low=0;
        double high=0;
        for(int i=0;i<stations.length-1;i++){
            high=Math.max(high,stations[i+1]-stations[i]);
        }
        double diff=1e-5;
        while(high-low>diff){
            double mid=low+(high-low)/2.0;
            if(areStationsSufficient(stations,mid,K)){
                high=mid;
            }
            else{
                low=mid;
            }
        }
        return high;

    }
    private static boolean areStationsSufficient(int[] stations,double dis,int K){
        int count=0;
        for(int i=1;i<stations.length;i++){
            int sectorLength=stations[i]-stations[i-1];
            int stationsPlaced=(int)(sectorLength/dis);
            if(sectorLength==dis*stationsPlaced){//exact multiple , so one extra station will be there in the answer
                stationsPlaced-=1;//e.g 1==0.5*2 , but only 1 can be placed
            }
            count+=stationsPlaced;
        }
        return count<=K;
    }
}
