package DSAinJava.Practice;

public class MissingnO {
    private static int missing(int[] arr,int n){
        int i=0;
        while(i<arr.length){
            if(arr[i]<arr.length && arr[i]-1!=i){
                swap(arr,arr[i]-1,i);
            }
            else{
                i++;
            }
        }
        for(i=0;i<arr.length;i++){
            if(arr[i]!=i+1) return i+1;
        }
        return n;
    }
    static void swap(int[] arr,int i,int correctIndex){
        int temp=arr[i];
        arr[i]=arr[correctIndex];
        arr[correctIndex]=temp;
    }
    public static void main(String[] args) {
        int[] arr={5,1,2,3};
        int n=5;
        System.out.println(missing(arr,n));

    }
}
