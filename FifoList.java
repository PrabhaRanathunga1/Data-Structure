package DataStructure2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FifoList {

    public static void main(String[] args) {
        List<String> queue = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Take user input for enqueue or dequeue operation
            System.out.print("Enter an element to enqueue, 'dequeue' to dequeue, or 'exit' to stop: ");
            String userInput = scanner.nextLine().trim();

            // Check if the user wants to exit
            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            // Enqueue operation
            else if (!userInput.equalsIgnoreCase("dequeue")) {
                queue.add(userInput);
                System.out.println("Enqueued: " + userInput);
            }

            // Dequeue operation
            else if (userInput.equalsIgnoreCase("dequeue")) {
                if (!queue.isEmpty()) {
                    String element = queue.remove(0);
                    System.out.println("Dequeued: " + element);
                } else {
                    System.out.println("Queue is empty, cannot dequeue.");
                }
            }

            // Show the current state of the FIFO queue
            System.out.println("Current FIFO queue: " + queue);
        }

        System.out.println("Queue processing complete.");
        scanner.close();
    }
}
