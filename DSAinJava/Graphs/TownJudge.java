package DSAinJava.Graphs;

public class TownJudge {
    public static int findJudge(int n, int[][] trust) {
        int inward[]=new int[n+1];//how many people trust the person
        int outward[]=new int[n+1];//how many people does this person trust
        for(int i=0;i<trust.length;i++){
            int outCount=outward[trust[i][0]];//curr outcount->by default 0
            outward[trust[i][0]]=outCount+1;//increment by 1
            int inCount=inward[trust[i][1]];//same as outcount
            inward[trust[i][1]]=inCount+1;
        }
        if(n==1) return 1;
        for(int i=0;i<n+1;i++){//judge condition
            if(outward[i]==0&&inward[i]==n-1){//judge trust nobody but everyone trust him
                return i;
            }
        } return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        System.out.println(findJudge(n,trust));

    }
}
