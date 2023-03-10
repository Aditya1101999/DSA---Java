package BinaryTree;
import java.util.*;
public class DupliSubtree {
    static HashMap<String, Integer> map;
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static String duplicateSubtrees(Node node){
        if(node==null){
            return " ";
        }
        String str="(";
        str+=duplicateSubtrees(node.left);
        str+=Integer.toString(node.data);
        str+=duplicateSubtrees(node.right);
        str+=")";
        map.put(str,map.getOrDefault(str,0)+1);
        if(map.get(str)==2){
            System.out.println(node.data);
        }
        return str;
    }
    static void print(Node root){
        map=new HashMap<>();
        duplicateSubtrees(root);
    }

    public static void main(String args[]){
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.right.left = new Node(2);
            root.right.left.left = new Node(4);
            root.right.right = new Node(4);
            print(root);
    }
}
