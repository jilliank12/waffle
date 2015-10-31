package DSinsight.chapter3;

/**
 * Created by Jilliankim on 10/31/15.
 */
//list class for circular list
public class CircularList {
    private int data;
    private CircularList previous;
    private CircularList next;

    public CircularList(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(CircularList next) {
        this.next = next;
    }

    public CircularList getNext() {
        return next;
    }

    public void setPrevious(CircularList previous) {
        this.previous = previous;
    }

    public CircularList getPrevious() {
        return previous;
    }

    //count length of circular list
    int getLength(CircularList headNode) {
        int length = 0;
        CircularList currentNode = headNode;
        while (headNode != null) {
            length++;
            currentNode.getNext();
            //break when the node is back to head node
            if (currentNode == headNode) {
                break;
            }
        }
        return length;
    }

    //prints out the list
    void printList(CircularList headNode) {
        CircularList CLLNode = headNode;
        while (CLLNode != null) {
            System.out.print(CLLNode.getData() + " -> ");
            CLLNode = CLLNode.getNext();
            if (CLLNode == headNode) break;
        }
        System.out.println("(" + CLLNode.getData() + ")headNode");


    }








}
