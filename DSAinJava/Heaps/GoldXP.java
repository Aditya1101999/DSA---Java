package DSAinJava.Heaps;
import java.util.*;
public class GoldXP {
    static class Pair{
        int expReq;
        int expGain;
        public Pair(int expReq,int expGain){
            this.expReq=expReq;
            this.expGain=expGain;
        }
    }
    public long MaxXP(int n, int k, int initial_exp, int exp_req[], int exp_gain[]) {
        Pair[] exp=new Pair[n];
        for(int i=0;i<n;i++){
            exp[i]=new Pair(exp_req[i],exp_gain[i]);
        }
        Arrays.sort(exp,(a,b)->a.expReq-b.expReq);
        long currExp=initial_exp;
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->(b-a));//expGain
        for(int i=0;i<n;i++){
            while(!pq.isEmpty() && currExp<exp[i].expReq && k>0){
                currExp+=pq.poll();
                k--;
            }
            if(k==0) break;
            if(currExp>=exp[i].expReq){//can be added(possibility)
                pq.add(exp[i].expGain);
            }
        }
        while(!pq.isEmpty() && k>0){
            currExp+=pq.poll();
            k--;
        }
        return currExp;
    }
    //eat of be eaten
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] strength=new int[n];
        for(int i=0;i<n;i++){
            strength[i]=sc.nextInt();
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>((a,b)->b-a);
        boolean flag=true;
        Arrays.sort(strength);
        if(strength[0]>x) flag=false;
        for(int i=0;i<n;i++){
            while(strength[i]<=x){
                pq.add(strength[i]);
                i++;
            }
            while(x<strength[i] && !pq.isEmpty()){
                x+=pq.poll();
            }
            if(pq.isEmpty()){
                flag=false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}
