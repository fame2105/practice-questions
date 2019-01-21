package leetcode;

import commonDS.LinkedList.LinkedList;
import commonDS.LinkedList.Node;

public class AddTwoNumbers {
    public static LinkedList addNum(LinkedList l1, LinkedList l2) {
        LinkedList l3 = new LinkedList();
        Node head1 = l1.head;
        Node head2 = l2.head;
        int carry = 0;
        int sum = 0;
        while (head1!= null || head2!= null) {
            int x = (head1 != null) ? head1.data : 0;
            int y = (head2 != null) ? head2.data : 0;
            sum = carry + x + y;
            carry = sum / 10;
            l3.insertFront(l3, (sum % 10));
            if(head1!=null){
                head1 = head1.next;
            }
            if(head2!=null){
                head2 = head2.next;
            }
        }
        if (carry != 0) {
            l3.insertLast(l3, carry);
        }
        return l3;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertFront(l1, 3);
        l1.insertFront(l1, 2);
        l1.insertFront(l1, 1);

        LinkedList l2 = new LinkedList();
        l2.insertFront(l2, 1);
        l2.insertFront(l2, 9);


        l1.printLinkedList(l1);
        l2.printLinkedList(l2);
        l1.printLinkedList(addNum(l1,l2));
    }
}

/*
123   .... 321
91    ....  19
04              340*/
