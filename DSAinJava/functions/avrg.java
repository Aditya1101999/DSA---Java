package functions;

public class avrg {
    public static double average(double a,double b,double c){
        double avg=(a+b+c)/3;
        return avg;
    }
    public static void main(String args[]){
        System.out.println("avergae is "+average(1,2,3));
    }
}

