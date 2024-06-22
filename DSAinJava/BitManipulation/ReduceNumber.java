package DSAinJava.BitManipulation;

public class ReduceNumber {
    public int numSteps(String s) {
    int operations=0;
    int carry=0;
    for(int i=s.length()-1;i>0;i--){
        if(((s.charAt(i)-'0')+carry)%2==1){
            operations+=2;
            carry=1;
        }
        else{
            operations++;
        }
    }
    return operations+carry;
}
}
