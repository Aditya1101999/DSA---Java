package Recursion;

public class TowerOfHanoi {
    public static void towerOfHanoi(int n,String str,String mid ,String end){
        //n is no. of discs
        //base condition
        if(n==1){
            System.out.println("disk "+n+"from"+str+"to"+end);
            return;
        }
        //shifting n-1 disc from str to mid
        towerOfHanoi(n-1,str,end,mid);
        //shifting last disc from str to end
        System.out.println("disk "+n+"from"+str+"to"+end);
        //shifting n-1 disc from mid to end
        towerOfHanoi(n-1,mid,str,end);
    }
    public static void main(String args[]){

        towerOfHanoi(4,"A","B","C");
    }


}
