package DSAinJava.Strings;

public class SimilarCharDel {
    public int minimumLength(String s) {
        int prefix=0;
        int suffix=s.length()-1;
        //no intersection and characters must be same
        while(prefix<suffix && s.charAt(prefix)==s.charAt(suffix)){
            char c=s.charAt(prefix);
            while(s.charAt(prefix)==c && prefix<suffix) prefix++;
            while(s.charAt(suffix)==c && prefix<=suffix) suffix--;
        }
        return suffix-prefix+1;
    }
}
