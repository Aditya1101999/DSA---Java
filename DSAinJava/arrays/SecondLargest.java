package DSAinJava.arrays;

public class SecondLargest {
    public static int secondLargest(int n,int[] arr){
        int max=arr[0];
        int secMax=Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                secMax=max;
                max=arr[i];
            }
            else if(max>arr[i] && arr[i]>secMax){
                secMax=arr[i];
            }
        }
        return secMax;
    }
    public int maxProductDifference(int[] nums) {
        int largest=0;
        int secondLargest=0;

        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;

        for(int el : nums){
            if(el>largest){
                secondLargest=largest;
                largest=el;
            }
            else if(el>secondLargest){
                secondLargest=el;
            }

            if(el<smallest){
                secondSmallest=smallest;
                smallest=el;
            }
            else if(el<secondSmallest){
                secondSmallest=el;
            }
        }
        return (largest*secondLargest)-(smallest*secondSmallest);
    }
    public int buyChoco(int[] prices, int money) {
        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;
        for(int price : prices){
            if(price<smallest){
                secondSmallest=smallest;
                smallest=price;
            }
            else if(price<secondSmallest){
                secondSmallest=price;
            }
        }
        int amount=money-(smallest+secondSmallest);
        return amount<0 ? money : amount ;
    }
}
