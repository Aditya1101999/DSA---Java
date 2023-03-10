package Arraylist;

import java.util.ArrayList;

public class MostFreq{
    public static int MostFrequent(ArrayList<Integer> nums,int key){
        int[] result=new int[1000];
        for(int i=0;i<nums.size();i++){
            if(nums.get(i)==key){
                //storing frequency of no.s occuring after key
                result[nums.get(i+1)]++;
            }
        }
        int max=Integer.MIN_VALUE;
        int ans=0;
        for(int i=0;i< result.length;i++){
            if(result[i]>max){
                max=result[i];
                ans=i;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        ArrayList < Integer > list = new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(MostFrequent(list,2));

    }
}
