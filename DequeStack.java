package DataStructure2;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DequeStack {
    private Deque<String> deque;

    public DequeStack() {
        deque = new LinkedList<>();
    }

    public void push(String element) {
        deque.addFirst(element);
        System.out.println("Pushed: " + element + " to the top of the stack.");
    }

    public void pop() {
        if (!deque.isEmpty()) {
            String element = deque.removeFirst();
            System.out.println("Popped: " + element + " from the top of the stack.");
        } else {
            System.out.println("Deque is empty, cannot pop from the stack.");
        }
    }

    public void enqueue(String element) {
        deque.addLast(element);
        System.out.println("Enqueued: " + element + " to the back of the deque.");
    }

    public void dequeue() {
        if (!deque.isEmpty()) {
            String element = deque.removeFirst();
            System.out.println("Dequeued: " + element + " from the front of the deque.");
        } else {
            System.out.println("Deque is empty, cannot dequeue.");
        }
    }

    public void display() {
        System.out.println("Current Deque: " + deque);
    }

    public static void main(String[] args) {
        DequeStack dequeExample = new DequeStack();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter 'push <element>', 'pop', 'enqueue <element>', 'dequeue', or 'exit' to stop: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            } else if (userInput.toLowerCase().startsWith("push ")) {
                String element = userInput.substring(5).trim();
                dequeExample.push(element);
            } else if (userInput.equalsIgnoreCase("pop")) {
                dequeExample.pop();
            } else if (userInput.toLowerCase().startsWith("enqueue ")) {
                String element = userInput.substring(8).trim();
                dequeExample.enqueue(element);
            } else if (userInput.equalsIgnoreCase("dequeue")) {
                dequeExample.dequeue();
            } else {
                System.out.println("Invalid command. Please enter 'push <element>', 'pop', 'enqueue <element>', 'dequeue', or 'exit'.");
            }

            dequeExample.display();
        }

        System.out.println("Deque processing complete.");
        scanner.close();
    }
}
