package Stack;

public class Linklist {
    static class Stack {
        public static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public static Node head = null;

        public static boolean isEmpty() {

            return head == null;
        }

        public void push(int data) {
            //similar to addfirst
            //the new pushed node will be the head of list
            Node newNode = new Node(data);
            //checking if list is empty
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop() {
            //similar to removefirst
            //the head node will be removed as top
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args){
        Stack s=new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
