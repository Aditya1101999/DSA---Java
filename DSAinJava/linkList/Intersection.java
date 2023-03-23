import java.util.*;

public class Intersection {
    public static class Node{
        int data;
        Node next;
        public Node(int data){//constructor
            this.data=data;
            this.next=null;
        }
    }
    public Node getIntersectionNode(Node head1,Node head2){
        while(head2!=null){
            Node temp=head1;
            while(temp!=null){
                if(temp==head2){
                    return head2;
                }
                temp=temp.next;
            }
            head2=head2.next;
        }
        return null;
    }
    int intersectPoints(Node head1, Node head2)
    {
        HashSet<Node> visitedNodes = new HashSet<>();
        Node temp = head1;

        while(temp != null) {
            visitedNodes.add(temp);
            temp = temp.next;
        }

        temp = head2;
        while(temp != null) {
            if(visitedNodes.contains(temp)) {
                return temp.data;
            }
            temp = temp.next;
        }

        return -1;
    }
    int intersectPoint(Node head1, Node head2)
    {
        int len1 = length(head1);
        int len2 = length(head2);

        int diff = Math.abs(len1 - len2);

        if(len1 > len2) {
            while(diff-- > 0) {
                head1 = head1.next;
            }
        } else {
            while(diff-- > 0) {
                head2 = head2.next;
            }
        }

        while(head1 != null && head2 != null) {
            if(head1 == head2) {
                return head1.data;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return -1;
    }

    int length(Node node) {
        int len = 0;
        while(node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public static void main(String[] args){
        Intersection list=new Intersection();
        Node head1, head2;
        head1=new Node(10);
        head2=new Node(3);

        Node newNode=new Node(6);
        head2.next=newNode;
        newNode=new Node(9);
        head2.next.next=newNode;
        newNode=new Node(15);
        head1.next=newNode;
        head2.next.next.next=newNode;
        newNode=new Node(30);
        head1.next.next=newNode;

        Node intersectionpoint=list.getIntersectionNode(head1,head2);
        if(intersectionpoint==null){
            System.out.println("not intersecting");
        }
        else{
            System.out.println("intersection point "+intersectionpoint.data);
        }




    }
}
