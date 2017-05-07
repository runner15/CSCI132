package Maze;
import java.io.*; //Filereader library
/**
 * @author Runner15
 */
public class File {
    public String string;
    public String[] array = new String[12]; //Length of maze
    public char[][] mazeArray;
    public File() {
        String file = "maze.txt"; //Inport maze file
        String line = null;
        int i = 0;
        try {
            FileReader fileReader = new FileReader(file);

            try (
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while ((line = bufferedReader.readLine()) != null) {
                    //System.out.println(line);
                    line = line.replaceAll(" ",""); //Removes normal whitespace
                    line = line.replaceAll("\uFEFF",""); //Removes weird whitespace
                    array[i] = line; //Puts line into array
                    i++;
                }
            }         
        }
        catch(FileNotFoundException e) {
            System.out.println(
                "Unable to open file '" + 
                file + "'");                
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    public char[][] getMaze() { //Puts String array into 2d char array
        mazeArray = new char[array.length][array[1].length()];
        for(int i=0;i<array.length;i++) { //Length of array
            for(int j=0;j<array[i].length();j++) { //Length of each line
                mazeArray[i][j] = array[i].charAt(j);
            }
        }
        /*
        for(int i=0;i<array.length;i++) {
            for(int j=0;j<array[i].length();j++) {
                System.out.print(mazeArray[i][j]);
            }
            System.out.println();
        }
        */
        return mazeArray;
    }
}
