package Backtracking;

public class Subsets {
    public static void findSubsets(String str,String ans,int i){
        //base case
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
                return;
            }else {
                System.out.println(ans);
            }
            return;
        }
        //if string is added(yes)
        findSubsets(str,ans+str.charAt(i),i+1);
        //if not added(no)
        findSubsets(str, ans, i+1);
    }
    public static void main(String args[]){
        String str="abc";
        findSubsets(str,"",0);
    }
}
