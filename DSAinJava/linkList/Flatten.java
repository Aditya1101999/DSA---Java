package linkList;

public class Flatten {
    public static class Node{
        int data;
        Node next;
        Node bottom;
        public Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }
    public static Node flatten(Node root){
        if(root==null||root.next==null) return root;
        //recur for the right node
        root.next=flatten(root.next);
        //coming back, merge the lists
        root=mergeTwoLists(root,root.next);
        return root;
    }
    private static Node mergeTwoLists(Node a,Node b){
        Node temp= new Node(0);
        Node res=temp;

        while(a!=null && b!=null){
            if(a.data<=b.data){
                temp.bottom=a;
                temp=temp.bottom;
                a=a.bottom;
            }
            else{
                temp.bottom=b;
                temp=temp.bottom;
                b=b.bottom;
            }
            if(a!=null) temp.bottom=a;
            else temp.bottom=b;
        }
        return res.bottom;
    }
}
