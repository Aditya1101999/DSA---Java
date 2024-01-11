package DSAinJava.DynProg;
import java.util.*;
public class ShoppingOffers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shoppingOffersHelper(price,special,needs,new HashMap<>());
    }
    private int shoppingOffersHelper(List<Integer> price, List<List<Integer>> special, List<Integer> needs,Map<List<Integer>,Integer>dp){
        int minPrice=getPrice(price,needs);

        if(dp.containsKey(needs)) return dp.get(needs);
        for(List<Integer>offer:special){
            if(isValidOffer(offer,needs)){
                List<Integer>newNeeds=getRemainingNeeds(offer,needs);
                int offerPrice=offer.get(offer.size()-1);
                minPrice=Math.min(minPrice,offerPrice+shoppingOffersHelper(price,special,newNeeds,dp));
            }
        }
        dp.put(needs,minPrice);
        return minPrice;
    }
    private int getPrice(List<Integer> price,List<Integer> needs){
        int cost=0;
        for(int i=0;i<price.size();i++){
            cost+=price.get(i)*needs.get(i);
        }
        return cost;
    }
    private boolean isValidOffer(List<Integer> offer,List<Integer> needs){
        for(int i=0;i<needs.size();i++){
            if(offer.get(i)>needs.get(i)) return false;
        }
        return true;
    }
    private List<Integer> getRemainingNeeds(List<Integer> offer,List<Integer> needs){
        List<Integer>newNeeds=new ArrayList<>(needs);
        for(int i=0;i<newNeeds.size();i++){
            newNeeds.set(i,needs.get(i)-offer.get(i));
        }
        return newNeeds;
    }
}
