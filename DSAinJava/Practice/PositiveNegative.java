package DSAinJava.Practice;

public class PositiveNegative {
    private static int[] postiveNegativeSwap(int[] arr) {
        int left = 0;
        int n = arr.length;
        int right = n - 1;

        while (left <= right) {
            //also if both left and right are -ve , this will work
            while (left < n && arr[left] < 0) {
                left++;
            }
            //also if both left and right are +ve , this will work
            while (right >= 0 && arr[right] >= 0) {
                right--;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return arr;
    }
        public static void main (String[]args){
            int[] arr = {1, -2, -3, 4, 5, -6};
            int[] newArr = postiveNegativeSwap(arr);
            for (int el : newArr) {
                System.out.print(el + " ");
            }
        }
    }

