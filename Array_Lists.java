import java.util.ArrayList;
import java.util.List;

public class Array_Lists {

    public static void main(String[] args) {

        /*
            Abstract data type

            Doesn't dictate how the data is organized. For instance, in an array
            we know that the elements are stored in a continuous manner. But for
            these data structures, we cannot determine where and how our data
            is stored.

            It dictates the operations. For instance, can the first/last element
            be accessed, etc.

            Concrete data structures are class-based.

            Whereas, abstract data types are interfaces.
         */

        /*
            In ArrayList, the references to the objects are stored in an array.

            Retrieval of element (known index) - O(1)

            To add new element to full array -

            Loop over and copy the entire elements into
            new array with length n + 1.

            Then add element to array[n].

            Add an element (full array) - O(n)

            Add an element (has space) - O(1)

            Update/insert/delete an element (known index) - O(1)

            To delete element by shifting elements -

            Delete element or set it to null

            Loop over and copy the values to new index.

            Delete an element by shifting - O(n)

            Similarly, insert an element at specific index - O(n)
         */

        /*
            Size of an ArrayList => The number of elements stored

            Capacity of an ArrayList => Maximum number of elements that can be stored
         */

        //Creates a default list with backing array capacity of 10.
        List<Employee> employeeList = new ArrayList<>();

        //Adds employees to the employeeList
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        //For each loop to print each individual employee
        employeeList.forEach(employee -> System.out.println("\n" + employee));

        //get method to access employee at certain index
        System.out.println("\nEmployee at the second index\n" + employeeList.get(1));

        //isEmpty to check whether employeeList is empty or not
        System.out.println("\nIs the employee list empty - " + employeeList.isEmpty());

        //set method to replace the employee present at certain index
        employeeList.set(1, new Employee("John", "Adams", 4567));

        employeeList.forEach(employee -> System.out.println("\n" + employee));

        //size method to print the size of employeeList
        System.out.println("\nThe size of employee list id - " + employeeList.size());

        //Add an employee at a specific index
        employeeList.add(2, new Employee("John", "Doe", 4568));

        employeeList.forEach(employee -> System.out.println("\n" + employee));

        //To get array of employees back from employeeList
        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);

        System.out.println("\nPrinting employee array - ");

        for(Employee employee: employeeArray) {
            System.out.println("\n" + employee);
        }

        //To get whether a list contains a specific instance
        System.out.println("\nDoes employee list contain Mary? - " + employeeList.contains(new Employee("Mary", "Smith", 22)));

        /*
            This will return false, because we have created a new
            instance, which is not equal to the instance which was
            created. The structures might be structurally same, but
            the objects are stored in different addresses.
         */

        /*
            To actually implement this, we need to create an equals
            method in our parent class, which does structural comparison,
            rather than instance based comparison.
         */

        //To get the index at which specific employee is present
        System.out.println("\nJohn Doe is present at - " + employeeList.indexOf(new Employee("John", "Doe", 4568)) + " position");

        //To remove an element at specific index
        employeeList.remove(2);

        System.out.println("\nEmployee list after removing employee at the 3rd position - ");

        employeeList.forEach(employee -> System.out.println("\n" + employee));

        /*
            Vectors have similar implementation as that of ArrayList.
            Except, all the operations here are thread safe.

            Meaning, all instances here are synchronized.

            To declare a Vector, simply replace ArrayList with Vector
            on line 60. I.e. List<Employee> employeeList = new Vector<>();
         */
    }
}
