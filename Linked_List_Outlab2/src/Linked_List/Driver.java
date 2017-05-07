package Linked_List;
/**
 * @author Runner15
 */
public class Driver {
    public static void main(String[] args)
    {
        Official official = new Official();
        official.readFile();
        official.setVariables();
        official.createList();
        while(official.checkList())
        {
            official.goAround();
        }
        official.createFile();
    }
}