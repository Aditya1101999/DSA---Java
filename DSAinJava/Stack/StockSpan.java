package Stack;
import java.util.*;
public class StockSpan {
    Stack<int[]>st;//prices,span days

    public StockSpan() {
        st=new Stack<>();
    }

    public int next(int price) {//using classes and objects
        int span=1;
        while(!st.isEmpty() && price>=st.peek()[0]){
            span+=st.pop()[1];
        }
        st.push(new int[]{price,span});
        return span;
    }
    public static void stockSpan(int[] stocks , int[] span){
        Stack<Integer> s=new Stack<>();
        span[0]=1;
        s.push(0);
//calculating span for each day
        for(int i=1;i< stocks.length;i++){
            int currPrice=stocks[i];
            //finding previous high
            while(!s.isEmpty() && currPrice>=stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i]=i+1;
            }
            else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }
            //pushing our index into stack
            s.push(i);
        }
    }
    public static void main(String[] args){
        int[] stocks={100,80,60,70,60,85,100};
        int[] span=new int[stocks.length];
        stockSpan(stocks,span);

        for(int i=0;i< span.length;i++){
            System.out.println(span[i]+" ");
        }
    }
}
