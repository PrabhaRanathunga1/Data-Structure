package DataStructure2;

//Define the Node class
class Node {
 int data;
 Node prev;
 Node next;

 // Constructor to initialize the node
 Node(int data) {
     this.data = data;
     this.prev = null;
     this.next = null;
 }
}

//Define the DoublyLinkedList class
public class ImplementOfDoublyLinkedList {
 private Node head;
 private Node tail;

 // Constructor to initialize the linked list
 public ImplementOfDoublyLinkedList() {
     this.head = null;
     this.tail = null;
 }

 // Method to add a new node at the beginning of the list
 public void addFirst(int data) {
     Node newNode = new Node(data);
     if (head == null) {
         head = tail = newNode;
     } else {
         newNode.next = head;
         head.prev = newNode;
         head = newNode;
     }
 }

 // Method to add a new node at the end of the list
 public void addLast(int data) {
     Node newNode = new Node(data);
     if (tail == null) {
         head = tail = newNode;
     } else {
         tail.next = newNode;
         newNode.prev = tail;
         tail = newNode;
     }
 }

 // Method to remove the first node of the list
 public void removeFirst() {
     if (head == null) {
         System.out.println("The list is empty.");
         return;
     }
     if (head == tail) {
         head = tail = null;
     } else {
         head = head.next;
         head.prev = null;
     }
 }

 // Method to remove the last node of the list
 public void removeLast() {
     if (tail == null) {
         System.out.println("The list is empty.");
         return;
     }
     if (head == tail) {
         head = tail = null;
     } else {
         tail = tail.prev;
         tail.next = null;
     }
 }

 // Method to display the elements of the linked list from head to tail
 public void displayForward() {
     if (head == null) {
         System.out.println("The list is empty.");
     } else {
         Node current = head;
         while (current != null) {
             System.out.print(current.data + " <-> ");
             current = current.next;
         }
         System.out.println("null");
     }
 }

 // Method to display the elements of the linked list from tail to head
 public void displayBackward() {
     if (tail == null) {
         System.out.println("The list is empty.");
     } else {
         Node current = tail;
         while (current != null) {
             System.out.print(current.data + " <-> ");
             current = current.prev;
         }
         System.out.println("null");
     }
 }

 public static void main(String[] args) {
     ImplementOfDoublyLinkedList list = new ImplementOfDoublyLinkedList();

     // Add elements to the list
     list.addFirst(3);
     list.addFirst(2);
     list.addFirst(1);

     // Display the list forward
     list.displayForward(); // Output: 1 <-> 2 <-> 3 <-> null

     // Add elements to the end of the list
     list.addLast(4);
     list.addLast(5);

     // Display the list forward again
     list.displayForward(); // Output: 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null

     // Display the list backward
     list.displayBackward(); // Output: 5 <-> 4 <-> 3 <-> 2 <-> 1 <-> null

     // Remove the first element
     list.removeFirst();

     // Display the list forward again
     list.displayForward(); // Output: 2 <-> 3 <-> 4 <-> 5 <-> null

     // Remove the last element
     list.removeLast();

     // Display the list forward again
     list.displayForward(); // Output: 2 <-> 3 <-> 4 <-> null
 }
}
