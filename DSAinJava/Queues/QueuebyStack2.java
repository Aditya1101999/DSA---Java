package Queues;

public class QueuebyStack2 {
    static class Queue {
        static java.util.Stack<Integer> s1 = new java.util.Stack<>();
        static java.util.Stack<Integer> s2 = new java.util.Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        public static void add(int data) {
            s1.push(data);
        }
        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue empty");
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }
        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue empty");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
