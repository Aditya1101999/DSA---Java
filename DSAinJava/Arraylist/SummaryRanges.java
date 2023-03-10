package Arraylist;
import java.util.*;
public class SummaryRanges {
    private Set<Integer> numbers;

    public SummaryRanges() {
        numbers = new TreeSet<>();//treeset stores data in a sorted manner
    }
    //O(log n)
    public void addNum(int value) {
        numbers.add(value);
    }
    //O(n)
    public int[][] getIntervals() {
        List<int[]> interval = new ArrayList<>();
        for (int n : numbers) {
            int size = interval.size();
            //last element of interval+1
            if (size > 0 && interval.get(size - 1)[1] + 1 == n) {
                interval.get(size - 1)[1] = n;
            } else {//create new interval
                interval.add(new int[]{n, n});
            }
        }
        return interval.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();
        int value=2;
        obj.addNum(value);
        int[][] param_2 = obj.getIntervals();
    }
}
