package Queues;

public class Circular {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {//constructor
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            //we want to increase rear but
            //next space occupied by front
            return (rear + 1) % size == front;
        }

        public static void add(int data) {//add-0(1)
            if (isFull()) {
                System.out.println("queue full");
                return;
            }
            //add first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;

        }

        public static int remove() {//remove-0(1)
            if (isEmpty()) {
                System.out.println("no elements");
                return -1;
            }
            int result = arr[front];
            //last element deleted
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        public static int peek() {//o(1)
            if (isEmpty()) {
                System.out.println("no elements");
                return -1;
            }
            return arr[front];
        }
    }
        public static void main(String[] args) {
            Queue q = new Queue(3);
            q.add(1);
            q.add(2);
            q.add(3);
            System.out.println(q.remove());
            q.add(4);
            System.out.println(q.remove());
            q.add(5);
            while (!q.isEmpty()) {
                System.out.println(q.peek());
                q.remove();
            }
        }
    }

