package DSAinJava.Strings;

public class CustomSort {
    public String customSortString(String order, String s) {
        int[] freq=new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder ans=new StringBuilder();
        for(char c : order.toCharArray()){
            while(freq[c-'a']>0){
                ans.append(c);
                freq[c-'a']--;
            }
        }
        for(int i=0;i<26;i++){
            char c = (char)('a' + i);
            while(freq[c-'a']>0){
                ans.append(c);
                freq[c-'a']--;
            }
        }
        return ans.toString();
//     int[] sortingOrder = new int[26];
//     for (int i = 0; i < order.length(); i++) {
//         char c = order.charAt(i);
//         sortingOrder[c - 'a'] = i;
//     }

//     Character[] chars = new Character[s.length()];
//     for (int i = 0; i < s.length(); i++) {
//         chars[i] = s.charAt(i);
//     }

//     Arrays.sort(chars, (c1, c2) -> Integer.compare(sortingOrder[c1 - 'a'], sortingOrder[c2 - 'a']));

//     StringBuilder sb = new StringBuilder(chars.length);
//     for (char c : chars) {
//         sb.append(c);
//     }

//     return sb.toString();
    }
}
