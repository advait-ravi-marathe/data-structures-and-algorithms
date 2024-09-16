public class Singly_Linked_Lists {

    public static void main(String[] args) {

        /*
            Singly Linked Lists

            Here, the elements are aware of which element exists
            next to them. On contrary, arrays are not aware of
            what element exists next to them.

            Each element of list is called a node.

            The first item in the list is called the head.
         */

        /*
            To insert an element into the list -

            New elements are always inserted in the front.

            Create a new node.

            Assign reference to head in the next field.

            Assign head reference to new node.

            Time complexity - O(1)
         */

        /*
            To delete an element from the list -

            Elements are always removed from the front.

            Assign head to removedNode.

            Assign head.next to head.

            Return removedNode.

            Time complexity - O(1)
         */

        Employee employee1 = new Employee("Jane", "Jones", 123);
        Employee employee2 = new Employee("John", "Doe", 4567);
        Employee employee3 = new Employee("Mary", "Smith", 22);
        Employee employee4 = new Employee("Mike", "Wilson", 3245);

        SinglyLinkedEmployeeList list = new SinglyLinkedEmployeeList();

        //Ctrl/Cmd + Click to look into the implementation of isEmpty()
        System.out.println("\nIs the list empty? - " + list.isEmpty());

        //Ctrl/Cmd + Click to look into implementation of insertAtHead() method
        list.insertAtHead(employee1);
        list.insertAtHead(employee2);
        list.insertAtHead(employee3);
        list.insertAtHead(employee4);

        //Ctrl/Cmd + Click to look into the implementation of print() method
        list.print();

        //Ctrl/Cmd + Click to look into the implementation of getSize() method
        System.out.println("\nThe size of linked list is - " + list.getSize());

        //Ctrl/Cmd + Click to look into the implementation of removeFromHead() method
        list.removeFromHead();
        System.out.println("\nNew list - ");
        list.print();

        SinglyLinkedIntegerList integerList = new SinglyLinkedIntegerList();

        //Ctrl/Cmd + Click to look into the implementation of insertSorted() method
        integerList.insertSorted(4);
        integerList.insertSorted(3);
        integerList.insertSorted(1);
        integerList.insertSorted(2);
    }

}
