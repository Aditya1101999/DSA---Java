package DSAinJava.Strings;

public class EquivalentStrings {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0;
        int j=0;

        int left=0;
        int right=0;
        while(i<word1.length && j<word2.length){
            if(word1[i].charAt(left)!=word2[j].charAt(right)){
                return false;
            }
            left++;
            right++;
            if(left==word1[i].length()){
                i++;
                left=0;
            }
            if(right==word2[j].length()){
                j++;
                right=0;
            }
        }
        return i==word1.length && j==word2.length;
    }

}
