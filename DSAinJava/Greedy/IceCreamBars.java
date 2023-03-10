package Greedy;
import java.util.*;
public class IceCreamBars {
    public static int maxIceCream(int[] costs, int coins) {
        int bars=0;
        int n=costs.length;
        Arrays.sort(costs);
        for(int i=0;i<n;i++){
            if(costs[i]<=coins){//buy
                bars++;
                coins-=costs[i];
            }
            else{
                break;
            }
        }
        return bars;
    }
    public static void main(String[] args){
        int[] costs = {1,3,2,4,1};
        int coins = 7;
        System.out.println(maxIceCream(costs,coins));
    }
}
