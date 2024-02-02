package DSAinJava.arrays;
import java.util.Arrays;
public class DestroyAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long weight=(long)mass;
        Arrays.sort(asteroids);
        for(int el : asteroids){
            if(weight>=el){
                weight+=el;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
