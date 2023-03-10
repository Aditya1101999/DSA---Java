package BinaryTree;

public class SegmentTree {
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
