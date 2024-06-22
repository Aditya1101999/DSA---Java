package DSAinJava.BitManipulation;

public class SwapNibbles {
    static int swapNibbles(int n) {
    int firstpartOfNibble=(n&15);//15 => 00001111 in binary
    int secondPartOfNibble=(n&240);//240=>11110000 in binary
    return (firstpartOfNibble<<4) | (secondPartOfNibble>>4);
}
}
