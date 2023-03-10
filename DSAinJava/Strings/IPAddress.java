package Strings;
import java.util.*;
public class IPAddress {
    public static List<String> restoreIpAddresses(String s) {
        List<String>list=new ArrayList<>();
        int len=s.length();
        StringBuffer ip=new StringBuffer();

        for(int aLen=1;aLen<=3;aLen++){
            for(int bLen=1;bLen<=3;bLen++){
                for(int cLen=1;cLen<=3;cLen++){
                    int dLen=len-(aLen+bLen+cLen);

                    if(dLen>0&&dLen<=3){
                        int A=Integer.parseInt(s.substring(0,aLen));
                        int B=Integer.parseInt(s.substring(aLen,aLen+bLen));
                        int C=Integer.parseInt(s.substring(aLen+bLen,aLen+bLen+cLen));
                        int D=Integer.parseInt(s.substring(aLen+bLen+cLen));
                        if(A<=255&&B<=255&&C<=255&&D<=255){
                            ip.append(A).append(".").append(B).append(".").append(C).append(".").append(D);
                            if(ip.length()==len+3){
                                list.add(ip.toString());
                            }
                            ip=new StringBuffer();
                        }
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args){
        String s = "25525511135";
        System.out.println(restoreIpAddresses(s));
    }
}
