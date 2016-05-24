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

    //insert at the end
    //find a node right before the headnode
    void insertAtEnd(CircularList headNode, CircularList nodeToInsert) {
        CircularList currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null) {
            headNode = nodeToInsert;
        } else {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
        }
    }

    //insert at head
    // first, let the nodeToInsert point to itself
    // then let it point to the head, and use the getNext function to get the node right before the headnode
    // let the pointer of the last node to point at nodeToInsert
    void insertAtHead(CircularList headNode, CircularList nodeToInsert) {
        CircularList currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        //set a pointer to itself
        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null) {
            headNode = nodeToInsert;
        } else {
            nodeToInsert.setNext(headNode);
            currentNode.setNext(nodeToInsert);
            headNode = nodeToInsert;
        }

    }

    //find the last node
    //find the node before the last node, and let it point to head
    void deleteLastNode(CircularList headNode) {
        CircularList temp = headNode;
        CircularList currentNode = headNode;
        //when the list is empty
        if (headNode == null) {
            System.out.println("list is empty");
            return;
        }
        while (currentNode.getNext() != headNode) {
            temp = currentNode;
            currentNode = currentNode.getNext();
        }
        currentNode = null;
        return;
    }

    void deleteHead(CircularList headNode) {
        CircularList temp = headNode;
        CircularList currentNode = headNode;
        if (headNode == null) {
            System.out.println("List is empty");
            return;
        }
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        currentNode.setNext(headNode.getNext());
        headNode = headNode.getNext();
        temp = null;
        return;

    }


}
