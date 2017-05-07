package Linked_List;
/**
 * @author Runner15
 */
public class Node {
    protected Node next, prev;
    private int num;
    
    public Node(int val)
    {
        next = null;
        prev = null;
        num  = val;
    }
    public Node(Node next, Node prev)
    {
        this.next = next;
        this.prev = prev;
    }
    public void setNext(Node next)
    {
        this.next = next;
    }
    public void setPrev(Node prev)
    {
        this.prev = prev;
    }
    public Node getNext()
    {
        return next;
    }
    public Node getPrev()
    {
        return prev;
    }
    public void setNum(int n)
    {
        num = n;
    }
    public int getNum()
    {
        return num;
    }
}
