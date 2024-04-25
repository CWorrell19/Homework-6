// Conner Worrell

class Node {
    // Node class to hold data and pointers to previous and next nodes
    int data;
    Node next;
    Node prev;

    Node(int data) {
        // Initialize a node with data
        this.data = data;
        this.next = null; // Pointer to the next node (initially null)
        this.prev = null; // Pointer to the previous node (initially null)
    }
}

class DoublyLinkedList {
    // Doubly linked list class to manage nodes
    Node head; // The first node in the list (initially null)
    Node tail; // The last node in the list (initially null)

    DoublyLinkedList() {
        // Create an empty doubly linked list
        this.head = null;
        this.tail = null;
    }

    void add(int data) {
        // Add a new node with data to the end of the list
        Node newNode = new Node(data);
        if (this.head == null) { // If the list is empty
            this.head = newNode; // Set the head to the new node
            this.tail = newNode; // Set the tail to the new node
        } else { // If the list is not empty
            Node current = this.head;
            while (current.next != null) { // Traverse to the end of the list
                current = current.next;
            }
            current.next = newNode; // Set next of the last node to the new node
            newNode.prev = current; // Set previous of the new node to the last node
            this.tail = newNode; // Update the tail to the new node
        }
    }

    boolean remove(int data) {
        // Remove a node with the given data from the list
        Node current = this.head;
        while (current != null) { // Traverse the list
            if (current.data == data) { // If data matches
                if (current.prev != null) { // If there's a previous node
                    current.prev.next = current.next; // Update the next of the previous node
                } else { // If it's the head node
                    this.head = current.next; // Update the head
                }
                if (current.next != null) { // If there's a next node
                    current.next.prev = current.prev; // Update the previous of the next node
                } else { // If it's the tail node
                    this.tail = current.prev; // Update the tail
                }
                return true; // Node found and removed
            }
            current = current.next; // Move to the next node
        }
        return false; // Node not found
    }

    void traverseForward() {
        // Traverse the list from head to tail and print data of each node
        Node current = this.head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    void traverseBackward() {
        // Traverse the list from tail to head and print data of each node
        Node current = this.tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }

    // Unit tests
    public static void main(String[] args) {
        // Create a doubly linked list
        DoublyLinkedList dll = new DoublyLinkedList();

        // Test adding elements
        dll.add(1);
        dll.add(2);
        dll.add(3);

        // Test forward traversal
        System.out.println("Forward traversal:");
        dll.traverseForward();

        // Test reverse traversal
        System.out.println("Reverse traversal:");
        dll.traverseBackward();

        // Test removing elements
        dll.remove(2);
        System.out.println("After removing 2:");
        dll.traverseForward();

        // Test removing from empty list
        DoublyLinkedList dllEmpty = new DoublyLinkedList();
        System.out.println("Removing from empty list: " + dllEmpty.remove(1)); // Should print false

        // Test removing non-existent element
        dll.add(4);
        System.out.println("Removing non-existent element: " + dll.remove(5)); // Should print false

        // Test removing head element
        dll.remove(1);
        System.out.println("After removing head:");
        dll.traverseForward();

        // Test removing tail element
        dll.remove(3);
        System.out.println("After removing tail:");
        dll.traverseForward();

        // Test adding to an empty list
        DoublyLinkedList dllEmpty2 = new DoublyLinkedList();
        dllEmpty2.add(5);
        System.out.println("After adding to empty list:");
        dllEmpty2.traverseForward();
    }
}
