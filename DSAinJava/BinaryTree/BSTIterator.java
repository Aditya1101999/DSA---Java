package DSAinJava.BinaryTree;
import java.util.Stack;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class BSTIterator {
    Stack<TreeNode>st=new Stack<>();
    //reverse->true ->before
    //reverse->false ->next
    boolean reverse=false;

    public BSTIterator(TreeNode root,boolean isReverse) {
        this.reverse = isReverse;
        push(root);//inorder
    }

    public int next() {
        TreeNode curr=st.pop();
        if(!reverse) push(curr.right);//simple inorder(next)
        else push(curr.left);//reversed inorder(before)
        return curr.val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
    private void push(TreeNode root){
        while(root!=null){
            st.push(root);
            if(!reverse) root=root.left;
            else root=root.right;
        }
    }
}
class TwoSuminBST {

    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator left=new BSTIterator(root,false);//!reverse -> next
        BSTIterator right=new BSTIterator(root,true);//reverse ->before

        //two-pointer
        int i=left.next();
        int j=right.next();//before
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=left.next();//increase
            else j=right.next();//decrease
        }
        return false;
    }
}


