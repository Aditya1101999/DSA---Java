package DSAinJava.Strings;

public class ValidNumber {
    public boolean isNumber(String s) {
        s=s.trim();//remove left & right spaces
        if(s==null || s.length()==0) return false;
        boolean numberSeen=false;
        boolean eSeen=false;
        boolean decimalSeen=false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            switch(c){
                case '.':
                    if(decimalSeen||eSeen) return false;
                    decimalSeen=true;
                    break;
                case 'E':
                case 'e':
                    if(eSeen||!numberSeen) return false;//e123 is not valid
                    eSeen=true;
                    numberSeen=false;//a number must appear after e
                    break;
                case '+':
                case '-':
                    if(i!=0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E')) return false;
                    numberSeen=false;//must have a number after the sign
                    break;
                default:
                    if(!Character.isDigit(c)) return false;
                    numberSeen=true;
                    break;
            }
        }
        return numberSeen;//a number must be there to be valid
    }
}
