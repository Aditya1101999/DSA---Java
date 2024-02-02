package DSAinJava.Graphs;
import java.util.*;
public class ShortestPrimePath {
    boolean[] primeCalculator(){
        boolean[] isPrime=new boolean[10000];
        Arrays.fill(isPrime,true);
        isPrime[1]=false;
        for(int i=2;i<10000;i++){
            if(isPrime[i]){
                for(int j=2;j*i<10000;j++){
                    isPrime[j*i]=false;
                }
            }
        }
        return isPrime;
    }
    int solve(int Num1,int Num2){
        boolean[] isPrime=primeCalculator();
        boolean[] visited=new boolean[10000];
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{Num1,0});
        visited[Num1]=true;
        while(!q.isEmpty()){
            int num=q.peek()[0];
            int steps=q.peek()[1];

            if(num==Num2) return steps;
            q.poll();

            String no=Integer.toString(num);
            for(int i=0;i<4;i++){
                for(char c='0';c<='9';c++){
                    if(c==no.charAt(i) || (i==0 && c=='0')) continue;
                    char[] arr=no.toCharArray();
                    arr[i]=c;
                    String newNum=new String(arr);
                    int newNo=Integer.parseInt(newNum);
                    if(!visited[newNo] && isPrime[newNo]){
                        visited[newNo]=true;
                        q.add(new int[]{newNo,steps+1});
                    }
                }
            }
        }
        return -1;
    }
}
