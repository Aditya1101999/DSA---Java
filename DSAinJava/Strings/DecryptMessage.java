package DSAinJava.Strings;

public class DecryptMessage {
    public static String decrypt(String word) {
        int valueToBeSubtracted=1;
        StringBuilder ans=new StringBuilder();
        for(char c : word.toCharArray()){
      /*
      from 2nd character onwards :
          valueToBeSubtracted+=value[c-1]
       for encryption:
          enc[c]=c+valueToBeSubtracted-26m
       for decyption:
          c=enc[c]-valueToBeSubtracted+26m
      */
            int asciiValue=c-valueToBeSubtracted;
            while(asciiValue<'a') asciiValue+=26;
            valueToBeSubtracted+=asciiValue;
            ans.append((char)asciiValue);
        }
        return ans.toString();
    }
}
