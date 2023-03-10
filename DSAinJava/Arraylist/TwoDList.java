package Arraylist;
import java.util.ArrayList;

public class TwoDList {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> mainList= new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        mainList.add(list);

        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(3);
        list1.add(4);
        mainList.add(list1);

        for(int i=0;i< mainList.size();i++){
            ArrayList<Integer> currList=mainList.get(i);
            for(int j=0;j<currList.size();j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }
        System.out.println(mainList);
        for(int i=1;i<6;i++){
            list.add(i*1);//1 2 3 4 5
            list1.add(i*2);// 2 4 6 8 10
        }
        System.out.println(mainList);
    }

}
