package linkList;

public class DoubleLinkList {
    public static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    //add
    public void addFirst(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){//linked list is empty
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {//linked list is empty
            head = tail = newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    //remove
    public int removeFirst(){
        if(head==null){
            System.out.println("linked list empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }
        int val=head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }
    public int removeLast() {
        if (head == null) {
            System.out.println("linked list empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val=tail.data;
        tail=tail.prev;
        tail.next=null;
        return val;
    }
    //print
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    //reverse
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;//updating tail value
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=prev;//updating prev

            prev=curr;
            curr=next;
        }
        head=prev;//curr is null , so node before curr is head
    }
    public static void main(String[] args){
        DoubleLinkList dll=new DoubleLinkList();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        dll.removeFirst();
        dll.print();
        dll.addLast(4);
        dll.removeLast();
        dll.reverse();
        dll.print();
        System.out.println("size is "+size);
    }
}
