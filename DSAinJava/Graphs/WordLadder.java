package DSAinJava.Graphs;
import java.util.*;
public class WordLadder {
    static class Pair{
        String word;
        int level;
        public Pair(String word,int level){
            this.word=word;
            this.level=level;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet<>(wordList);
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        if(set.contains(beginWord)) set.remove(beginWord);

        while(!q.isEmpty()){
            String currWord=q.peek().word;
            int currLevel=q.peek().level;
            q.remove();

            if(currWord.equals(endWord)) return currLevel;

            for(int i=0;i<currWord.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedWordArray=currWord.toCharArray();
                    replacedWordArray[i]=ch;
                    String newStr=new String(replacedWordArray);
                    if(set.contains(newStr)){
                        set.remove(newStr);
                        q.add(new Pair(newStr, currLevel + 1));
                    }
                }
            }
        }
        return 0;
    }
    //no. of ladders->TLE(for interviews)
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet<>(wordList);
        Queue<List<String>>q=new LinkedList<>();
        List<String>list=new ArrayList<>();
        list.add(beginWord);
        q.add(list);
        List<String>usedOnLevel=new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level=0;
        List<List<String>>ans=new ArrayList<>();
        while(!q.isEmpty()){
            List<String>curr=q.remove();
            if(curr.size()>level){//level change
                level++;
                for(String str:usedOnLevel){
                    set.remove(str);
                }
            }
            String currWord=curr.get(curr.size()-1);
            if(currWord.equals(endWord)){//first answer or size equal to first answer
                if(ans.size()==0||ans.get(0).size()==curr.size()) ans.add(curr);
            }
            for(int i=0;i<currWord.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedWordArray=currWord.toCharArray();
                    replacedWordArray[i]=ch;
                    String newStr=new String(replacedWordArray);
                    if(set.contains(newStr)){
                        curr.add(newStr);
                        usedOnLevel.add(newStr);
                        q.add(curr);
                        curr.remove(curr.size()-1);//backtrack
                    }
                }
            }
        }
        return ans;
    }
    List<List<String>>ans;
    HashMap<String,Integer>map;
    public List<List<String>> findLaddersOptimized(String beginWord, String endWord, List<String> wordList) {
        Set<String>set=new HashSet<>(wordList);
        int wordSize=beginWord.length();
        Queue<String>q=new LinkedList<>();
        q.add(beginWord);
        map=new HashMap<>();
        map.put(beginWord,1);
        set.remove(beginWord);
        while(!q.isEmpty()){
            String currWord=q.remove();
            int currLevel=map.get(currWord);
            if(currWord.equals(endWord)) break;
            for(int i=0;i<wordSize;i++){
                for(char ch='a';ch<='z';ch++){
                    char[] replacedWordArray=currWord.toCharArray();
                    replacedWordArray[i]=ch;
                    String newStr=new String(replacedWordArray);
                    if(set.contains(newStr)){
                        q.add(newStr);
                        set.remove(newStr);
                        map.put(newStr,currLevel+1);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        List<String>curr=new ArrayList<>();
        if(map.containsKey(endWord)) {
            curr.add(endWord);
            dfs(beginWord, endWord, curr);
        }
        return ans;
    }
    private void dfs(String beginWord,String endWord,List<String>curr){
        if(endWord.equals(beginWord)){
            //not changing original list as it will disturb recursion
            List<String>temp=new ArrayList<>(curr);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        if(!map.containsKey(endWord)) return;
        int level=map.get(endWord);
        int wordSize=beginWord.length();
        for(int i=0;i<wordSize;i++){
            for(char ch='a';ch<='z';ch++){
                char[] replacedWordArray=endWord.toCharArray();
                replacedWordArray[i]=ch;
                String newStr=new String(replacedWordArray);
                if(map.containsKey(newStr) && map.get(newStr)+1==level){
                    curr.add(newStr);
                    dfs(beginWord,newStr,curr);
                    curr.remove(curr.size()-1);
                }
            }
        }
    }
}
