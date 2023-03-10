package basics;

import java.util.ArrayList;
import java.util.Set;

public class code {
    public static void main(String[] args){
        int sum=0;
        int maxsum=0;
        int j=0;
        ArrayList<Integer>a=new ArrayList<>();
        for(int i=0;i<100;i++){
            for( j=1;j<i;j++){
                if((i+j)%7!=0){
                    sum=i+j;
                    a.add(sum);
                }
            }
        }
        System.out.println(a);
        System.out.println(a.size());
    }
}
