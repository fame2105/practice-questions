package commonDS.LinkedList;

/**
 * Created by fame.issrani on 1/15/19.
 */
public class LinkedList {
    public Node head;

    public void insertFront(LinkedList list, int data) {
        Node newNode = new Node(data);
        if (list.head == null) {
            list.head = newNode;
            return;
        }
        newNode.next = list.head;
        list.head = newNode;
    }

    public void insertLast(LinkedList list, int data) {
        Node newNode = new Node(data);
        if (list.head == null) {
            list.head = newNode;
            return;
        }
        Node currNode = list.head;
        while (currNode.next != null) {
            currNode = currNode.next;
        }
        newNode.next = null;
        currNode.next = newNode;
    }

    public void printLinkedList(LinkedList list) {
        if (list.head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node curr_node = list.head;
        while (curr_node != null) {
            System.out.print("\t" + curr_node.data);
            curr_node = curr_node.next;
        }
        System.out.println();
    }
}

