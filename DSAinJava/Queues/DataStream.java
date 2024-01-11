package DSAinJava.Queues;
public class DataStream {
    //we can also use a queue and a map to store k elements and keep track of their frequencies
    private final int value;
    private final int k;
    private int count;
    public DataStream(int value, int k) {
        this.value=value;
        this.k=k;
        this.count=0;
    }

    public boolean consec(int num) {
        count= (num==value) ? count+1 : 0;
        return count>=k;
    }
}
