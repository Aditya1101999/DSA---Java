package DSAinJava.linkList;
public class LinkedList {
    public static class Node{
        int data;
        Node next;
        Node() {}
        public Node(int data){//constructor
            this.data=data;
        }
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;//by default 0
    //making non-static methods since we won't call
    //functions directly,call using LL
    //creating some non-static methods for operations
    Node insertAtBeginning(Node head, int x)
    {
        Node node=new Node(x);
        if(head==null) return node;
        node.next=head;
        return node;
        // head=node;
        // return head;
    }

    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
        Node node=new Node(x);
        if(head==null){
            return node;
        }
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=node;
        return head;
    }
    public void addFirst(int data){
        //create new node
        Node newNode=new Node(data);
        size++;
        if(head==null){//linked list is empty
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        size++;
        if(head==null){//linked list is empty
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public void print(){
        if(head==null){
            System.out.println("linked list is empty");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void addMiddle(int index,int data){
        if(index==0){//head value should be changed here
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;

        while(i<index-1){
            temp=temp.next;
            i++;
        }
        //when i=index-1,temp(previous node)
        newNode.next=temp.next;
        temp.next=newNode;
    }
    public int removeFirst(){
        if(size==0){
            System.out.println("linked list is empty");
            return Integer.MIN_VALUE;//-infinity
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val=head.data;
        head=head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(size==0){
            System.out.println("linked list is empty");
            return Integer.MIN_VALUE;//-infinity
        }
        else if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        //temp: i=size-2
        Node temp=head;
        for(int i=0;i<size-2;i++){
            temp=temp.next;
        }
        int val=tail.data;//or temp.next.data
        temp.next=null;
        tail=temp;
        size--;
        return val;
    }
    public void deleteAlternate (Node head){
        Node temp=head;
        while(temp!=null&&temp.next!=null){
            temp.next=temp.next.next;
            temp=temp.next;
        }
    }
    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy=new Node();
        Node temp=dummy;
        int carry=0;
        while(l1!=null||l2!=null||carry==1){
            int sum=0;
            if(l1!=null){
                sum+=l1.data;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.data;
                l2=l2.next;
            }
            sum+=carry;
            Node node=new Node(sum%10);
            carry=sum/10;
            temp.next=node;
            temp=temp.next;
        }
        return dummy.next;
    }
    public int iterativeSearch(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){//key found
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }
    public int helper(Node head,int key){
        //base case
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        //calling for rest linked list
        int index=helper(head.next,key);
        if(index==-1){//element not found in rest list also
            return -1;
        }
        //if element found , add one index value for each
        //recursive call
        return index+1;
    }
    public int recursiveSearch(int key){

        return helper(head,key);
    }
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;//updating tail value
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;//curr is null , so node before curr is head
    }
    public Node reverseKGroup(Node head, int k) {
        if(head==null||k==1) return head;
        Node dummy=new Node();
        dummy.next=head;
        Node prev=dummy,curr=dummy,next=dummy;
        int count=0;
        while(curr.next!=null){//count no. of nodes
            curr=curr.next;
            count++;
        }
        while(count>=k){
            curr=prev.next;
            next=curr.next;
            for(int i=1;i<k;i++){
                curr.next=next.next;
                next.next=prev.next;
                prev.next=next;
                next=curr.next;
            }
            prev=curr;
            count-=k;
        }
        return dummy.next;
    }
    public static Node sortList(Node head) {
        Node zero=new Node();
        Node zeroIt=zero;
        Node one=new Node();
        Node oneIt=one;
        Node two=new Node();
        Node twoIt=two;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                zeroIt.next=temp;
                zeroIt=zeroIt.next;

            }
            else if(temp.data==1){
                oneIt.next=temp;
                oneIt=oneIt.next;
            }
            else{
                twoIt.next=temp;
                twoIt=twoIt.next;
            }
            temp=temp.next;
        }
        zeroIt.next=one.next;
        oneIt.next=two.next;
        twoIt.next=null;
        return zero.next;
    }
    public void removeNthFromLast(int n){
        //calculate size
        int sz=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            sz++;
        }
        //check if head has to be deleted
        if(n==sz){
            head=head.next;//remove first
            return;
        }
        //else sz-n
        int i=1;
        int idx=sz-n;
        Node pre=head;
        while(i<idx){
            pre=pre.next;
            i++;
        }
  //previous node of the node to be deleted reached
        pre.next=pre.next.next;
        return;
    }

    public void deleteNode(Node node) {
        Node nextNode=node.next;
        node.data=nextNode.data;
        node.next=node.next.next;
        nextNode.next=null;
    }
    public Node findMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null &&fast.next!=null){
            //odd and even cases respectively
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow;//slow is middle
    }
    public Node insertGreatestCommonDivisors(Node head) {
        if(head==null || head.next==null){
            return head;
        }
        Node curr=head;
        while(curr.next!=null){
            int a=curr.data;
            int b=curr.next.data;
            int gcd=gcd(a,b);
            Node node=new Node(gcd);
            node.next=curr.next;
            curr.next=node;
            curr=curr.next.next;
        }
        return head;
    }
    public int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    Node mergeResult(Node node1, Node node2) {//merge two sorted lists from last
        if(node1==null && node2==null) return null;
        Node res=null;
        while(node1!=null && node2!=null){
            if(node1.data<=node2.data){
                Node temp=node1.next;
                node1.next=res;
                res=node1;
                node1=temp;
            }
            else{
                Node temp=node2.next;
                node2.next=res;
                res=node2;
                node2=temp;
            }
        }
        while(node1!=null){
            Node temp=node1.next;
            node1.next=res;
            res=node1;
            node1=temp;
        }
        while(node2!=null){
            Node temp=node2.next;
            node2.next=res;
            res=node2;
            node2=temp;
        }
        return res;
    }
    public Node deleteMiddle(Node head) {
        if(head.next==null) return null;
        Node slow=head;
        Node fast=head.next.next;
        while(fast!=null &&fast.next!=null){
            //odd and even cases respectively
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        slow.next=slow.next.next;
        return head;
    }
    public boolean checkPalindrome(){
        //base case
        if(head==null||head.next==null){
            return true;
        }
        //find middle element
        Node midNode=findMid(head);
        //reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //right half head
        Node right=prev;
        Node left=head;
        //check left half and right half
        while(right!=null){
            if(left.data !=right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }
//    private void createCycle(Node head){
//        Node curr=head;
//        while(curr.next!=null){
//            curr=curr.next;
//        }
//        curr.next=head;
//    }
    public static boolean isCycle(){
        Node slo=head;
        Node fas=head;
        //for even and odd linked list
        while(fas!=null && fas.next!=null){
            slo=slo.next;//+1
            fas=fas.next.next;//+1
            if(slo==fas){
                return true;//cycle exists
            }
        }
        return false;
//        int count=1;->to count no. of nodes in cycle
//        if(slo!=fas) return 0;
//        while(slo.next!=fas){
//            slo=slo.next;
//            count++;
//        }
//        return count
    }
    public static void removeCycle(){
        //detect cycle
        Node slo=head;
        Node fas=head;
        boolean cycle=false;
        //for even and odd linked list
        while(fas!=null && fas.next!=null) {
            slo = slo.next;//+1
            fas = fas.next.next;//+1
            if (slo == fas) {
                cycle = true;
                break;
            }
        }
        if(!cycle){
            return;
        }
//        //find cycle point
//        slo=head;
//        Node prev=null;
//        while(slo!=fas){
//            prev=fas;
//            slo=slo.next;
//            fas=fas.next;
//        }
//        //remove cycle
//        prev.next=null;//last node
        if(cycle){
            slo=head;
            if(slo!=fas){
                while(slo.next!=fas.next){
                    slo=slo.next;
                    fas=fas.next;
                }
            }
            else{//if slow and fast equal
                while(fas.next!=slo){
                    fas=fas.next;
                }
            }
            fas.next=null;
        }
    }
    public Node detectCycle(Node head) {
        if(head==null||head.next==null){
            return null;
        }
        Node slo=head;
        Node fas=head;
        //for even and odd linked list
        while(fas!=null && fas.next!=null) {
            slo = slo.next;//+1
            fas = fas.next.next;//+1
            if(slo==fas){
                slo=head;
                while(slo!=fas){
                    slo=slo.next;
                    fas=fas.next;
                }
                return slo;
            }
        }
        return null;
    }
    public Node rotateRight(Node head, int k) {
        if(head==null||head.next==null||k==0) return head;
        Node curr=head;
        int count=1;
        while(curr.next!=null){
            curr=curr.next;
            count++;
        }
        curr.next=head;
        k%=count;//removing nearest multiples to avoid same steps
        k=count-k;
        while(k-->0){
            curr=curr.next;
        }
        head=curr.next;
        curr.next=null;
        return head;
    }
    public Node mergeSort(Node head){
        //base case
        if(head==null ||head.next==null){
            //list is already sorted
            return head;
        }
        //find mid
        Node mid=getMid(head);
        //left and right merge sort
        Node rightHead=mid.next;
        mid.next=null;
        Node left=mergeSort(head);
        Node right=mergeSort(rightHead);
        //merge
        return merge(left,right);
    }
    private Node getMid(Node head){
        Node slow=head;
        Node fast=head;
        while(fast!=null &&fast.next!=null){
            //odd and even cases respectively
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow;//slow is middle
    }
    private Node merge(Node left,Node right){
        Node mergedLL=new Node(-1);
        Node temp=mergedLL;

        while(left!=null && right!=null){
            if(left.data<=right.data){
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }
            else{//if(left.data>right.data)
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }
        while (left != null) {
            temp.next=left;
            left=left.next;
            temp=temp.next;
        }
        while(right!=null){
            temp.next=right;
            right=right.next;
            temp=temp.next;
        }
        //in order to remove dummy node -1;
        return mergedLL.next;
    }
    public void zigZag(){
        //find mid
        Node slow=head;
        Node fast=head.next;
        while(fast!=null &&fast.next!=null){
            //odd and even cases respectively
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        Node mid=slow;//slow is middle
        //reverse 2nd half
        Node curr=mid.next;
        mid.next=null;//dividing the list into two
        Node prev=null;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        Node left=head;
        Node right=prev;
        Node nextLeft , nextRight;
        //zig-zag merge
        while(left!=null &&right!=null){
            nextLeft=left.next;
            left.next=right;
            nextRight=right.next;
            right.next=nextLeft;

            left=nextLeft;
            right=nextRight;
        }
    }
    public void skipMDeleteN(Node head,int m,int n){
        Node curr=head;

        while(curr!=null){
            //skipping m
            for(int i=1;i<m &&curr!=null;i++){
                curr=curr.next;
            }
            if(curr==null){
                return;
            }
            Node newNode=curr.next;
            //deleting n
            for(int i=1;i<n&&newNode!=null;i++){
                newNode=newNode.next;
            }
            //connecting currnode and new node
            curr.next=newNode;
           // curr=newNode;(only one element will be deleted then)
        }
    }
    public void swappingNodes(int x,int y){
        if(x==y){
            return;
        }
        Node prevX=null;
        Node currX=head;
        //finding x
        while(currX!=null &&currX.data!=x){
            prevX=currX;
            currX=currX.next;
        }
        Node prevY=null;
        Node currY=head;
        //finding y
        while(currY!=null &&currY.data!=y){
            prevY=currY;
            currY=currY.next;
        }
        if(currX==null||currY==null){
            return;
        }
        //swapping
        if(prevX!=null){
            prevX.next=currY;
        }
        else{
            head=currY;
        }
        if(prevY!=null){
            prevY.next=currX;
        }
        else{
            head=currX;
        }
        Node temp=currX.next;
        currX.next=currY.next;
        currY.next=temp;
    }
    public void segregateEvenOdd() {
        Node end = head;
        Node prev = null;
        Node curr = head;
        //end value of LL obtained
        while (end.next != null) {
            end = end.next;
        }
        Node nEnd = end;
        //adding odd elements in front of linked list
        //and deleting them from their initial position
        while (curr.data % 2 != 0 && curr != end) {
            nEnd.next = curr;
            curr = curr.next;
            nEnd.next.next = null;
            nEnd = nEnd.next;
        }
        if (curr.data % 2 == 0) {
            head = curr;//first value initialized
            while (curr != end) {
                if (curr.data % 2 == 0) {//even elements
                    //no changes
                    prev = curr;
                    curr = curr.next;
                } else {//odd element
                    //skip odd element
                    prev.next = curr.next;
                    curr.next = null;
                    //storing odd element in front of last even element
                    nEnd.next = curr;
                    nEnd = curr;
                    curr = prev.next;
                }
            }
        }
        else {//first element is odd
            prev=curr;
        }
        //swapping done and last element of original list
        //is not even
        if(nEnd!=end && end.data%2!=0){
            //skip odd element
            prev.next =end.next;
            end.next = null;
            //storing odd element in front of last even element
            nEnd.next =end;
        }
    }

    public static void main(String[] args){
        LinkedList ll=new LinkedList();
        //ll.head=new Node(1);
        //ll.head.next=new Node(2);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.addMiddle(2,3);
        ll.print();

        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.print();
        System.out.println("size is "+ll.size);
        int key=4;
        System.out.println(key+" found at index "+ll.iterativeSearch(key));
        System.out.println(key+" found at index "+ll.recursiveSearch(key));

        ll.reverse();
        ll.print();

        ll.removeNthFromLast(2);
        ll.print();
        ll.addFirst(5);
        ll.print();
        System.out.println(ll.checkPalindrome());
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.print();
        ll.head=ll.mergeSort(ll.head);
        ll.print();

        ll.zigZag();
        ll.print();
        ll.skipMDeleteN(head,2,2);
        ll.print();

        ll.addMiddle(1,2);
        ll.print();

        ll.swappingNodes(2,4);
        ll.print();
        ll.segregateEvenOdd();
        ll.print();
    }
}
