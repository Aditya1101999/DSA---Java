package DSAinJava.BinaryTree;
import java.util.*;
public class SmallerNoAfterSelf {
    class SegmentTreeNode{
        private int start,end;
        private SegmentTreeNode left,right;
        private int count;
        SegmentTreeNode(int start,int end){
            this.start=start;
            this.end=end;
            this.left=null;
            this.right=null;
            this.count=0;
        }
    }
    private SegmentTreeNode buildTree(int start,int end){
        if(start>end){
            return null;
        }
        SegmentTreeNode res=new SegmentTreeNode(start,end);
        if(start==end){
            return res;
        }
        int mid=start+(end-start)/2;
        res.left=buildTree(start,mid);
        res.right=buildTree(mid+1,end);

        return res;
    }
    private void update(SegmentTreeNode root,int index){//updating frequency of each element in tree
        if(root==null){
            return;
        }
        if(root.start==index && root.end==index){//leaf node
            root.count++;
            return;
        }
        int mid=root.start+(root.end-root.start)/2;
        if(index<=mid){
            update(root.left,index);
        }
        else{
            update(root.right,index);
        }
        root.count=root.left.count+root.right.count;
    }
    private int countRange(SegmentTreeNode root,int start,int end){
        if(root==null || start>end){
            return 0;
        }
        if(root.start==start && root.end==end){
            return root.count;
        }
        int mid=root.start+(root.end-root.start)/2;
        if(end<=mid){
            return countRange(root.left,start,end);
        }
        else if(start>mid){
            return countRange(root.right,start,end);
        }
        return countRange(root.left,start,mid)+countRange(root.right,mid+1,end);
    }
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length==0){
            return new ArrayList<>();
        }
        int[] count=new int[nums.length];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int el:nums){
            min=Math.min(min,el);
            max=Math.max(max,el);
        }
        SegmentTreeNode root=buildTree(min,max);

        for(int i=nums.length-1;i>=0;i--){//we have to find smaller elements in right
            update(root,nums[i]);//update the new element in tree
            count[i]=countRange(root,min,nums[i]-1);
        }
        List<Integer>ans=new ArrayList<>();
        for(int el:count){
            ans.add(el);
        }
        return ans;
    }
}
