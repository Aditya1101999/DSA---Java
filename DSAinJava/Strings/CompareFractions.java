package DSAinJava.Strings;

public class CompareFractions {
    String compareFrac(String str) {
        double val1=0.0;
        double val2=0.0;
        int a=0;
        int b=0;
        StringBuilder fraction1=new StringBuilder();
        StringBuilder fraction2=new StringBuilder();
        boolean numerator=true;
        for(char c : str.toCharArray()){
            if(c=='/'){
                fraction2.append(c);
                numerator=false;
            }
            else if(c==','){
                fraction1=fraction2;
                fraction2=new StringBuilder();
                val1=(double)a/b;
                a=b=0;
                numerator=true;
            }
            else if(Character.isDigit(c)){
                fraction2.append(c);
                if(numerator){
                    a=a*10+c-'0';
                }
                else{
                    b=b*10+c-'0';
                }
            }
        }
        val2=(double)a/b;
        if(val1==val2) return "equal";
        return (val1>val2) ? fraction1.toString() : fraction2.toString();
    }
}
