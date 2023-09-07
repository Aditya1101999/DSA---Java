package DSAinJava.Tries;
import java.util.*;
public class Trie {
    static class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean endWith=false;
        public TrieNode(){
            Arrays.fill(children,null);
        }
        boolean containsKey(char ch){
            return children[ch-'a']!=null;
        }
        void put(char ch,TrieNode node){
            children[ch-'a']=node;
        }
        TrieNode get(char ch){
            return children[ch-'a'];
        }
        void setEnd(){
            endWith=true;
        }
        boolean isEnd(){
            return endWith;
        }

    }
    private static TrieNode root;

    public Trie() {
        root=new TrieNode();
    }

    public static void insert(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){//insert
                node.put(word.charAt(i),new TrieNode());
            }
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public static boolean search(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.get(word.charAt(i));
        }
        return node.isEnd();

    }

    public boolean startsWith(String word) {
        TrieNode node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node=node.get(word.charAt(i));
        }
        return true;//not necessary that prefix is ending
    }

    public static void main(String[] args){
        String[] words={"i","like","sam","samsung","mobile","ice"};
        for(int i=0;i< words.length;i++){
            insert(words[i]);
        }
        System.out.println(search("thee"));
        String key="ilikesamsung";
    }
}
