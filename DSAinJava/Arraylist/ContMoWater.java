package Arraylist;
import java.util.ArrayList;

public class ContMoWater {
    public static int bruteForce(ArrayList<Integer> height){
        int maxWater=Integer.MIN_VALUE;
        for(int i=0;i< height.size();i++){//line 1
            for(int j=i+1;j< height.size();j++){//line 2
                int ht=Math.min(height.get(i), height.get(j));
                int width=j-i;
                int currWater=ht*width;
                maxWater=Math.max(currWater,maxWater);
            }
        }
        return maxWater;
    }
    public static int optimized(ArrayList<Integer> height){
        int lP=0;
        int rP= height.size()-1;
        int maxWater=0;
        while(lP<rP) {
            //calculate water area
            int ht = Math.min(height.get(lP), height.get(rP));
            int width = rP - lP;
            int currWater=ht*width;
            maxWater=Math.max(currWater,maxWater);
            //updating pointers
            if (height.get(lP) < height.get(rP)) {
                lP++;
            } else {
                rP--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args){
        ArrayList<Integer> height=new ArrayList<>();
        //1,8,6,2,5,4,8,3,7
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        //System.out.println(bruteForce(height));
        System.out.println(optimized(height));
    }
}
