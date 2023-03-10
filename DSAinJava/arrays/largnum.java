package arrays;
public class largnum {
    public static int largestNumber(int[] numbers) {
        int largest = Integer.MIN_VALUE;//-infinity
        int smallest = Integer.MAX_VALUE;//+infinity

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                largest = numbers[i];
            }
            if (numbers[i] < smallest) {
                smallest = numbers[i];
            }
        }
        System.out.println("smallest value is "+smallest);
        //since only one value can be returned once
        return largest;


    }

    public static void main(String args[]) {
        int numbers[] = {1, 2, 6, 3, 5};
        System.out.println("largest value is "+largestNumber(numbers));
    }
}
