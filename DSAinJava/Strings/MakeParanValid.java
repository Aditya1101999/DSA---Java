package DSAinJava.Strings;

public class MakeParanValid {
    public String minRemoveToMakeValid(String s) {
        int extraClosingBrace=0;
        StringBuilder temp=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            char c=s.charAt(i);
            if(c==')'){
                temp.append(c);
                extraClosingBrace++;
            }
            else if(c=='('){
                if(extraClosingBrace>0){
                    extraClosingBrace--;
                    temp.append(c);
                }
            }
            else{
                temp.append(c);
            }
        }
        int extraOpeningBrace=0;
        StringBuilder ans=new StringBuilder();
        for(int i=temp.length()-1;i>=0;i--){
            char c=s.charAt(i);
            if(c=='('){
                ans.append(c);
                extraOpeningBrace++;
            }
            else if(c==')'){
                if(extraOpeningBrace>0){
                    extraOpeningBrace--;
                    ans.append(c);
                }
            }
            else{
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
