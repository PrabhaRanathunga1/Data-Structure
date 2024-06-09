package DataStructure2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class StackCustomClass {
    private PriorityQueue<Integer> priorityQueue;

    public StackCustomClass() {
        priorityQueue = new PriorityQueue<>();
    }

    public void enqueue(int item) {
        priorityQueue.add(item);
    }

    public int dequeue() {
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.poll();
        } else {
            throw new RuntimeException("dequeue from empty priority queue");
        }
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    public int peek() {
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.peek();
        } else {
            throw new RuntimeException("peek from empty priority queue");
        }
    }

    public static void main(String[] args) {
        StackCustomClass customPriorityQueue = new StackCustomClass();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter 'enqueue' to add an element, 'dequeue' to remove an element, or 'quit' to exit: ");
            String action = scanner.nextLine().trim().toLowerCase();

            if (action.equals("enqueue")) {
                System.out.print("Enter the element to enqueue into the priority queue: ");
                int item = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                customPriorityQueue.enqueue(item);
                System.out.println("Enqueued " + item + " into the priority queue.");
            } else if (action.equals("dequeue")) {
                try {
                    int item = customPriorityQueue.dequeue();
                    System.out.println("Dequeued " + item + " from the priority queue.");
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            } else if (action.equals("quit")) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid action. Please enter 'enqueue', 'dequeue', or 'quit'.");
            }
        }

        System.out.println("Final priority queue: " + customPriorityQueue.priorityQueue);
        scanner.close();
    }
}
