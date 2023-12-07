package DSAinJava.arrays;

public class CalMoney {
    public int totalMoneyBrute(int n) {
        int mondayMoney=1;
        int result=0;
        while(n>0){
            int money=mondayMoney;
            for(int i=1;i<=Math.min(n,7);i++){
                result+=money;
                money++;
            }
            n-=7;
            mondayMoney++;
        }
        return result;
    }
    public int totalMoney(int n) {
        int firstWeekMoney=28;//1+2+...7
        int completeWeeks=n/7;
        int lastWeekMoney=firstWeekMoney+(completeWeeks-1)*7;//last term=a+(n-1)*d

        int completeWeeksMoney=completeWeeks*(firstWeekMoney+lastWeekMoney)/2;//sum=n*(first term + last term)/2

        int remainingDays=n%7;
        int mondayMoney=1+completeWeeks;//week 1-> $1 , week n+1 ->$n+1

        for(int i=1;i<=remainingDays;i++){//remainingDays = {1-6}
            completeWeeksMoney+=mondayMoney++;

        }
        return completeWeeksMoney;

    }
}
