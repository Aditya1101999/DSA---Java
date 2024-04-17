package DSAinJava.BitManipulation;

public class AndInRange {
    public int rangeBitwiseAnd(int left, int right) {
        while(right>left){
            right&=(right-1);
        }
        return right;
        // int shifts=0;
        // while(left!=right){
        //     left>>=1;
        //     right>>=1;
        //     shifts++;
        // }
        // return left<<shifts;
    }
}
