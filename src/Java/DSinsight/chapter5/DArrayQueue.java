package DSinsight.chapter5;

/**
 * Created by Jilliankim on 11/1/15.
 * Dynamic Array Queue
 */

public class DArrayQueue {
    private int front;
    private int rear;
    private int capacity;
    private int[] array;

    //default constructor
    private DArrayQueue() {
        capacity = 1;
        front = -1;
        rear = -1;
        array = new int[capacity];
    }

    public static DArrayQueue createQueue() {
        return new DArrayQueue();
    }

    public boolean isEmpty() {
        return (front == 1);
    }

    private boolean isFull() {
        return ((rear + 1) % capacity == front);
    }

    public int getQueueSize() {
        if (front == -1) {
            return 0;
        }
        int size = (capacity - front + rear + 1) % capacity;
        if (size == 0) {
            return capacity;
        } else {
            return size;
        }
    }

    private void resizeQueue() {
        int initCapacity = capacity;
        capacity *= 2;
        int[] oldArray = array;
        array = new int[this.capacity];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }
        if (rear < front) {
            for (int i = 0; i < front; i++) {
                array[i+initCapacity] = this.array[i];
                array[i] = 0;
            }
            rear = rear + initCapacity;
        }
    }

    public void enQueue(int data) {
        if (isFull()) {
            resizeQueue();
        }
        rear = (rear + 1) % capacity;
        array[rear] = data;
        if (front == -1) {
            front = rear;
        }
    }

    public int deQueue() {
        int data = 0;
        if (isEmpty()) {
            System.out.println("queue empty");
        } else {
            data = array[front];
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
        }
        return data;
    }
}
