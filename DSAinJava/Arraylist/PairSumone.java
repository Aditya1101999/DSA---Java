package Arraylist;

import java.util.ArrayList;

public class PairSumone {
    public static boolean pairSum(ArrayList<Integer> array,int target) {
        int lP = 0;
        int rP = array.size()-1;
        while (lP != rP) {
            if (array.get(lP) + array.get(rP) == target) {
                return true;
            } else if (array.get(lP) + array.get(rP) < target) {
                lP++;
            } else {//if (array.get(lP) + array.get(rP) > target) {
                rP--;
            }
        }
        return false;
    }
    public static void main(String[] args){
        ArrayList <Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        int target=5;
        System.out.println(pairSum(list,target));
    }

}
