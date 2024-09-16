public class DoublyLinkedEmployeeList {

    //Used to store head of linked list
    private EmployeeNode head;

    //Used to store tail of linked list
    private EmployeeNode tail;

    //Used to store size of linked list
    private int size;

    public void insertAtHead(Employee employee) {

        //Created a new node
        EmployeeNode node = new EmployeeNode(employee);

        //If list is empty, we set tail as new node
        if(isEmpty()) {
            tail = node;
        }

        /*
            If list is not empty, we set previous of current instance
            of head to the new node
         */

        else {

            head.setPrevious(node);

            //Setting next as current instance of head
            node.setNext(head);

        }

        //Set head to the new node
        head = node;

        //Incrementing the size
        size++;

    }

    public void insertAtTail(Employee employee) {

        //Created a new node
        EmployeeNode node = new EmployeeNode(employee);

        //If list is empty, we set head as new node
        if(isEmpty()) {
            head = node;
        }

        /*
            If list is not empty, we set next of current instance
            of tail to the new node
         */

        else {
            tail.setNext(node);

            //Setting previous as current instance of tail
            node.setPrevious(tail);
        }

        //Set tail to the new node
        tail = node;

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

        //Checks if there is only single element
        if(head.getNext() == null) {
            tail = null;
        }

        else {

            //Setting previous of head's next as null
            head.getNext().setPrevious(null);

        }

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
        System.out.println("↕");

        while (current != null) {

            System.out.println(current);
            System.out.println("↕");
            current = current.getNext();

        }

        System.out.println("NULL");

    }

    public void removeFromTail() {

        if(isEmpty()) {

            //If list is empty, return null
            return;

        }

        //Create a temporary node to store tail
        EmployeeNode deletedNode = tail;

        //Checks if there is only single element
        if(tail.getPrevious() == null) {
            head = null;
        }

        else {

            //Setting next of tail's previous as null
            tail.getPrevious().setNext(null);

        }

        //Assign tail to the previous node to the tail
        tail = tail.getPrevious();

        //Decrement size
        size--;

        //Assign previous node to deletedNode as null
        deletedNode.setPrevious(null);

        System.out.println("\nRemoved node was - " + deletedNode);
    }

    public int getSize() {
        return size;
    }

    //If head is null, list is empty.
    public boolean isEmpty() {
        return head == null;
    }

    //This method adds employee before a given employee
    public boolean addBefore(Employee newEmployee, Employee existingEmployee) {

        /*
            Returns true, if you are able to successfully add employee.
            Else, return false.
         */

        if(isEmpty()) {
            return false;
        }

        EmployeeNode current = head;

        while(current != null && !current.getEmployee().equals(existingEmployee)) {

            current = current.getNext();

        }

        //If employee doesn't exist, return false.

        if(current == null) {
            return false;
        }

        EmployeeNode newEmployeeNode = new EmployeeNode(newEmployee);

        EmployeeNode previous = current.getPrevious();

        newEmployeeNode.setPrevious(previous);

        newEmployeeNode.setNext(current);

        current.setPrevious(newEmployeeNode);

        if(current == head) {
            head = newEmployeeNode;
        }

        else {
            previous.setNext(newEmployeeNode);
        }

        size++;

        return true;

    }

}
