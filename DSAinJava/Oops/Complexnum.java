package Oops;

class Complexnum{
    int real,imaginary;
    //constructor
    Complexnum(int r,int i){
        real=r;
        imaginary=i;
    }
    static Complexnum addComp(Complexnum c1,Complexnum c2){
        return new Complexnum((c1.real+c2.real),(c1.imaginary+c2.imaginary));
    }
    static Complexnum subComp(Complexnum c1,Complexnum c2){
        return new Complexnum((c1.real-c2.real),(c1.imaginary-c2.imaginary));
    }
    static Complexnum prodComp(Complexnum c1,Complexnum c2) {
        return new Complexnum(((c1.real * c2.real) - (c1.imaginary * c2.imaginary)), ((c1.real * c2.real) + (c1.imaginary * c2.imaginary)));
    }
    public void printComp(){
        System.out.println(real+"+"+imaginary+"i");
    }

}
class Solution{
    public static void main(String args[]){
        Complexnum c=new Complexnum(4,5);
        Complexnum d=new Complexnum(9,4);
        Complexnum e=Complexnum.addComp(c,d);
        Complexnum f=Complexnum.subComp(c,d);
        Complexnum g=Complexnum.prodComp(c,d);
        e.printComp();
        f.printComp();
        g.printComp();

    }
}
