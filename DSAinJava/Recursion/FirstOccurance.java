package Recursion;

public class FirstOccurance {
    public static int firstKey(int array[],int key,int i){
        //base condition
        if(i== array.length){
            return -1;
        }
        if(array[i]==key){
            return i;
        }
        return firstKey(array, key, i+1);
    }
    public static void main(String args[]){
        int array[]={8,3,6,9,5,10,2,5,3};
        System.out.println(firstKey(array,5,0));
    }
}

