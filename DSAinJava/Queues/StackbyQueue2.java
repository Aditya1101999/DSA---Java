package Queues;
import java.util.LinkedList;
import java.util.Queue;

public class StackbyQueue2 {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();
        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }
        public static void push(int data) {
            q2.add(data);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            // swap the names of two queues
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;
        }
        public static int pop() {
            if(q1.isEmpty()){
                return -1;
            }
            int top=q1.remove();
            return top;
        }

        public static int peek() {
            int top = q1.remove();
            return top;
        }
    }
        public static void main(String[] args) {
            Stack s = new Stack();
            s.push(1);
            s.push(2);
            s.push(3);
            while (!s.isEmpty()) {
                System.out.println(s.peek());
                s.pop();
            }
        }
    }


