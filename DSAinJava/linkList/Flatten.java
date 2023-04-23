package linkList;

public class Flatten {
    public static class Node{
        int data;
        Node prev;
        Node next;
        Node bottom;
        public Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }
    public static Node flatten(Node root){//for singly linked list
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
    public Node flatten2(Node head) {//for doubly linked list
        if(head==null) return null;

        Node curr=head;
        while(curr!=null){
            if(curr.bottom!=null){
                //store reference of curr.next
                Node next=curr.next;
                curr.next=flatten2(curr.bottom);
                curr.next.prev=curr;
                curr.bottom=null;
                //move to terminal node in child's level
                while(curr.next!=null){
                    curr=curr.next;
                }
                //connect terminal node to previously stored next
                if(next!=null){
                    curr.next=next;
                    next.prev=curr;
                }
            }
            curr=curr.next;
        }
        return head;
    }
}
