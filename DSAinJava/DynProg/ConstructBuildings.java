package DSAinJava.DynProg;

public class ConstructBuildings {
    /*
     int number_of_way(int space,int N){
       if(N==0) return 1;
       if(space)
           return (number_of_way(1,N-1)+number_of_way(0,N-1));
       else
           return (number_of_way(1,N-1));
   }
    */
    public int TotalWays(int n)
    {
        //for n=1
        long countB=1;
        long countS=1;
        int mod=(int)1e9+7;
        for(int i=2;i<=n;i++){
            long newBuildingCount=countS;//only option
            long newSpaceCount=(countB+countS)%mod;//append all previous combinations

            countB=newBuildingCount;
            countS=newSpaceCount;
        }
        long result=countB+countS;
        return (int)(result%mod*result%mod);
    }
}
