package Linked_List;
/**
 * @author Runner15
 */
public class LinkedList {
    protected Node start;
    protected Node end;
    public int size;
    
    public LinkedList()
    {
        start = null;
        end = null;
    }
    public void insert(int val)
    {
        Node newNode = new Node(val);
        if (start == null)
        {
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            start = newNode;
            end = start;
        }
        else
        {
            newNode.setPrev(end);
            end.setNext(newNode);
            start.setPrev(newNode);
            newNode.setNext(start);
            end = newNode;    
        }
        size++;
    }
    public void remove(Node n)
    {
        Node prev = n.getPrev();
        Node next = n.getNext();
        if (n == start)
        {
            start = next;
        }
        if (n == prev)
        {
            end = prev;
        }
        prev.setNext(next);
        next.setPrev(prev);
        n.setPrev(null);
        n.setNext(null);
        size--;
    }
    public void print()
    {
        System.out.print("\nCircular Doubly Linked List = ");
        Node current = start;
        if (start.getNext() == start) 
        {
            System.out.print(start.getNum()+ " <-> "+current.getNum()+ "\n");
            return;
        }
        System.out.print(start.getNum()+ " <-> ");
        current = start.getNext();
        while (current.getNext() != start) 
        {
            System.out.print(current.getNum()+ " <-> ");
            current = current.getNext();
        }
        System.out.print(current.getNum()+ " <-> ");
        current = current.getNext();
        System.out.print(current.getNum()+ "\n");
    }
    public int getSize()
    {
        return size;
    }
    public Node around(int amt, int dir) {
        for (int i=0;i<amt;i++)
        {
            if(dir==1)
            {
                
            }      
        }
        return start;
    }
}
