package DSAinJava.BinaryTree;
import java.util.*;
public class SearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
        }
    }
    public static Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){//left subtree
            root.left=insert(root.left,val);
        }
        else{//right subtree
            root.right=insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }
    public static Node delete(Node root,int key){
        if(root.data<key){
            root.right=delete(root.right,key);
        }
        else if(root.data>key){
            root.left=delete(root.left,key);
        }
        else{//required case
            //leaf node
            if(root.left==null&&root.right==null){
                return null;
            }
            //single child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            //2 children
            Node iS=findInorderSuccessor(root.right);
            root.data=iS.data;
            root.right=delete(root.right, iS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        //left most node
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    public static void inRange(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            inRange(root.left,k1,root.data);
            System.out.print(root.data+" ");
            inRange(root.right,root.data,k2);
        }
        else if(root.data>k2){
            inRange(root.left,k1,k2);
        }
        else{
            inRange(root.right,k1,k2);
        }
    }
    public int ceil(Node root, int key) {//value equal or just greater than key in tree
        int ceil=-1;
        while(root!=null){
            if(key==root.data){
                return root.data;
            }
            if(key>root.data) root=root.right;
            else{
                ceil=root.data;
                root=root.left;
            }
        }
        return ceil;
    }
    public int floor(Node root, int key) {//value equal or just smaller than key in tree
        int floor=-1;
        while(root!=null){
            if(key==root.data){
                return root.data;
            }
            if(key<root.data) root=root.left;
            else{
                floor=root.data;
                root=root.right;
            }
        }
        return floor;
    }
    int mean(Node root, int key){
        if(root==null) return 0;
        int val1=ceil(root,key);
        int val2=floor(root,key);
        return (int)Math.ceil((val1+val2)/2.0);
    }
    public static void printPath(ArrayList<Integer>path){
        for(int i=0;i< path.size();i++){
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }
    public static void rootToLeaf(Node root,ArrayList<Integer>path){
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null&&root.right==null){
            printPath(path);
        }
        rootToLeaf(root.left,path);
        rootToLeaf(root.right,path);
        //removing root at last index(backtracking)
        path.remove(path.size()-1);
    }
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root==null){
            return "";
        }
        Queue<Node>q=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                res.append("n ");
                continue;
            }
            res.append(curr.data+" ");
            q.add(curr.left);
            q.add(curr.right);
        }
        return res.toString();
    }


    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data=="") return null;
        Queue<Node>q=new LinkedList<>();
        String[] values=data.split(" ");
        Node root=new Node(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i<values.length;i++){
            Node curr=q.remove();
            if(!values[i].equals("n")){//left
                Node left=new Node(Integer.parseInt(values[i]));
                curr.left=left;
                q.add(left);
            }
            if(!values[++i].equals("n")){//right
                Node right=new Node(Integer.parseInt(values[i]));
                curr.right=right;
                q.add(right);
            }
        }
        return root;
    }
    public static boolean isValidBst(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null&&root.data<=min.data){
            return false;
        }
        else if(max!=null&&root.data>=max.data){
            return false;
        }
        return isValidBst(root.left,min,root)
                &&isValidBst(root.right,root,max);
    }
    static class Info{
        boolean isBST;
        int size;
        int max;
        int min;
        public Info(boolean isBST,int size,int max,int min){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }
    public static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        Info leftInfo=largestBST(root.left);
        Info rightInfo=largestBST(root.right);
        int size= leftInfo.size+rightInfo.size+1;
        int min=Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max=Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));
        if(root.data<= leftInfo.max||root.data>= rightInfo.min){
            return new Info(false,size,max,min);
        }
        if(leftInfo.isBST&&rightInfo.isBST){
            maxBST=Math.max(maxBST,size);
            return new Info(true,size,max,min);
        }
        //maximum size of a valid BST from both sides
        return new Info(false,Math.max(leftInfo.max, rightInfo.max),Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    static class Info1{
        int min;
        int max;
        int sum;
        public Info1(int min,int max,int sum){
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    static int result=Integer.MIN_VALUE;
    public static Info1 MaxBSTSum(Node root){
        if(root==null){
            return new Info1(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Info1 leftInfo=MaxBSTSum(root.left);
        Info1 rightInfo=MaxBSTSum(root.right);
        if(leftInfo.max>= root.data||rightInfo.min<= root.data){
            return new Info1(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        }
        int sum= leftInfo.sum+rightInfo.sum+root.data;
        System.out.println("sum :"+sum);
        result=Math.max(0,Math.max(result,sum));
        int min=Math.min(root.data,leftInfo.min);
        int max=Math.max(root.data,rightInfo.max);
        return new Info1(min,max,sum);
    }
    private static int sum=0;
    public static int inRangeSum(Node root,int k1,int k2){
        inRangeSumHelper(root,k1,k2);
        return sum;
    }
    public static void inRangeSumHelper(Node root,int k1,int k2){
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            sum+=root.data;
            inRangeSumHelper(root.left,k1,root.data);
            inRangeSumHelper(root.right,root.data,k2);
        }
        else if(root.data>k2){
            inRangeSumHelper(root.left,k1,k2);
        }
        else{
            inRangeSumHelper(root.right,k1,k2);
        }
    }
    public static Node closestElement(Node root,int val){
        if(root==null){
            return null;
        }
        int minDiff=Integer.MAX_VALUE;
        Node closestEle=null;
        while(root!=null){
            int currDiff=Math.abs(root.data-val);
            if(currDiff<minDiff){
                minDiff=currDiff;
                closestEle=root;
            }
            if(val<root.data){
                root=root.left;
            }
            else if(val>root.data){
                root=root.right;
            }
            else{
                break;
            }
        }
        return closestEle;
    }
    TreeNode previ;
    int minDiff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }
    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(previ!=null) minDiff=Math.min(minDiff,root.val-previ.val);
        previ=root;
        inorder(root.right);
    }
    public static void morrisTraversal(Node root){
        if(root==null){
            return;
        }
        Node curr=root;
        while(curr!=null){
            if(curr.left==null){
                System.out.print(curr.data+" ");
                curr=curr.right;
            }
            else{
                Node prev=curr.left;
                while(prev.right!=null&&prev.right!=curr){
                    prev=prev.right;
                }
                if(prev.right==null){
                    prev.right=curr;
                    curr=curr.left;
                }
                else{
                    prev.right=null;
                    System.out.print(curr.data+" ");
                    curr=curr.right;
                }
            }
        }
    }
    static Node prev=null;
    static Node head=null;
    public static void convertToDLL(Node root){
        if(root==null){
            return;
        }
        convertToDLL(root.left);
        if(prev==null){
            head=root;
        }
        else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        convertToDLL(root.right);
    }
    private Node pre = null;
    public void flatten(Node root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    public static void printList(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.right;
        }
    }
    static int count=0;
    public static Node KthSmallest(Node root,int k) {
        if (root == null) {
            return null;
        }
        Node left=KthSmallest(root.left,k);
        if(left!=null){
            return left;
        }
        count++;
        if(count==k){
            return root;
        }
        return KthSmallest(root.right,k);
    }
    static int count1=0;
    public static Node KthLargest(Node root,int k) {
        if (root == null) {
            return null;
        }
        Node right=KthLargest(root.right,k);
        if(right!=null){
            return right;
        }
        count1++;
        if(count1==k){
            return root;
        }
        return KthLargest(root.left,k);
    }
    static int s=0;
    public static Node greaterValAdd(Node root){
        if(root==null){
            return null;
        }
        greaterValAdd(root.right);
        root.data+=s;
        s= root.data;
        greaterValAdd(root.left);
        return root;
    }
    public static int pairCount=0;
    public static void traverseTree(Node root1,Node root2,int sum){
        if(root1==null||root2==null){
            return;
        }
        traverseTree(root1.left,root2,sum);
        traverseTree(root1.right,root2,sum);
        int diff=sum-root1.data;
        findPairs(root2,diff);
    }
    private static void findPairs(Node root2,int diff){
        if(root2==null){
            return;
        }
        if(diff> root2.data){
            findPairs(root2.right,diff);
        }
        else{
            findPairs(root2.left,diff);
        }
        if(root2.data==diff){
            pairCount++;
        }
    }
    public static int countPairs(Node root1,Node root2,int sum){
        traverseTree(root1, root2, sum);
        return pairCount;
    }

    public static void main(String[] args){
        int[] values={8,5,3,1,4,6,10,11,14};
        Node root=null;
        for(int i=0;i<values.length;i++){
            root=insert(root,values[i]);
        }
        inorder(root);
        System.out.println();
        if(search(root,1)){
            System.out.println("found");
        }
        root=delete(root,10);
        inorder(root);
        System.out.println();
        inRange(root,5,12);
        System.out.println();
        rootToLeaf(root,new ArrayList<>());
        if(isValidBst(root,null,null)){
            System.out.println("valid BST");
        }
        Info info=largestBST(root);
        System.out.println(maxBST);
        Info1 info1=MaxBSTSum(root);
        System.out.println(result);
        System.out.println(inRangeSum(root,5,12));
        Node closestElement=closestElement(root,12);
        System.out.println(closestElement.data);
        morrisTraversal(root);
        System.out.println();
        Node newNode=KthSmallest(root,6);
        System.out.println(newNode.data);
        Node newNod=KthLargest(root,6);
        System.out.println(newNod.data);
        Node root1=greaterValAdd(root);
        inorder(root1);
        System.out.println();
        convertToDLL(root);
        printList(head);
        root1 = new Node(5); /*                  5        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(7); /*         3     7     */
        root1.left.left = new Node(2); /*    / \   / \    */
        root1.left.right = new Node(4); /*  2   4 6   8 */
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        // formation of BST 2
        root = new Node(10); /*                 10         */
        root.left = new Node(6); /*           /   \ */
        root.right = new Node(15); /*        6     15 */
        root.left.left = new Node(3); /*    / \   /  \ */
        root.left.right = new Node(8); /*  3  8  11  18    */
        root.right.left = new Node(11);
        root.right.right = new Node(18);
        int x = 16;
        System.out.println();
        System.out.println("pairs : "+countPairs(root1,root,x));

    }
}
