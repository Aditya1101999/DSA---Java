package Arraylist;
import java.util.ArrayList;
public class Beautiful {
    public static ArrayList<Integer> beautifulArray(int n){
        ArrayList<Integer>res=new ArrayList<>();
        divideConquer(1,1,res,n);
        return res;
    }
    public static void divideConquer(int start,int increment,ArrayList<Integer>res,int n) {
        if (start + increment > n) {//base case
            res.add(start);
            return;
        }
        divideConquer(start, 2 * increment, res, n);
        divideConquer(start+increment, 2 * increment, res, n);
    }
    public static void main(String[] args){
        System.out.print(beautifulArray(10));
    }
}
