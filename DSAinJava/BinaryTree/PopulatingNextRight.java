package DSAinJava.BinaryTree;
import java.util.*;
public class PopulatingNextRight {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {
        }
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
    public void connectDFS(Node root) {//works only for complete binary tree
        if (root == null || root.left == null || root.right == null) return;

        root.left.next = root.right;//same root
        if (root.next != null) {
            root.right.next = root.next.left;//for two children of different roots
        }
        connectDFS(root.left);
        connectDFS(root.right);
    }
    public Node connectBFS(Node root) {
        if(root==null){
            return root;
        }
        Queue<Node>q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            Node dummy=new Node(0);
            while(size-->0){
                Node curr=q.remove();
                dummy.next=curr;
                dummy=dummy.next;

                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
    public Node connect(Node root) {//without extra space
        if(root==null){
            return root;
        }
        Node head=root;
        while(head!=null){//for complete tree
            Node dummy=new Node(0);
            Node temp=dummy;

            while(head!=null){//for each level
                if(head.left!=null){
                    temp.next=head.left;
                    temp=temp.next;
                }
                if(head.right!=null){
                    temp.next=head.right;
                    temp=temp.next;
                }
                head=head.next;
            }
            head=dummy.next;//new root
        }
        return root;
    }

}
