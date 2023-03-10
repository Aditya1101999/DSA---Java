package Stack;
import java.util.*;
public class DecodeString {
    public static String decode(String str){
        //storing frequency
        Stack<Integer>counts=new Stack<>();
        //storing characters
        Stack<StringBuilder> result=new Stack<>();
        StringBuilder res=new StringBuilder();
        int count=0;
//travesing complete string with characters
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
//we have to get the no.s until we are having a numeric digit
//and (str.charAt(i)-'0') gives current number
                count=count*10+(c-'0');
                }
            else if(c=='['){
                counts.push(count);
                result.push(res);
                //reseting the values
                count=0;
                res=new StringBuilder();
            }
            else if(c==']'){
                StringBuilder temp=res;
                //frequency of most inner string part
                int freq=counts.pop();
                res=result.pop();
 //temp is appended in res until freq=0, thus decoding it
                while(freq>0){
                    res.append(temp);
                    freq--;
                }
                count=0;//reseting value again
            }

            else{//character
                res.append(c);
            }
        }
        return res.toString();
    }
    public static void main(String args[]) {
        String str = "3[b2[ca]]";
        System.out.println(decode(str));
    }
}
