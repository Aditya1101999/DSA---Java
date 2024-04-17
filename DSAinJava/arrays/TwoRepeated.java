package DSAinJava.arrays;

public class TwoRepeated {
    public int[] twoRepeated(int[] arr, int n) {
        int[] ans = new int[2];
        for (int el : arr) {
            int index = Math.abs(el);
            if (arr[index] > 0) {
                arr[index] = -arr[index];
            } else {
                if (ans[0] == 0) ans[0] = index;
                else ans[1] = index;
            }
        }
        return ans;
    }
}
