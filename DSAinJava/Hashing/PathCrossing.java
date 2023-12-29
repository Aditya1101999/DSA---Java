package DSAinJava.Hashing;
import java.util.*;
public class PathCrossing {
    public boolean isPathCrossing(String path) {
        //coordinates
        int x=0;
        int y=0;
        Set<String>set=new HashSet<>();
        String origin="("+x+"_"+y+")";
        set.add(origin);
        for(char c : path.toCharArray()){
            if(c=='N') y++;
            else if(c=='S') y--;
            else if(c=='E') x++;
            else x--;

            String coordinates="("+x+"_"+y+")";
            if(set.contains(coordinates)) return true;
            set.add(coordinates);
        }
        return false;
    }
}
