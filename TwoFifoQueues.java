package DataStructure2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class TwoFifoQueues {

    private Deque<Integer> leftQueue;
    private Deque<Integer> rightQueue;

    public TwoFifoQueues() {
        leftQueue = new ArrayDeque<>();
        rightQueue = new ArrayDeque<>();
    }

    // Add to front
    public void pushFront(int item) {
        leftQueue.addLast(item);
    }

    // Add to rear
    public void pushBack(int item) {
        rightQueue.addLast(item);
    }

    // Remove from front
    public int popFront() {
        try {
            if (leftQueue.isEmpty()) {
                while (!rightQueue.isEmpty()) {
                    leftQueue.addLast(rightQueue.removeLast());
                }
            }
            if (leftQueue.isEmpty()) {
                throw new NoSuchElementException("popFront from an empty deque");
            }
            return leftQueue.removeLast();
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return -1;  // Return a default value or handle the error appropriately
        }
    }

    // Remove from rear
    public int popBack() {
        try {
            if (rightQueue.isEmpty()) {
                while (!leftQueue.isEmpty()) {
                    rightQueue.addLast(leftQueue.removeLast());
                }
            }
            if (rightQueue.isEmpty()) {
                throw new NoSuchElementException("popBack from an empty deque");
            }
            return rightQueue.removeLast();
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return -1;  // Return a default value or handle the error appropriately
        }
    }

    // Peek front
    public int peekFront() {
        try {
            if (leftQueue.isEmpty()) {
                while (!rightQueue.isEmpty()) {
                    leftQueue.addLast(rightQueue.removeLast());
                }
            }
            if (leftQueue.isEmpty()) {
                throw new NoSuchElementException("peekFront from an empty deque");
            }
            return leftQueue.peekLast();
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return -1;  // Return a default value or handle the error appropriately
        }
    }

    // Peek rear
    public int peekBack() {
        try {
            if (rightQueue.isEmpty()) {
                while (!leftQueue.isEmpty()) {
                    rightQueue.addLast(leftQueue.removeLast());
                }
            }
            if (rightQueue.isEmpty()) {
                throw new NoSuchElementException("peekBack from an empty deque");
            }
            return rightQueue.peekLast();
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return -1;  // Return a default value or handle the error appropriately
        }
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return leftQueue.isEmpty() && rightQueue.isEmpty();
    }

    // Get the size of the deque
    public int size() {
        return leftQueue.size() + rightQueue.size();
    }

    public static void main(String[] args) {
        TwoFifoQueues deque = new TwoFifoQueues();
        deque.pushFront(1);
        deque.pushBack(2);
        System.out.println(deque.popFront());  // Output: 1
        deque.pushFront(3);
        System.out.println(deque.popBack());   // Output: 2
        System.out.println(deque.popBack());   // Output: 3

        // Testing error handling
        System.out.println(deque.popBack());   // Output: Error message and -1
    }
}
