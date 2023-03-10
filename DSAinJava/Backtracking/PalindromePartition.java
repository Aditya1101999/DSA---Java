package Backtracking;
import java.util.*;
public class PalindromePartition {
    public static List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList<>();
        dfs(list,new ArrayList<String>(),s);
        return list;
    }
    private static void dfs(List<List<String>> list,ArrayList<String> currList,String s){
        if(s.length()==0){
            list.add(new ArrayList<>(currList));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,0,i)){
                currList.add(s.substring(0,i+1));
                dfs(list,currList,s.substring(i+1));
                currList.remove(currList.size()-1);//backtracking
            }
        }
    }
    private static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args){
        String s="aab";
        System.out.println(partition(s));
    }

}
