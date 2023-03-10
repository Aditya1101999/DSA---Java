package Recursion;

public class RemoveDuplic {
    public static void removeDuplicates(String str,int idx,StringBuilder newStr,boolean[] track) {
        if (idx == str.length()) {
            System.out.println(newStr);
            return;
        }
        //work to be done
        char ch = str.charAt(idx);
        if (track[ch - 'a']) {//duplicate
            removeDuplicates(str, idx + 1, newStr, track);

        } else {
            track[ch - 'a'] = true;
            removeDuplicates(str, idx + 1, newStr.append(ch), track);
        }
    }
    public static void main(String[] args){
        String str="hhhhhhaaaappppppyyyyyyyy";
        removeDuplicates(str,0,new StringBuilder(),new boolean[26]);

    }
}
