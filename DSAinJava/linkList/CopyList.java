package linkList;
public class CopyList {
    public static class Node {
        int val;
        Node next;
        Node random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node iter=head;
        Node front;
        while(iter!=null){//copying nodes
            front=iter.next;
            Node copy= new Node(iter.val);
            iter.next=copy;
            copy.next=front;
            iter=front;
        }
        iter=head;
        while(iter!=null){//placing random pointers
            if(iter.random!=null){
                iter.next.random=iter.random.next;
            }
            iter=iter.next.next;
        }
        iter=head;
        Node dummy= new Node(0);
        Node copy=dummy;
        while(iter!=null){//placing next pointers
            front=iter.next.next;//original list
            copy.next=iter.next;//duplicate list
            iter.next=front;
            copy=copy.next;
            iter=iter.next;
        }
        return dummy.next;
    }
}
