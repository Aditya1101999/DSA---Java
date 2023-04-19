package linkList;

public class MergeKSorted {
    public static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next=null;
        }
    }
    public static Node sortedMerge(Node a,Node b){
        Node result=null;
        if(a==null){
            return b;
        }
        else if(b==null){
            return a;
        }
        //finding minimum node
        if(a.data<=b.data){
            result=a;
            //recur for next node in list
            result.next=sortedMerge(a.next,b);
        }
        else{
            result=b;
            result.next=sortedMerge(a,b.next);
        }
        return result;
    }
    //divide and conquer-more optimized
    public static Node partion(Node[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            Node l1=partion(lists,s,q);
            Node l2=partion(lists,q+1,e);
            return sortedMerge(l1,l2);
        }else
            return null;
    }
    public Node sortList(Node head) {
        if(head==null||head.next==null) return head;

        Node slow=head;
        Node fast=head.next;//when no cycle , fast initalized like this to avoid overflow
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node left=head;
        Node right=slow.next;
        slow.next=null;

        left=sortList(left);
        right=sortList(right);

        return sortedMerge(left,right);
    }
    public static Node mergeKLists(Node arr[], int last) {
        //last is the no. of times we need to merge , i.e.k-1
        while(last!=0) {
            int i = 0;
            int j = last;
            while (i < j) {
                //merging 1st and last list into one
                arr[i] = sortedMerge(arr[i], arr[j]);
                i++;
                j--;
                if (i >= j) {
                    last = j;
                }
            }
        }
        return arr[0];
    }
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    public Node insertionSortList(Node head) {
        if(head==null||head.next==null) return head;
        Node preInsert;
        Node toInsert;
        Node dummy=new Node(-5001);
        dummy.next=head;
        Node curr=head;
        while(curr.next != null){
            if(curr.data<=curr.next.data){
                curr=curr.next;
            }
            else{
                toInsert=curr.next;
                preInsert=dummy;
                while(preInsert.next.data<toInsert.data){
                    preInsert=preInsert.next;
                }
                curr.next=toInsert.next;//curr.next.next
                toInsert.next=preInsert.next;
                preInsert.next=toInsert;
            }
        }
        return dummy.next;
    }

    public static void main(String args[]) {
        int k = 3;
        int n = 4;
        Node arr[] = new Node[k];
        arr[0] = new Node(1);
        arr[0].next = new Node(3);
        arr[0].next.next = new Node(5);
        arr[0].next.next.next = new Node(7);

        arr[1] = new Node(2);
        arr[1].next = new Node(4);
        arr[1].next.next = new Node(6);
        arr[1].next.next.next = new Node(8);

        arr[2] = new Node(0);
        arr[2].next = new Node(9);
        arr[2].next.next = new Node(10);
        arr[2].next.next.next = new Node(11);

        Node head = mergeKLists(arr, k - 1);
        printList(head);
    }
}
