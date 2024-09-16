import java.util.Iterator;
import java.util.LinkedList;

public class Linked_Lists_JDK {

    public static void main(String[] args) {

        /*
            Linked lists using JDK -

            It uses a doubly linked list implementation.
         */

        Employee employee1 = new Employee("Jane", "Jones", 123);
        Employee employee2 = new Employee("John", "Doe", 4567);
        Employee employee3 = new Employee("Mary", "Smith", 22);
        Employee employee4 = new Employee("Mike", "Wilson", 3245);
        Employee employee5 = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();

        //To add employee at front (i.e. HEAD)
        list.addFirst(employee1);
        list.addFirst(employee2);
        list.addFirst(employee3);
        list.addFirst(employee4);

        //Initiate iterator for LinkedList
        Iterator<Employee> iterator = list.iterator();

        System.out.println("\nHEAD");
        System.out.println("↕");

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("↕");
        }

        System.out.println("NULL");

        /*
            Alternative snippet (Replace with while loop) -

            for(Employee employee: list) {
                System.out.println(employee);
                System.out.println("↕");
            }
         */

        //To add element at last (i.e. TAIL)
        list.addLast(employee5);

        iterator = list.iterator();

        System.out.println("\nHEAD");
        System.out.println("↕");

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("↕");
        }

        System.out.println("NULL");

        //To remove element from front (i.e. HEAD)
        list.removeFirst();

        iterator = list.iterator();

        System.out.println("\nHEAD");
        System.out.println("↕");

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("↕");
        }

        System.out.println("NULL");

        //To remove element from last
        list.removeLast();

        iterator = list.iterator();

        System.out.println("\nHEAD");
        System.out.println("↕");

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            System.out.println("↕");
        }

        System.out.println("NULL");

    }

}
