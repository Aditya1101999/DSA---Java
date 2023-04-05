package arrays;
public class binsear {
    public static int binary_search(int numbers[],int key){
        int start=0,end= numbers.length-1;

        while(start<=end) {
            int mid = (start + end) / 2;

            //comparisons
            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] > key) {//left
                end = mid - 1;
            } else {//right
                start = mid + 1;
            }
        }
        return -1;

    }
    public static void main(String args[]) {
        int[] numbers = {2, 4, 6, 8, 10, 12, 14, 16};
        int key = 10;
        int index = binary_search(numbers, key);
        if (index == -1) {
            System.out.println("element not found");

        } else {
            System.out.println("element found at " + index);
        }
    }
}

