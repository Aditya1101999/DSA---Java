package DSAinJava.Tries;
import java.util.Arrays;
public class LongestPrefixLen {
    class Trie {
        class TrieNode{
            TrieNode[] children=new TrieNode[10];
            public TrieNode(){
                Arrays.fill(children,null);
            }
            boolean containsKey(char ch){
                return children[ch-'0']!=null;
            }
            void put(char ch,TrieNode node){
                children[ch-'0']=node;
            }
            TrieNode get(char ch){
                return children[ch-'0'];
            }

        }
        private TrieNode root;

        public Trie() {
            root=new TrieNode();
        }

        public void insert(String word) {
            TrieNode node=root;
            for(int i=0;i<word.length();i++){
                if(!node.containsKey(word.charAt(i))){//insert
                    node.put(word.charAt(i),new TrieNode());
                }
                node=node.get(word.charAt(i));
            }
        }
        public int longestPrefixLength(String word){
            int ans=0;
            TrieNode node=root;
            for(char c : word.toCharArray()){
                if(node.containsKey(c)){
                    node=node.get(c);
                    ans++;
                }
                else{
                    break;
                }
            }
            return ans;
        }
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie=new Trie();
        for(int el : arr1){
            trie.insert(Integer.toString(el));
        }
        int ans=0;
        for(int el : arr2){
            String str=Integer.toString(el);
            int curr=trie.longestPrefixLength(str);
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}
