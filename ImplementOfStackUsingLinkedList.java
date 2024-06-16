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

//Define the StackUsingLinkedList class
public class ImplementOfStackUsingLinkedList {
 private Node top;

 // Constructor to initialize the stack
 public ImplementOfStackUsingLinkedList() {
     this.top = null;
 }

 // Method to push an element onto the stack
 public void push(int data) {
     Node newNode = new Node(data);
     newNode.next = top;
     top = newNode;
 }

 // Method to pop an element from the stack
 public int pop() {
     if (top == null) {
         System.out.println("Stack is empty.");
         return -1; // Return -1 to indicate the stack is empty
     }
     int poppedData = top.data;
     top = top.next;
     return poppedData;
 }

 // Method to peek the top element of the stack
 public int peek() {
     if (top == null) {
         System.out.println("Stack is empty.");
         return -1; // Return -1 to indicate the stack is empty
     }
     return top.data;
 }

 // Method to check if the stack is empty
 public boolean isEmpty() {
     return top == null;
 }

 // Method to display the elements of the stack
 public void display() {
     if (top == null) {
         System.out.println("Stack is empty.");
     } else {
         Node current = top;
         while (current != null) {
             System.out.print(current.data + " -> ");
             current = current.next;
         }
         System.out.println("null");
     }
 }

 public static void main(String[] args) {
     ImplementOfStackUsingLinkedList stack = new ImplementOfStackUsingLinkedList();

     // Push elements onto the stack
     stack.push(10);
     stack.push(20);
     stack.push(30);

     // Display the stack
     stack.display(); // Output: 30 -> 20 -> 10 -> null

     // Peek the top element of the stack
     System.out.println("Top element: " + stack.peek()); // Output: Top element: 30

     // Pop an element from the stack
     System.out.println("Popped: " + stack.pop()); // Output: Popped: 30

     // Display the stack again
     stack.display(); // Output: 20 -> 10 -> null

     // Check if the stack is empty
     System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? false

     // Pop remaining elements from the stack
     stack.pop();
     stack.pop();

     // Check if the stack is empty
     System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? true
 }
}
