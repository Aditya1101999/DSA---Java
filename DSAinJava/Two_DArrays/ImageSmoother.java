package DSAinJava.Two_DArrays;

public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int m=img.length;
        int n=img[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                //for each cell
                int sum=0;
                int count=0;
                for(int x=i-1;x<=i+1;x++){
                    for(int y=j-1;y<=j+1;y++){
                        if(x>=0 && x<m && y>=0 && y<n){
                            //retrieving the first 8 bits where the original value was stored
                            sum+=img[x][y] & ((1<<8)-1);
                            count++;
                        }
                    }
                }//storing the answer values after the 8 rightmost bits
                img[i][j]|=(sum/count)<<8;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //discarding original values
                img[i][j]=img[i][j]>>8;
            }
        }
        return img;
    }
}
