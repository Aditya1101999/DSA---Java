package DSAinJava.Strings;

public class VersionNo {
    public int compareVersion(String version1, String version2) {
        //can't directly use split(".") because it will treat the regex as any character
        String[] version1arr=version1.split("\\.");
        String[] version2arr=version2.split("\\.");

        int n1=version1arr.length;
        int n2=version2arr.length;

        int i=0;
        int j=0;

        while(i<n1 && j<n2){
            int val1=Integer.parseInt(version1arr[i]);
            int val2=Integer.parseInt(version2arr[j]);
            i++;
            j++;

            if(val1>val2) return 1;
            else if(val2>val1) return -1;
        }

        while(i<n1){//n1>n2
            int val1=Integer.parseInt(version1arr[i]);
            i++;

            if(val1>0) return 1;
        }
        while(j<n2){//n2>n1
            int val2=Integer.parseInt(version2arr[j]);
            j++;

            if(val2>0) return -1;
        }
        return 0;//versions are equal
    }
}
