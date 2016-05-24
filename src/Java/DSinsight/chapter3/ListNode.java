package DSinsight.chapter3;

/**
 * Created by Jilliankim on 10/30/15.
 */
//this listnode saves int types (linked list of integers)
public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    //receive a linked list as a parameter, and count nodes
    int listLength(ListNode headNode) {
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode.getNext();
        }
        return length;
    }

    //list starts at the index of 0
    ListNode insertNode(ListNode headNode, ListNode nodeToInsert, int position) {
        //if position is bigger than the length
        if (listLength(headNode) > position) {
            return headNode;
        }
        //if the headnode is empty
        if (headNode == null) {
            return nodeToInsert;
        }
        //insert at head
        if (position == 0) {
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            int count = 0;
            ListNode previousNode = headNode;
            while (count < position) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);

        }
        return headNode;
    }

    ListNode deleteNode(ListNode headNode, int position) {
        //see if it's valid position
        int size = listLength(headNode);
        if (position >= size || position < 0) {
            return headNode;
        }
        //deleting from head
        if (position == 0) {
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        } else {
            int count = 0;
            ListNode previousNode = headNode;
            while (count < position) {
                count++;
                previousNode.getNext();
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }


}
