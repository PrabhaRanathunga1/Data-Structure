package DataStructure2;

//Define the Node class
class Node {
 int data;
 Node next;

 // Constructor to initialize the node
 Node(int data) {
     this.data = data;
     this.next = null;
 }
}

//Define the QueueUsingLinkedList class
public class ImplementOfFIFOQueueUsingLinkedList {
 private Node front;
 private Node rear;

 // Constructor to initialize the queue
 public ImplementOfFIFOQueueUsingLinkedList() {
     this.front = null;
     this.rear = null;
 }

 // Method to add an element to the queue (enqueue)
 public void enqueue(int data) {
     Node newNode = new Node(data);
     if (rear == null) {
         front = rear = newNode;
     } else {
         rear.next = newNode;
         rear = newNode;
     }
 }

 // Method to remove an element from the queue (dequeue)
 public int dequeue() {
     if (front == null) {
         System.out.println("Queue  empty.");
         return -1; // Return -1 to indicate the queue is empty
     }
     int dequeuedData = front.data;
     front = front.next;
     if (front == null) {
         rear = null;
     }
     return dequeuedData;
 }

 // Method to check if the queue is empty
 public boolean isEmpty() {
     return front == null;
 }

 // Method to get the front element of the queue without removing it
 public int peek() {
     if (front == null) {
         System.out.println("Queue  empty.");
         return -1; // Return -1 to indicate the queue is empty
     }
     return front.data;
 }

 // Method to display the elements of the queue
 public void display() {
     if (front == null) {
         System.out.println("Queue  empty.");
     } else {
         Node current = front;
         while (current != null) {
             System.out.print(current.data + " -> ");
             current = current.next;
         }
         System.out.println("null");
     }
 }

 public static void main(String[] args) {
     ImplementOfFIFOQueueUsingLinkedList queue = new ImplementOfFIFOQueueUsingLinkedList();

     // Add elements to the queue
     queue.enqueue(10);
     queue.enqueue(20);
     queue.enqueue(30);

     // Display the queue
     queue.display(); // Output: 10 -> 20 -> 30 -> null

     // Peek the front element of the queue
     System.out.println("Front element: " + queue.peek()); // Output: Front element: 10

     // Remove an element from the queue
     System.out.println("Dequeued: " + queue.dequeue()); // Output: Dequeued: 10

     // Display the queue again
     queue.display(); // Output: 20 -> 30 -> null

     // Check if the queue is empty
     System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false

     // Remove remaining elements from the queue
     queue.dequeue();
     queue.dequeue();

     // Check if the queue is empty
     System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? true
 }
}
