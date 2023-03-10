package arrays;
import java.util.*;
import java.util.function.DoubleToIntFunction;
public class creation {
    public static void main(String args[]){
        int marks[]=new int[50];
        int numbers[]={1,2,3};
        Scanner sc=new Scanner(System.in);
        //int phy=sc.nextInt();
        marks[0]=sc.nextInt();//phy
        marks[1]=sc.nextInt();//chem

        System.out.println(marks[0]);
        System.out.println(marks[1]);

        marks[1]=100;
        marks[1]=marks[1]-1;
        System.out.println(marks[1]);

        int percentage=(marks[0]+marks[1])/2;
        System.out.println(percentage+"%");

        //for length
        System.out.println(marks.length);
    }
}
