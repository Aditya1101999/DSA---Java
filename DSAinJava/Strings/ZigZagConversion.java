package Strings;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        int n=s.length();
        StringBuffer[] sb=new StringBuffer[numRows];
        for(int j=0;j<numRows;j++){
            sb[j]=new StringBuffer();
        }
        int i=0;//for each character
        while(i<n){
            for(int j=0;j<numRows&&i<n;j++){
                sb[j].append(s.charAt(i++));//append the character at specified index
            }
            for(int j=numRows-2;j>=1&&i<n;j--){//going back
                sb[j].append(s.charAt(i++));
            }
        }
        for(int j=1;j<numRows;j++){
            sb[0].append(sb[j]);//add all at 0th index
        }
        return sb[0].toString();
    }
    public static void main(String[] args){
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }
}
