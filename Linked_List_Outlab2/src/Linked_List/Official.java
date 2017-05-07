package Linked_List;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Runner15
 */
public class Official {
    public String string;
    public String[] array1;
    public String[] array2;
    public int N,k,m;
    public Node k_node,m_node;
    ArrayList<Integer> choosen = new ArrayList();
    ArrayList<Integer> removed = new ArrayList();
    ArrayList<Integer> printOrder = new ArrayList();
    public LinkedList ll;
    
    public Official()
    { 
        ll = new LinkedList();
    }
    
    public void readFile() 
    {
        String file = fileName();
        //String file = "input.txt"; //Uncomment if you don't want to type in file name everytime
        String line = null;
        try {
            FileReader fileReader = new FileReader(file);

            try (
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                int i = 0;
                while ((line = bufferedReader.readLine()) != null) {
                    //System.out.println(line);
                    string = line;
                    if(i==0)
                    {
                        array1 = string.split(" ");
                    }
                    else if(i==1)
                    {
                        array2 = string.split(" ");
                    }
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
    public String fileName()
    {
        String name;
        System.out.print("What is the file name(without .txt) ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        return name+".txt";
    }
    public void setVariables() 
    {
        //A leading whitespace was added, so I had to use replace() to get rid of it
        N = Integer.parseInt(array1[0].replace("\uFEFF", ""));
        k = Integer.parseInt(array1[1].replace("\uFEFF", ""));
        m = Integer.parseInt(array1[2].replace("\uFEFF", ""));  
    }
    public void createList() 
    {
        for (int j=0;j<N;j++)
        {
            ll.insert(j+1);
        }
        k_node = ll.start;
        m_node = ll.end;
    }
    public void createFile()
    {
        try{
            PrintWriter writer = new PrintWriter("LinkedListProgram.txt", "UTF-8");
             writer.println("Program 4");
             writer.println("---------\n");
             writer.println("N = "+N+", k = "+k+", m = "+m+"\n");
             writer.println("Output");
             writer.println("------");
            for(int i=0;i<printOrder.size();i++)
            {
                if(printOrder.get(i) == 1)
                {
                    writer.println(choosen.get(i));
                }
                else
                {
                    writer.print(choosen.get(i)+" ");
                    writer.println(choosen.get(i+1));
                    i++;
                }
            }
            writer.println("\nEnd of Program 4");
            writer.close();
        } catch (IOException e) {
           // do something
        }
    }
    public void goAround()
    {
        int size = ll.getSize();
        int newk = (k%size); //Makes it so it does not loop around the list more than once
        int newm = (m%size); //Makes it so it does not loop around the list more than once
        for (int l=0;l<newk-1;l++) //Starts counting at current node
        {
            k_node = k_node.getNext();
        }
        for (int o=0;o<newm-1;o++) //Starts counting at current node
        {
            m_node = m_node.getPrev();
        }
        choose(k_node, m_node);
    }
    public void choose(Node ink, Node inm) 
    {
        if (ink == inm)
        {
            choosen.add(ink.getNum());
            printOrder.add(1);
            m_node = m_node.getPrev();
            k_node = k_node.getNext();
            ll.remove(ink);
        }
        else
        {
            choosen.add(ink.getNum());
            choosen.add(inm.getNum());
            printOrder.add(2);
            printOrder.add(2);
            k_node = k_node.getNext();
            if (k_node == inm)
            {
                m_node = m_node.getPrev();
                k_node = k_node.getNext();
                ll.remove(ink);
                ll.remove(inm);
            }
            else
            {
                ll.remove(ink);
                m_node = m_node.getPrev();
                ll.remove(inm);
            }
        }
    }
    public boolean checkList()
    {
        return ll.getSize() > 0;
    }
}