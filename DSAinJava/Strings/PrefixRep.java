package DSAinJava.Strings;

public class PrefixRep {
    public String reversePrefix(String word, char ch) {
        int n=word.length();
        int left=0;
        int right=0;
        char[] arr=word.toCharArray();
        while(right<n){
            if(arr[right]==ch){
                while(left<=right){
                    char temp=arr[left];
                    arr[left]=arr[right];
                    arr[right]=temp;
                    left++;
                    right--;
                }
                return new String(arr);
            }
            right++;
        }
        return word;
    }
}
