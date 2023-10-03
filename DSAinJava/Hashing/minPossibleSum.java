package DSAinJava.Hashing;

public class minPossibleSum {
    public int minimumPossibleSum(int n, int target) {
        // long sum=0;
        // long num=1;
        // int i=1;
        // Set<Integer>set=new HashSet<>();
        // while(i<n){
        //     if(!set.contains(target-num)){
        //         set.add(num);
        //         sum+=num;
        //         i++;
        //     }
        //     num++;
        // }
        long sum = 0, num = 1 , i=0;
        while (i<n) {
            //dont add any number which can form a pair with the no.s smaller than target
            if (num >= target || num<=target/2) {
                sum += num;
                i++;
            }
            num++;
        }
        return (int) (sum % 1000000007);
    }
}
