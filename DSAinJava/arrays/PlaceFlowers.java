package DSAinJava.arrays;

public class PlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int limit) {
        int n=flowerbed.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(flowerbed[i]==0){
                boolean leftEmpty=(i==0||flowerbed[i-1]==0);
                boolean rightEmpty=(i==n-1||flowerbed[i+1]==0);
                if(leftEmpty && rightEmpty){
                    count++;
                    flowerbed[i]=1;
                    if(count==limit) return true;
                }
            }
        }
        return (count>=limit);
    }
}
