package DSAinJava.DivideAndConq;

public class AllocatePages {
    public int findPages(int[] pages,int n,int students) {
        if(students>n) return -1;//not possible to allocate books to every student
        int low=pages[0];
        int high=0;
        int res=-1;
        for(int page : pages){
            low=Math.min(low,page);
            high+=page;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(validAllocationPossible(pages,students,mid)){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }
    private boolean validAllocationPossible(int[] pages,int students,int mid){
        int allotedStudents=1;
        int currPages=0;
        for(int page:pages){
            if(page>mid) return false;
            if(currPages+page>mid){//new student
                allotedStudents++;
                currPages=page;
                if(allotedStudents>students) return false;
            }
            else{
                currPages+=page;
            }
        }
        return true;
    }
}
