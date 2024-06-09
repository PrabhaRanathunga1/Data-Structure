package DataStructure2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackList {

    // Function to enqueue elements into the queue
    public static void enqueue(List<String> queue, String item) {
        queue.add(item);
    }

    // Function to dequeue elements from the queue
    public static String dequeue(List<String> queue) {
        if (!queue.isEmpty()) {
            return queue.remove(0);
        } else {
            System.out.println("Queue is empty!");
            return null;
        }
    }

    public static void main(String[] args) {
        List<String> queue = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter 'enqueue' to add an element, 'dequeue' to remove an element, or 'quit' to exit: ");
            String action = scanner.nextLine().trim().toLowerCase();

            if (action.equals("enqueue")) {
                System.out.print("Enter the element to enqueue into the queue: ");
                String item = scanner.nextLine();
                enqueue(queue, item);
                System.out.println("Enqueued " + item + " into the queue.");
            } else if (action.equals("dequeue")) {
                String item = dequeue(queue);
                if (item != null) {
                    System.out.println("Dequeued " + item + " from the queue.");
                }
            } else if (action.equals("quit")) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid action. Please enter 'enqueue', 'dequeue', or 'quit'.");
            }
        }

        System.out.println("Final queue: " + queue);
        scanner.close();
    }
}
