package DSAinJava.arrays;

public class Collisions {
    public int countCollisions(String directions) {
        int right=0;
        int stationary=0;
        int collisions=0;
        for(char c : directions.toCharArray()){
            if(c=='R'){
                right++;
            }
            else if(c=='S'){
                collisions+=right;//all R cars will collide
                right=0;
                stationary=1;
            }
            else{//left
                if(right>0){
                    //left and right collision(2)+rest right will collide with the stationary car made by R and L collision
                    collisions+=2+(right-1);
                    right=0;
                    stationary=1;
                }
                else if(stationary==1){
                    collisions++;
                }
            }
        }
        return collisions;
    }
}
