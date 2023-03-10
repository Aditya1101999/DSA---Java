package arrays;
import java.util.*;
public class stocks {
    public static int buyAndSellStocks(int[] prices){
        int maxProfit=0;
        int buyingPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]>buyingPrice){//profit
                int profit=prices[i]-buyingPrice;//today's profit
                maxProfit=Math.max(profit,maxProfit);
            }
            else{
                buyingPrice=prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String args[]){
        int prices[]={7,6,4,3,1};
        System.out.println((buyAndSellStocks(prices)));
    }

}
