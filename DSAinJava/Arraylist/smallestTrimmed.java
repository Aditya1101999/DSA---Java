package DSAinJava.Arraylist;
import java.util.*;
public class smallestTrimmed {
    static class Pair{
        String key;
        Integer value;
        Pair(String key,Integer value){
            this.key=key;
            this.value=value;
        }
        public String getKey(){
            return key;
        }
        public int getValue(){
            return value;
        }
    }
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n=nums.length;
        int m=queries.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int kSmallest=queries[i][0];
            int trim=queries[i][1];
            List<Pair>list=getStringsSortedOrder(nums,trim);
            ans[i]=list.get(kSmallest-1).getValue();//0-based indexing
        }
        return ans;
    }
    private List<Pair> getStringsSortedOrder(String[] nums,int trim){
        List<Pair>list=new ArrayList<>();
        int n=nums.length;
        int m=nums[0].length();
        for(int i=0;i<n;i++){
            StringBuilder trimmed=new StringBuilder(nums[i].substring(m-trim));
            while(trimmed.length()>0){
                if(trimmed.charAt(0)=='0'){
                    trimmed.deleteCharAt(0);
                }
                else break;
            }
            list.add(new Pair(trimmed.toString(),i));
        }
        list.sort((a, b) -> {
            String x = a.getKey();
            String y = b.getKey();

            if (x.length() != y.length()) {
                return x.length() - y.length();
            }

            if (x.equals(y)) {//lower index
                return a.getValue() - b.getValue();
            }
            return x.compareTo(y);
        });
        return list;
    }
}
