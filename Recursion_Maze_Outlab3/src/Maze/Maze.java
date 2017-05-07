package Maze;
/**
 * @author Runner15
 */
public class Maze {
    char[][] arr;
    int[] start = new int[2];
    int dir;
    public Maze() {
        File file = new File(); //Inport maze file
        arr = file.getMaze();
        start = getStart(arr); //Get start on outer edge of maze
        int xLoc = start[1]; int yLoc = start[0]; int handLocationX = xLoc+1; int handLocationY = yLoc;
        solve(arr, xLoc, yLoc, handLocationX, handLocationY);
        System.out.println("FUCKING WORK");
    }
    public boolean solve(char[][] arr,int xLoc, int yLoc, int handLocationX, int handLocationY) {
        System.out.println("--------------\n"); //Prints dotted line between each maze iteration
        //*
        for(int i=0;i<arr.length;i++) { //Prints out maze
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]); //Prints out each char in maze
            }
            System.out.println(); //Prints new line after maze line was printed
        }
        //*/
        //System.out.println(xLoc+" "+yLoc+" "+handLocationX+" "+handLocationY);
        dir = getDir(xLoc,yLoc,handLocationX,handLocationY);
        if(isDone(yLoc,xLoc)) {
            return true;
        }
        if(dir == 0) {
            //System.out.println("Direction 0");
            if(arr[yLoc][xLoc+1] == '.' || arr[yLoc][xLoc+1] == 'X') {
                arr[yLoc][xLoc] = 'X';
                //System.out.println("DIR 0,1");
                //System.out.println(xLoc+" "+yLoc+" "+handLocationX+" "+handLocationY);
                //System.out.println((xLoc+1)+" "+yLoc+" "+handLocationX+" "+(handLocationY+1));
                solve(arr, xLoc+1, yLoc, handLocationX, handLocationY+1);
            }
            if(arr[yLoc-1][xLoc] == '.' || arr[yLoc-1][xLoc] == 'X') {
                arr[yLoc][xLoc] = 'X';
                //System.out.println("DIR 0,2");
                solve(arr, xLoc, yLoc-1, handLocationX, handLocationY-1);
            }
            arr[yLoc][xLoc] = 'X';
            //System.out.println("DIR 0,3");
            solve(arr, xLoc, yLoc, handLocationX-1, handLocationY-1);
        } 
        else if(dir == 1) {
            //System.out.println("Direction 1");
            if(arr[yLoc+1][xLoc] == '.' || arr[yLoc+1][xLoc] == 'X') {
                arr[yLoc][xLoc] = 'X';
                //System.out.println("DIR 1,1");
                solve(arr, xLoc, yLoc+1, handLocationX-1, handLocationY);
            }
            if(arr[yLoc][xLoc+1] == '.' || arr[yLoc][xLoc+1] == 'X') {
                arr[yLoc][xLoc] = 'X';
                //System.out.println("DIR 1,2");
                solve(arr, xLoc+1, yLoc, handLocationX+1, handLocationY);
            }
            arr[yLoc][xLoc] = 'X';
            //System.out.println("DIR 1,3");
            solve(arr, xLoc, yLoc, handLocationX+1, handLocationY-1);
        }
        else if(dir == 2) {
            //System.out.println("Direction 2");
            if(arr[yLoc][xLoc-1] == '.' || arr[yLoc][xLoc-1] == 'X') {
                arr[yLoc][xLoc] = 'X';
                //System.out.println("DIR 2,1");
                solve(arr, xLoc-1, yLoc, handLocationX, handLocationY-1);
            }
            if(arr[yLoc+1][xLoc] == '.' || arr[yLoc+1][xLoc] == 'X') {
                arr[yLoc][xLoc] = 'X';
                //System.out.println("DIR 2,2");
                solve(arr, xLoc, yLoc+1, handLocationX, handLocationY+1);
            }
            arr[yLoc][xLoc] = 'X';
            //System.out.println("DIR 2,3");
            solve(arr, xLoc, yLoc, handLocationX+1, handLocationY+1);
        }
        else if(dir == 3) {
            //System.out.println("Direction 3");
            if(arr[yLoc][xLoc-1] == '.' || arr[yLoc][xLoc-1] == 'X') {
                arr[yLoc][xLoc] = 'X';
                //System.out.println("DIR 3,1");
                solve(arr, xLoc-1, yLoc, handLocationX, handLocationY+1);
            }
            if(arr[yLoc-1][xLoc] == '.' || arr[yLoc-1][xLoc] == 'X') {
                arr[yLoc][xLoc] = 'X';
                //System.out.println("DIR 3,2");
                solve(arr, xLoc, yLoc-1, handLocationX-1, handLocationY);
            }
            arr[yLoc][xLoc] = 'X';
            //System.out.println("DIR 3,3");
            solve(arr, xLoc, yLoc, handLocationX-1, handLocationY+1);
        }
        return true;
    }

    public boolean isDone(int xLoc, int yLoc) { //Check if F is next to current location
        if((xLoc-1)<0) { xLoc = 1; } if((xLoc+1)>arr[0].length) { xLoc = xLoc-1; }
        if((yLoc-1)<0) { yLoc = 1; } if((yLoc+1)>arr.length) { yLoc = yLoc-1; }
        return arr[xLoc+1][yLoc] == 'F' || arr[xLoc-1][yLoc] == 'F' || arr[xLoc][yLoc+1] == 'F' || arr[xLoc][yLoc+1] == 'F';
    }
    public int getDir(int xLoc, int yLoc, int handLocationX, int handLocationY) {
        int dirRet;
        if((xLoc - handLocationX) == 0) {
           if((yLoc - handLocationY) == 1) {
               dirRet = 3; //Set direction to 3
           } else {
               dirRet = 1; //Set direction to 1
           }
        } else {
            if((xLoc - handLocationX) == 1) {
               dirRet = 2; //Set direction to 2
           } else {
               dirRet = 0; //Set direction to 0
           }
        }
        return dirRet;
    }
    public int[] getStart(char[][] arr) { //Checks all outer spaces for the '.'
        int[] startArr = new int[2];
        while(true) {
            for (int j=0;j<arr[0].length;j++) {
                if(arr[0][j] == '.') {
                    startArr[0] = 0; startArr[1] = j;
                    break;
                }
                if(arr[arr.length-1][j] == '.') {
                    startArr[0] = arr.length-1; startArr[1] = j;
                    break;
                }
            }
            for (int i=0;i<arr.length;i++) {
                if(arr[i][0] == '.') {
                    startArr[0] = i; startArr[1] = 0;
                    break;
                }
                if(arr[arr[0].length-1][i] == '.') {
                    startArr[0] = i; startArr[1] = arr[0].length-1;
                    break;
                }
            }
            break;
        }
        return startArr;
    }
}
