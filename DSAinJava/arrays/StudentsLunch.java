package DSAinJava.arrays;

public class StudentsLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        int circularStudents=0;
        int squareStudents=0;
        for(int student : students){
            if(student==0) circularStudents++;
            else squareStudents++;
        }
        int n=sandwiches.length;
        for(int i=0;i<n;i++){
            if(sandwiches[i]==0){
                if(circularStudents==0) return n-i;
                else circularStudents--;
            }
            else{
                if(squareStudents==0) return n-i;
                else squareStudents--;
            }
        }
        return 0;
    }
}
