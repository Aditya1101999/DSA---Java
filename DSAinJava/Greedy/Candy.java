package DSAinJava.Greedy;
import java.util.Arrays;
public class Candy {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int minCandies=0;
        int[] distribution=new int[n];
        //allocate 1 candy to each child
        Arrays.fill(distribution,1);
        for(int i=0;i<n-1;i++){//left->right scan
            if(ratings[i]<ratings[i+1]){
                distribution[i+1]=distribution[i]+1;
            }
        }
        for(int i=n-1;i>0;i--){//right->left scan
            if(ratings[i]<ratings[i-1]){
                if(distribution[i-1]<=distribution[i]){//if already greater then don't change the value
                    distribution[i-1]=distribution[i]+1;
                }
            }
        }
        for(int dist:distribution){
            minCandies+=dist;
        }
        return minCandies;
    }
}
