package DSAinJava.arrays;
import java.util.Arrays;
public class CountElements {
    public static int[] countElements(int a[], int b[], int n, int query[], int q) {
        int max=Arrays.stream(a).max().orElse(0);
        int[] freq=new int[max+1];
        for(int el : b){
            if(el<=max) freq[el]++;//elements larger than max will never occur in queries
        }
        for(int i=1;i<max+1;i++){
            freq[i]+=freq[i-1];
        }
        int[] result=new int[q];
        int index=0;
        for(int qu : query){
            result[index++]=freq[a[qu]];
        }
        return result;
    }
}
