public class SinglyLinkedIntegerList {

    //Used to store head of linked list
    private IntegerNode head;

    //Used to store size of linked list
    private int size;

    public void insertAtHead(int data) {

        //Created a new node
        IntegerNode node = new IntegerNode(data);

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
        IntegerNode deletedNode = head;

        //Assign head to the next node to the head
        head = head.getNext();

        //Decrement size
        size--;

        //Assign next node to deletedNode as null
        deletedNode.setNext(null);

        System.out.println("\nRemoved node was - " + deletedNode);
    }

    public void print() {

        IntegerNode current = head;

        System.out.println("\nThe current size of list = " + getSize());
        System.out.println("\nHEAD");
        System.out.println("↓");

        while (current != null) {

            System.out.println(current.getData());
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

    public void insertSorted(int data) {

        /*
            If list is empty or the header data is greater than data,
            we can simply add the element in the front.
         */

        if(isEmpty() || head.getData() >= data) {

            insertAtHead(data);
            return;

        }

        else {

            //Find the insertion point
            IntegerNode current = head.getNext();

            //Tracks the previous value
            IntegerNode previous = head;

            while(current != null && current.getData() < data) {

                previous = current;
                current = current.getNext();

            }

            IntegerNode newIntegerNode = new IntegerNode(data);

            //Set next node of new node to current
            newIntegerNode.setNext(current);

            //Set next node to the previous node as new node
            previous.setNext(newIntegerNode);

            size++;

        }

        print();

    }

}
