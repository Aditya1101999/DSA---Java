package DSAinJava.Hashing;
import java.util.*;
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String>set=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char curr=board[i][j];
                if(curr!='.'){
                    if(set.contains(curr+"_r_"+i) ||
                            set.contains(curr+"_c_"+j) ||
                            set.contains(curr+"_b_"+i/3+"_"+j/3)){
                        return false;
                    }
                    else{
                        set.add(curr+"_r_"+i);
                        set.add(curr+"_c_"+j);
                        set.add(curr+"_b_"+i/3+"_"+j/3);
                    }
                }
            }
        }
        return true;
    }
}
