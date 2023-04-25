package BinaryTree;

public class SegmentTree {
    class SegmentTreeNode{
        private int start,end;
        private SegmentTreeNode left,right;
        private int sum;
        SegmentTreeNode(int start,int end){
            this.start=start;
            this.end=end;
            this.left=null;
            this.right=null;
            this.sum=0;
        }
    }
    SegmentTreeNode root=null;

    public SegmentTree(int[] nums) {
        root=buildTree(nums,0,nums.length-1);
    }
    private SegmentTreeNode buildTree(int[] nums,int start,int end){//O(N)
        if(start>end){
            return null;
        }
        SegmentTreeNode res=new SegmentTreeNode(start,end);
        if(start==end){
            res.sum=nums[start];
        }
        else{
            int mid=start+(end-start)/2;
            res.left=buildTree(nums,start,mid);
            res.right=buildTree(nums,mid+1,end);
            res.sum=res.left.sum+res.right.sum;
        }

        return res;
    }

    public void update(int index, int val) {//O(log N)
        updateHelper(root,index,val);
    }
    private void updateHelper(SegmentTreeNode root,int index,int val){
        if(root.start==root.end){
            root.sum=val;
            return;
        }
        int mid=root.start+(root.end-root.start)/2;
        if(index<=mid){//target index on left
            updateHelper(root.left,index,val);
        }
        else{
            updateHelper(root.right,index,val);
        }
        root.sum=root.left.sum+root.right.sum;
    }

    public int sumRange(int start, int end) {//O(log N)
        return sumHelper(root,start,end);
    }
    private int sumHelper(SegmentTreeNode root,int start,int end){
        if(root.start==start && root.end==end){//required range found
            return root.sum;
        }
        int mid=root.start+(root.end-root.start)/2;
        if(end<=mid){//move left
            return sumHelper(root.left,start,end);
        }
        else if(start>mid){
            return sumHelper(root.right,start,end);
        }
        return sumHelper(root.left,start,mid)+sumHelper(root.right,mid+1,end);
    }
    //method 2
    static int[] tree;
    public static void init(int n){
        tree=new int[4*n];
    }
    public static int buildTree(int[] arr,int index,int start,int end){
        if(start==end) {//leaf node
            tree[index]=arr[start];
            return arr[start];
        }
        int mid=(start+end)/2;
        buildTree(arr, 2*index+1, start, mid);//left
        buildTree(arr, 2*index+2, mid+1, end);//right
        tree[index]=tree[2*index+1]+tree[2*index+2];
        return tree[index];
    }
    public static int getSumUtil(int i,int si,int sj,int qi,int qj){
        if(qj<=si||qi>=sj){//no overlap
            return 0;
        }
        else if(si>=qi&&sj<=qj){//complete overlap
            return tree[i];
        }
        else{//partial overlap
            int mid=(si+sj)/2;
            return getSumUtil(2*i+1,si,mid,qi,qj)+//left
                    getSumUtil(2*i+2,mid+1,sj,qi,qj);//right
        }
    }
    public static int getSum(int[] arr,int qi,int qj){
        int n= arr.length;
        return getSumUtil(0,0,n-1,qi,qj);
    }
    public static void updateArr(int[] arr,int idx,int newVal){
        int diff=newVal-arr[idx];
        int n= arr.length;
        arr[idx]=newVal;
        updateUtil(0,0,n-1,idx,diff);
    }
    public static void updateUtil(int i,int si,int sj,int idx,int diff){
        //if idx is not in range
        if(idx>sj||idx<si){
            return;
        }
        tree[i]+=diff;
        if(si!=sj){//non-leaf node
            int mid=(si+sj)/2;
            updateUtil(2*i+1, si, mid, idx, diff);//left
            updateUtil(2*i+2, mid+1, sj, idx, diff);//right
        }
    }
    public static void buildMaxTree(int[] arr,int i,int si,int sj){
        if(si==sj) {//leaf node
            tree[i]=arr[si];
            return;
        }
        int mid=(si+sj)/2;
        buildTree(arr, 2*i+1, si, mid);//left
        buildTree(arr, 2*i+2, mid+1, sj);//right
        tree[i]=Math.max(tree[2*i+1],tree[2*i+2]);
        //Math.min for minimum ST
    }
    public static int getMaxUtil(int i,int si,int sj,int qi,int qj){
        if(qj<si||qi>sj){//no overlap
            return Integer.MIN_VALUE;
        }
        else if(si>=qi&&sj<=qj){//complete overlap
            return tree[i];
        }
        else{//partial overlap
            int mid=(si+sj)/2;
            int left=getMaxUtil(2*i+1,si,mid,qi,qj);//left
            int right=getMaxUtil(2*i+2,mid+1,sj,qi,qj);//right
            return Math.max(left,right);
        }
    }
    public static int getMax(int[] arr,int qi,int qj){
        int n= arr.length;
        return getMaxUtil(0,0,n-1,qi,qj);
    }
    public static void updateMax(int[] arr,int idx,int newVal){
        int n= arr.length;
        arr[idx]=newVal;
        updateMaxUtil(0,0,n-1,idx,newVal);
    }
    public static void updateMaxUtil(int i,int si,int sj,int idx,int newVal){
        //if idx is not in range-non overlapping
        if(idx>sj||idx<si){
            return;
        }
        //leaf node
        if(si==sj){
            tree[i]=newVal;
        }
        if(si!=sj){//non-leaf node
            tree[i]=Math.max(tree[i],newVal);
            int mid=(si+sj)/2;
            updateMaxUtil(2*i+1, si, mid, idx,newVal);//left
            updateMaxUtil(2*i+2, mid+1, sj, idx,newVal);//right
        }
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8};
        int n=arr.length;
        init(n);
        buildTree(arr,0,0,n-1);
        for(int i=0;i<tree.length;i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        System.out.println(getSum(arr,2,5));
        updateArr(arr,2,2);
        System.out.println(getSum(arr,2,5));
        buildMaxTree(arr,0,0,n-1);
        for(int i=0;i<tree.length;i++) {
            System.out.print(tree[i]+" ");
        }
        System.out.println();
        int max=getMax(arr,2,5);
        System.out.println("max is :"+max);
        updateMax(arr,2,20);
        max=getMax(arr,2,5);
        System.out.println("max is :"+max);
    }
}
