package DSAinJava.Greedy;
import java.util.Arrays;
public class ContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int children=0;
        int cookies=0;
        while(children<g.length && cookies<s.length){
            if(g[children]<=s[cookies]){
                children++;
            }
            cookies++;
        }
        return children;
    }
}
