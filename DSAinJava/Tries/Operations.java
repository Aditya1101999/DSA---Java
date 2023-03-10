package Tries;

public class Operations {
    static class Node{
        Node[] children=new Node[26];
        boolean endWith=false;
        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int index=word.charAt(level)-'a';
            if(curr.children[index]==null){
                curr.children[index]=new Node();
            }
            curr=curr.children[index];
        }
        curr.endWith=true;
    }
    public static boolean search(String word){
        Node curr=root;
        for(int level=0;level<word.length();level++){
            int index=word.charAt(level)-'a';
            if(curr.children[index]==null){
                return false;
            }
            curr=curr.children[index];
        }
        return curr.endWith==true;
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
