package Arraylist;

import java.util.ArrayList;

public class Rev {
    public static void main(String[] args){
        ArrayList <Integer> list=new ArrayList<>();
        //some basic operations
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);
       list.add(5);
//        list.remove(0);
//        list.contains(1);->boolean type output
//        list.set(0,10);
//        list.size();
       for(int i= list.size()-1;i>=0;i--){
           System.out.print(list.get(i)+" ");
       }
        System.out.println();
    }
}
