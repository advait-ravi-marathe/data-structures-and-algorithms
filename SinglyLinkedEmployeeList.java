public class SinglyLinkedEmployeeList {

    //Used to store head of linked list
    private EmployeeNode head;

    //Used to store size of linked list
    private int size;

    public void insertAtHead(Employee employee) {

        //Created a new node
        EmployeeNode node = new EmployeeNode(employee);

        //Setting next as current instance of head
        node.setNext(head);

        //Set head to the new node
        head = node;

        //Incrementing the size
        size++;

    }

    public void removeFromHead() {

        if(isEmpty()) {

            //If list is empty, return null
            return;

        }

        //Create a temporary node to store head
        EmployeeNode deletedNode = head;

        //Assign head to the next node to the head
        head = head.getNext();

        //Decrement size
        size--;

        //Assign next node to deletedNode as null
        deletedNode.setNext(null);

        System.out.println("\nRemoved node was - " + deletedNode);
    }

    public void print() {

        EmployeeNode current = head;

        System.out.println("\nThe current size of list = " + getSize());
        System.out.println("\nHEAD");
        System.out.println("↓");

        while (current != null) {

            System.out.println(current);
            System.out.println("↓");
            current = current.getNext();

        }

        System.out.println("NULL");

    }

    public int getSize() {
        return size;
    }

    //If head is null, list is empty.
    public boolean isEmpty() {
        return head == null;
    }

}
