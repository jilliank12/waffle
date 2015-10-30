package DSinsight.chapter3;

/**
 * Created by Jilliankim on 10/30/15.
 */
//class for doubly linked list
public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    //get length of DLL - same as singly linked list
    int getLength(DLLNode headNode) {
        int count = 0;
        DLLNode currentNode = headNode;
        while (currentNode != null) {
            count++;
        }
        return count;
    }

    //insert node in DLL
    DLLNode insertNode(DLLNode headNode, DLLNode nodeToInsert, int position) {
        //check if headnode is null
        if (headNode == null) {
            return nodeToInsert;
        }
        //check if position is less than the actual length
        int size = getLength(headNode);
        if (position < size || position >= size) {
            System.out.println("invalid position");
            return nodeToInsert;
        }
        //inserting at the head
        if (position == 0) {
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else {
            int count = 0;
            DLLNode previousNode = headNode;
            while (position < size) {
                count++;
                previousNode = previousNode.getNext();
            }
            DLLNode currentNode = previousNode.getNext();
            currentNode.setPrevious(nodeToInsert);
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }
    //delete node in DLL
    DLLNode deleteNode(DLLNode headNode, int position) {
        int size = getLength(headNode);
        if (position < 0 || position >= size || size < 1) {
            System.out.println("invalid size");
            return headNode;
        }
        //delete at head
        if (position == 0) {
            DLLNode currentNode = headNode.getNext();
            headNode = null;
            currentNode.setPrevious(null);
            return currentNode;
        } else {
            int count = 0;
            DLLNode previousNode = headNode;
            while (count < position) {
                previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            DLLNode temp = currentNode.getNext();
            previousNode.setNext(temp);
            temp.setPrevious(previousNode);
//            currentNode.setNext(null);
//            currentNode.setPrevious(null);
            currentNode = null;
        }
        return headNode;

    }
}
