package Recursion;

public class TotOcc {
        public static void totOccur(int array[],int key,int i){
            //base condition
            if(i== array.length){
                return;
            }
            if(array[i]==key){
                System.out.print(i);
            }
            totOccur(array, key, i+1);


        }
        public static void main(String args[]){
            int array[]={3, 2, 4, 5, 6, 2, 7, 2, 2};
            totOccur(array,2,0);
        }


}
