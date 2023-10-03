package DSAinJava.DivideAndConq;
import java.util.*;
public class MurthalParatha {
    private static int minimumTimeToCookParanthas(int p, int n, int[] cooks){
        if(p==0) return 0;
        int low=Integer.MAX_VALUE;
        int maxRank=0;
        for(int el : cooks){
            low=Math.min(low,el);
            maxRank=Math.max(maxRank,el);
        }
        //maxRank+2maxRank+3maxRank.....p times
        //=>maxRank*(1+2+3+...... p times)
        int high=maxRank*(p*(p+1))/2;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossibleToCook(p,n,cooks,mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    private static boolean isPossibleToCook(int parathas,int n,int[] cooks,int time){
        int cooked=0;
        for(int cook : cooks){
            int cookingTime=cook;
            int i=2;
            while(cookingTime<=time){
                cooked++;
                cookingTime+=i*cook;
                i++;
                if(cooked==parathas) return true;
            }
        }
        return false;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int P = scanner.nextInt();
        int L = scanner.nextInt();
        int[] cooks = new int[L];
        for (int i = 0; i < L; i++) {
            cooks[i] = scanner.nextInt();
        }
        int result = minimumTimeToCookParanthas(P, L, cooks);
        System.out.println(result);
    }

}
