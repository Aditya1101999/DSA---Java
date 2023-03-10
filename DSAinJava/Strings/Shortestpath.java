package Strings;
public class Shortestpath {
    public static float shortest(String path){
        int x=0,y=0;

        for(int i=0;i<path.length();i++){
            char dir=path.charAt(i);
            //North
            if(dir=='S'){
                y--;
            }
            //North
            if(dir=='N'){
                y++;
            }
            //West
            if(dir=='W'){
                x--;
            }
            //East
            if(dir=='E'){
                x++;
            }
        }
        int x2=x*x;
        int y2=y*y;
        //pythagoras theorem
//typecast into float
        return (float)Math.sqrt(x2+y2);
    }
    public static void main(String args[]){
        String path="WNEENESENNN";
        System.out.println(shortest(path));
    }
}
