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

//Define the SingleLinkedList class
public class ImplementationOfSingleLinList {
 private Node head;

 // Constructor to initialize the linked list
 public ImplementationOfSingleLinList() {
     this.head = null;
 }

 // Method to add a new node at the beginning of the list
 public void addFirst(int data) {
     Node newNode = new Node(data);
     newNode.next = head;
     head = newNode;
 }

 // Method to add a new node at the end of the list
 public void addLast(int data) {
     Node newNode = new Node(data);
     if (head == null) {
         head = newNode;
     } else {
         Node current = head;
         while (current.next != null) {
             current = current.next;
         }
         current.next = newNode;
     }
 }

 // Method to remove the first node of the list
 public void removeFirst() {
     if (head != null) {
         head = head.next;
     } else {
         System.out.println("The list  empty.");
     }
 }

 // Method to remove the last node of the list
 public void removeLast() {
     if (head == null) {
         System.out.println("The list  empty.");
         return;
     }

     if (head.next == null) {
         head = null;
         return;
     }

     Node current = head;
     Node previous = null;

     while (current.next != null) {
         previous = current;
         current = current.next;
     }

     previous.next = null;
 }

 // Method to display the elements of the linked list
 public void display() {
     if (head == null) {
         System.out.println("The list  empty.");
     } else {
         Node current = head;
         while (current != null) {
             System.out.print(current.data + " -> ");
             current = current.next;
         }
         System.out.println("null");
     }
 }

 public static void main(String[] args) {
     ImplementationOfSingleLinList list = new ImplementationOfSingleLinList();

     // Add elements to the list
     list.addFirst(3);
     list.addFirst(2);
     list.addFirst(1);

     // Display the list
     list.display(); // Output: 1 -> 2 -> 3 -> null

     // Add elements to the end of the list
     list.addLast(4);
     list.addLast(5);

     // Display the list again
     list.display(); // Output: 1 -> 2 -> 3 -> 4 -> 5 -> null

     // Remove the first element
     list.removeFirst();

     // Display the list again
     list.display(); // Output: 2 -> 3 -> 4 -> 5 -> null

     // Remove the last element
     list.removeLast();

     // Display the list again
     list.display(); // Output: 2 -> 3 -> 4 -> null
 }
}
