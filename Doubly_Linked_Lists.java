public class Doubly_Linked_Lists {

    public static void main(String[] args) {

        /*
            Doubly Linked List -

            Here, the elements are aware of which element exists
            next, as well as previous to them.

            The first element of list is called the head, as well
            as the last element of list is called the tail.
         */

        /*
            Since, now we have reference to the tail of list,
            we can insert element to the end of list in constant
            time complexity.
         */

        /*
            Insert at HEAD -

            Create a new node.

            Assign head to the next of this node.

            Assign null to the previous of this node.

            Assign new node to the previous of head

            Assign head equal to this new node.

            Time Complexity - O(1)
         */

        /*
            Insert at TAIL -

            Create a new node.

            Assign tail to the previous of this node.

            Assign null to the next of this node.

            Assign new node to the next of tail

            Assign tail equal to this node.

            Time Complexity - O(1)
         */

        /*
            Remove from HEAD -

            Assign head to the removedNode.

            Assign head.next to head.

            Assign head.previous to null.

            Assign removedNode.next to null

            Time Complexity - O(1)
         */

        /*
            Remove from TAIL -

            Assign tail to the removedNode

            Assign tail.previous to tail.

            Assign tail.next to null.

            Assign removedNode.previous to null

            Time Complexity - O(1)
         */

        /*
            To insert a node A b/w nodes B and C

            Assign A.next to C.

            Assign A.previous to B

            Assign B.next to A.

            Assign C.previous to A.

            Since, we need to find insertion position first

            Time Complexity - O(n)
         */

        /*
            To remove a node A b/w nodes B and C

            Assign A to the removedNode

            Assign C.previous to B.

            Assign B.next to C.

            Assign A.previous and A.next as null

            Since, we need to find A first

            Time Complexity - O(n)
         */

        Employee employee1 = new Employee("Jane", "Jones", 123);
        Employee employee2 = new Employee("John", "Doe", 4567);
        Employee employee3 = new Employee("Mary", "Smith", 22);
        Employee employee4 = new Employee("Mike", "Wilson", 3245);

        DoublyLinkedEmployeeList list = new DoublyLinkedEmployeeList();

        //Ctrl/Cmd + Click to look into implementation of insertAtHead() method
        list.insertAtHead(employee1);
        list.insertAtHead(employee2);
        list.insertAtHead(employee3);
        list.insertAtHead(employee4);

        //Ctrl/Cmd + Click to look into the implementation of print() method
        list.print();

        Employee employee5 = new Employee("Bill", "End", 78);

        //Ctrl/Cmd + Click to look into implementation of insertAtTail() method
        list.insertAtTail(employee5);

        //Ctrl/Cmd + Click to look into the implementation of print() method
        list.print();

        //Ctrl/Cmd + Click to look into the implementation of removeFromHead() method
        list.removeFromHead();
        System.out.println("\nNew list - ");
        list.print();

        //Ctrl/Cmd + Click to look into the implementation of removeFromTail() method
        list.removeFromTail();
        System.out.println("\nNew list - ");
        list.print();

        //Ctrl/Cmd + Click to look into the implementation of addBefore()
        Employee employee6 = new Employee("James", "Bond", 246);
        if(list.addBefore(employee6, employee2)) {
            System.out.println("\nNew list - ");
            list.print();
        }

    }

}
