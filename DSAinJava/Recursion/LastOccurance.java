package Recursion;

public class LastOccurance {
    public static int lastKey(int array[],int key,int i){
        //base condition
        if(i== array.length){
            return -1;
        }
        //forward check
        int isFound=lastKey(array, key, i+1);
        //-1 i.e.element does not exist in forward array
        if(isFound==-1 && array[i]==key){
            return i;
        }
        return isFound;
    }
    public static void main(String args[]){
        int array[]={8,3,6,9,5,10,2,5,3};
        System.out.println(lastKey(array,5,0));
    }
}


