package Arraylist;

import java.util.ArrayList;

public class PairSumtwo {
    public static boolean pairSum(ArrayList<Integer> array, int target) {
        int bP=-1;
        for(int i=0;i<array.size();i++){
            if(array.get(i)>array.get(i+1)){
                bP=i;//pivot or breaking point
                break;
            }
        }
        int lP=bP+1;
        int rP=bP;
        while (lP!=rP) {
            if (array.get(lP) + array.get(rP) == target) {
                return true;
            } else if (array.get(lP) + array.get(rP) < target) {
                lP=(lP+1)% array.size();
            } else {//if (array.get(lP) + array.get(rP) > target) {
                rP=(array.size()+rP-1)% array.size();
            }
        }
        return false;
    }
    public static void main(String[] args){
        ArrayList <Integer> list=new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target=16;
        System.out.println(pairSum(list,target));
    }

}
