public class Arrays {

    public static void main(String[] args) {
        int[] intArray = new int[7];

        intArray[0] = 20;
        intArray[1] = 35;
        intArray[2] = -15;
        intArray[3] = 7;
        intArray[4] = 55;
        intArray[5] = 1;
        intArray[6] = -22;

        //intArray.length returns 7, i.e. length of array

        for(int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }

        /*
            Arrays are stored in one contiguous block.

            Every element occupies the same amount of space in memory.

            Memory address of ith element (x is array starting index
            and y is storage occupied by each element) - x + i * y

            If we know index of an element, the time to retrieve the
            element will be same no matter where it is in the array.
         */

        /*
            Big-O Notation for array operations

            Retrieval of element (known index) - O(1)
         */

        for(int i = 0; i < intArray.length; i++) {
            if(intArray[i] == 7) {
                System.out.println("The element 7 is present at index " + i);
                break;
            }
        }

        /*
            Retrieval of element (unknown index) - O(n)
         */

        /*
            To add new element to full array -

            Loop over and copy the entire elements into
            new array with length n + 1.

            Then add element to array[n].

            Add an element (full array) - O(n)
         */

        /*
            Add an element (has space) - O(1)
         */

        /*
            Update/insert/delete an element (known index) - O(1)
         */

        /*
            To delete element by shifting elements -

            Delete element or set it to null

            Loop over and copy the values to new index.

            As in if in above example 35 is deleted,
            new intArray[1] = -15, intArray[2] = 7 and so on.

            And new intArray[6] = null.

            Delete an element by shifting - O(n)
         */

        /*
            Key takeaways -

            If looping required, O(n) time complexity.

            If looping not required, O(1) time complexity.
         */
    }
}
