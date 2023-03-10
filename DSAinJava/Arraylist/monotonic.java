package Arraylist;

import java.util.ArrayList;

public class monotonic {
    public static boolean isMonotonic(ArrayList<Integer>A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < A.size()-1; i++) {
            if (A.get(i) < A.get(i + 1)) {
                dec = false;
            }
            else if (A.get(i) > A.get(i + 1)) {
                inc = false;
            }
        }
        return inc || dec;
    }
    public static void main(String[] args){
        ArrayList <Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        System.out.println(isMonotonic(list));
    }
}
