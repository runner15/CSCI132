package Stack;
/**
 * @author Runner15
 */
public class PixelRegion {
    int x,y; //Initialize coords
    int[][] check; //Initialize if checked array
    int checked; //Initialize if stack is checked variable
    
    public PixelRegion(int y, int x, int[][] check) {
        this.x = x; //Sets x to x
        this.y = y; //Sets y to y
        //Sets places to check
        this.check = new int[][]{{-1,-1,0},{-1,0,0},{-1,1,0},{0,1,0},{1,1,0},{1,0,0},{1,-1,0},{0,-1,0}}; 
        checked = 0; //Makes stack not checked yet
    }
    public int[] getPixel(int w,int h) {
        int[] returnArr = {y,x}; //Initialize return array
        for (int[] check1 : check) { //Loops through check array
            if (check1[2] == 0) { //Checks if check1 array value has not been checked
                checked = 0; //Sets stack as not checked
                returnArr[0] = y+check1[0];
                returnArr[1] = x+check1[1];
                if(returnArr[0]<0 || returnArr[0]>h-1)  //Makes sure array does not go out of bounds
                    returnArr[0] = y; //Sets to original value if out of bounds
                if(returnArr[1]<0 || returnArr[1]>w-1) //Makes sure array does not go out of bounds
                    returnArr[1] = x; //Sets to original value if out of bounds
                check1[2] = 1; //Sets individual pixel as checked
                return returnArr;
            }
            checked = 1; //Sets whole stack object as checked
        }
        return returnArr;
    }
}
