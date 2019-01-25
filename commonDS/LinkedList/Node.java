package commonDS.LinkedList;

/**
 * Created by fame.issrani on 1/15/19.
 */
public class Node {
    public int data;
    public Node next;
    public Node prev;

    Node(int data) {
        this.data = data;
        next = null;
        prev = null;
    }
}
