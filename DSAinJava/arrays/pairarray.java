package arrays;
public class pairarray {
    public static void pairs_in_array(int numbers[]){
        int TP=0;
        //1ST NUMBER
        for(int i=0;i< numbers.length;i++ ){
            //2ND NUMBER
            for(int j=i+1;j< numbers.length;j++){
                System.out.print("("+numbers[i]+","+numbers[j]+")");
                TP++;
            }
            System.out.println();
        }
        System.out.println("total pairs are "+TP);


    }
    public static void main(String args[]) {
        int numbers[] = {2, 4, 6, 8, 10};
        pairs_in_array(numbers);
    }

}
