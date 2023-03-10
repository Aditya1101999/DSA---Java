package DynProg;

import java.util.ArrayList;

public class BalParen {
    public static ArrayList<String> Paren(int n){
        ArrayList<String>result=new ArrayList<String>();
        Helper(result,"(",1,0,n);
        return result;
    }
    public static void Helper(ArrayList<String>result,String curr,int opencount,int closecount,int count){
        if(opencount+closecount==count*2){
            result.add(curr);
            return;
        }
        if(opencount<count){
            Helper(result, curr+"(", opencount+1, closecount, count);
        }
        if(closecount<opencount){
            Helper(result, curr+")", opencount, closecount+1, count);
        }
    }
    public static void main(String[] args){
        ArrayList<String>result=Paren(3);
        System.out.println(result);
    }
}
