package DataStructure2;



import java.util.Scanner;

public class CircularFifo {
    private int capacity;
    private String[] buffer;
    private int head;
    private int tail;
    private int size;

    public CircularFifo(int capacity) {
        this.capacity = capacity;
        this.buffer = new String[capacity];
        this.head = -1;
        this.tail = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(String element) {
        if (isFull()) {
            System.out.println("Buffer is full, cannot enqueue.");
            return;
        }
        if (isEmpty()) {
            head = 0;
            tail = 0;
        } else {
            tail = (tail + 1) % capacity;
        }
        buffer[tail] = element;
        size++;
        System.out.println("Enqueued: " + element);
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Buffer is empty, cannot dequeue.");
            return null;
        }
        String element = buffer[head];
        if (head == tail) {
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % capacity;
        }
        size--;
        System.out.println("Dequeued: " + element);
        return element;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Buffer is empty.");
        } else {
            System.out.print("Current buffer: ");
            int i = head;
            while (true) {
                System.out.print(buffer[i] + " ");
                if (i == tail) break;
                i = (i + 1) % capacity;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of the circular buffer: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // consume newline character

        CircularFifo buffer = new CircularFifo(capacity);

        while (true) {
            System.out.print("Enter an element to enqueue, 'dequeue' to dequeue, or 'exit' to stop: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            } else if (userInput.equalsIgnoreCase("dequeue")) {
                buffer.dequeue();
            } else {
                buffer.enqueue(userInput);
            }

            buffer.display();
        }

        System.out.println("Buffer processing complete.");
        scanner.close();
    }
}
