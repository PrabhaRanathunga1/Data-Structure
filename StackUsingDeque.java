package DataStructure2;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsingDeque {

    // Function to add a ticket to the queue
    public static void addTicket(Queue<String> queue, String ticket) {
        queue.add(ticket);
        System.out.println("Added ticket: " + ticket);
    }

    // Function to process (remove) a ticket from the queue
    public static String processTicket(Queue<String> queue) {
        if (!queue.isEmpty()) {
            return queue.poll();
        } else {
            System.out.println("No tickets to process!");
            return null;
        }
    }

    public static void main(String[] args) {
        Queue<String> ticketQueue = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter 'add' to add a ticket, 'process' to process a ticket, or 'quit' to exit: ");
            String action = scanner.nextLine().trim().toLowerCase();

            if (action.equals("add")) {
                System.out.print("Enter the ticket details: ");
                String ticket = scanner.nextLine();
                addTicket(ticketQueue, ticket);
            } else if (action.equals("process")) {
                String ticket = processTicket(ticketQueue);
                if (ticket != null) {
                    System.out.println("Processed ticket: " + ticket);
                }
            } else if (action.equals("quit")) {
                System.out.println("Exiting.");
                break;
            } else {
                System.out.println("Invalid action. Please enter 'add', 'process', or 'quit'.");
            }
        }

        System.out.println("Final ticket queue: " + ticketQueue);
        scanner.close();
    }
}
