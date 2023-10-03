package DSAinJava.Strings;

public class Origin {
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
        for(int i=0;i<moves.length();i++){
            char curr=moves.charAt(i);
            if(curr=='U') y++;
            else if(curr=='D') y--;
            else if(curr=='L') x--;
            else if(curr=='R') x++;
        }
        return (x==0 && y==0);
    }
    public int furthestDistanceFromOrigin(String moves) {
        int left=0;
        int right=0;
        int ano=0;
        for(int i=0;i<moves.length();i++){
            char curr=moves.charAt(i);
            if(curr=='L') left++;
            else if(curr=='R') right++;
            else ano++;
        }
        int dir1=Math.max(left,right);
        int dir2=Math.min(left,right);

        return dir1+ano-dir2;
    }
}
