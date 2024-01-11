package DSAinJava.Strings;

public class LaserBeam {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int prev=0;
        for(String row : bank){
            int count=0;
            for(char c : row.toCharArray()){
                if(c=='1'){
                    count++;
                }
            }
            if(count>0){
                ans+=prev*count;
                prev=count;
            }
        }
        return ans;
    }
}
