import java.util.Arrays;

public class Sort_Algorithms {

    public static void main(String[] args) {

        //Ctrl + Click for detailed theory and implementation
        bubbleSortAlgorithm();

        /*
            Stable vs Unstable Sort

            Consider an array with repetitive values (Denoted by a and A) -
            [5, a, 3, A, 8, 4]

            In unstable sort, result = [3, 4, 5, 8, A, a]
            (Relative positioning of repetitive values is not preserved)

            In stable sort, result = [3, 4, 5, 8, a, A]
            (Relative positioning of repetitive values is preserved)

            Bubble sort is a stable sort, because swapping only happens
            when index[i] > index[i+1].
         */

        selectionSortAlgorithm();

        insertionSortAlgorithm();

        shellSortAlgorithm();

        shellBubbleSortAlgorithm();

        //Ctrl/Cmd + Click for detailed theory and implementation
        recursion();

        //Ctrl/Cmd + Click for detailed theory and implementation
        mergeSortAlgorithm();

        //Ctrl/Cmd + Click for detailed theory and implementation
        quickSortAlgorithm();

        //Ctrl/Cmd + Click for detailed theory and implementation
        countingSortAlgorithm();

        /*
            Ctrl/Cmd + Click for detailed theory
            For implementation refer to radixSortAlgorithm
         */
        stableCountingSortAlgorithm();

        //Ctrl/Cmd + Click for detailed theory and implementation
        radixSortAlgorithm();

        //Ctrl/Cmd + Click for detailed theory and implementation
        sortingUsingJDK();

        /*
            Double Pivot Quick Sort Algorithm (Default JDK Sort)
            Ctrl/Cmd + Click for detailed theory and implementation
         */
        doublePivotQuickSortAlgorithm();

        //Ctrl/Cmd + Click for detailed theory and implementation
        descendingMergeSortAlgorithm();

        //Ctrl/Cmd + Click for detailed implementation
        recursiveInsertionSortAlgorithm();

        //Ctrl/Cmd + Click for detailed implementation
        stringRadixSortAlgorithm();

    }

    public static void swap(int[] arr, int i) {

        // Swaps elements only if arr[i] > arr[i + 1]

        if(arr[i] == arr[i + 1] || arr[i] < arr[i + 1]) {
            return;
        }

        int tmp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = tmp;
    }

    public static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }

    public static void bubbleSortAlgorithm() {
        /*
            Bubble Sort -

            unSortedPartitionIndex = array length - 1;
            (Last index of unsorted partition)

            i = 0
            (Index used to traverse the array from left to right)

            If array[i] < array[i + 1], no swapping.
            Else array[i] > array[i + 1], swap elements.

            Update i => i + 1

            When i = unSortedPartitionIndex, 1st iteration complete.
            The greatest element now is present at last index.

            Now update unSortedPartitionIndex => unSortedPartitionIndex - 1
            And set i = 0

            In-place algorithm, i.e. doesn't require to create new array.

            Complexity - O(n^2)
         */

        System.out.println("********** BUBBLE SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        int step = 1;

        for(int unSortedPartitionIndex = arr.length - 1; unSortedPartitionIndex > 0; unSortedPartitionIndex--, step++) {

            for(int i = 0; i < unSortedPartitionIndex; i++) {
                swap(arr, i);
            }

            System.out.println("Array after step " + step + " - " + Arrays.toString(arr));
        }

    }

    public static void selectionSortAlgorithm() {
        /*
            Selection Sort -

            lastUnsortedIndex = array length - 1;
            (Last index of unsorted partition)

            i = 1
            (Index used to traverse the array from left to right)

            largest = 0
            (Used to store index of largest element in unsorted partition)

            If array[i] > largest, largest = i.
            Update i => i + 1

            When i = lastUnsortedIndex, 1st iteration complete.
            Swap arr[largest] to arr[lastUnsortedIndex].
            The greatest element now is present at last index.

            Now update lastUnsortedIndex => lastUnsortedIndex - 1
            And set i = 1, largest = 0.

            In-place algorithm, i.e. doesn't require to create new array.

            Complexity - O(n^2)

            Unstable algorithm
         */

        System.out.println("\n********** SELECTION SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        int step = 1;

        for(int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--, step++) {

            int largest = 0;

            for(int i = 1; i <= lastUnsortedIndex; i++) {

                if(arr[largest] < arr[i]) {
                    largest = i;
                }
                swap(arr, largest, lastUnsortedIndex);
            }

            System.out.println("Array after step " + step + " - " + Arrays.toString(arr));
        }
    }

    public static void insertionSortAlgorithm() {
        /*
            Insertion Sort -

            firstUnsortedIndex = 1;
            (First index of unsorted partition)

            i = 0
            (Index used to traverse the array from right to left)

            newElement = array[firstUnsortedIndex]
            (Used to store first element of unsorted partition)

            If array[i] <= newElement, sorted partition has grown.
            Update firstUnsortedIndex = 2,
            as now the first index of unsorted partition is 2.
            (Unsorted partition now has length of 2)

            If newElement <= sortedPartition[1], shift sortedPartition[1]
            to the right, to make room for newElement.

            Furthermore, if newElement <= sortedPartition[0], shift
            sortedPartition[0] to the right, to make room for newElement.

            In the similar way, traverse until sortedPartition.length ==
            array.length.

            In-place algorithm, i.e. doesn't require to create new array.

            Complexity - O(n^2)

            Stable algorithm
         */

        System.out.println("\n********** INSERTION SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        int step = 1;

        for(int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++, step++) {

            int newElement = arr[firstUnsortedIndex];

            int i;

            for(i = firstUnsortedIndex; i > 0 && arr[i - 1] > newElement; i--) {
                arr[i] = arr[i - 1];
            }

            arr[i] = newElement;

            System.out.println("Array after step " + step + " - " + Arrays.toString(arr));
        }
    }

    public static void shellSortAlgorithm() {

        /*
            Variation of insertion sort

            Insertion sort chooses which element to insert using a gap of 1
            i.e. comparing one by one the elements in sorted partition

            Shell sort starts out with a larger gap.

            As the algorithm runs, gap is reduced.

            The goal is to reduce the amount of shifting

            The last gap value is always 1

            When gap = 1, shell sort is equivalent to insertion sort

            So, the algorithm does preliminary work with larger gap
            and then becomes insertion sort.

            This allows the array to be partially sorted to lessen
            the shifting required.

            The most common way to calculate gap is Knuth sequence.

            Gap is calculated using (3^k - 1)/2.

            k is set on the basis of the length of an array.

            Gap should be as close as possible to the length of array
            without being greater than the length of an array

            Here, we will base our gap based on the array's length.
            Initialize gap = (array.length/2)

            Upon each iteration, we will divide gap by 2.

            Take floor value in case array length is odd.

            Reduce until gap = 1.

            Start with i = gap.

            j = i

            newElement = array[i]

            Compare array[j - gap] with newElement

            If newElement < array[j - gap], shift array[j - gap] to arr[j]
            And assign arr[j] to arr[j - gap] if j - gap = 0.

            Update i => i + 1

            j = i

            newElement = array[i]

            Compare array[j - gap] with newElement.

            If newElement > array [j - gap], do nothing.

            Now, if j - gap != 0, then compare with j - 2 * gap.
            Continue this procedure until j - k * gap > 0.
            Where k is some natural number.

            When i = array.length - 1, and all shiftings are done,
            the first iteration is done.

            Update gap => gap/2

            In-place algorithm, i.e. doesn't require to create new array.

            Difficult to nail down the time complexity, worst case in O(n^2).

            Unstable algorithm

            You can improve bubble sort to with the same implementation
         */

        System.out.println("\n********** SHELL SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        int step = 1;

        for(int gap = arr.length / 2; gap > 0; gap /= 2) {

            System.out.println("\nCalculating when gap = " + gap);

            for(int i = gap; i < arr.length; i++, step++) {

                int newElement = arr [i];

                int j = i;

                while (j >= gap && arr[j - gap] > newElement) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = newElement;

                System.out.println("Array after step " + step + " - " + Arrays.toString(arr));
            }
        }
    }

    public static void shellBubbleSortAlgorithm() {

        /*
            Shell Bubble Sort -

            Start with gap = array.length / 2

            unSortedPartitionIndex = array.length - gap;
            (Last index of unsorted partition)

            i = 0
            (Index used to traverse the array from left to right)

            If array[i] < array[i + gap], no swapping.
            Else array[i] > array[i + gap], swap elements.

            Update i => i + gap

            When i = unSortedPartitionIndex, 1st iteration complete.
            The greatest element now is present at last index.

            Now update unSortedPartitionIndex => unSortedPartitionIndex - gap
            And set i = 0

            In-place algorithm, i.e. doesn't require to create new array.

            Complexity - O(n^2)
         */

        System.out.println("\n********** SHELL BUBBLE SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        int step = 1;

        for(int gap = arr.length / 2; gap > 0; gap /= 2) {

            System.out.println("\nCalculating when gap = " + gap);

            for(int unSortedPartitionIndex = arr.length - gap; unSortedPartitionIndex > 0; unSortedPartitionIndex = unSortedPartitionIndex - gap, step++) {

                for( int i = 0; i < unSortedPartitionIndex; i = i + gap) {

                    if(arr[i] > arr[i + gap]){
                        swap(arr, i,i + gap);
                    }

                }

                System.out.println("Array after step " + step + " - " + Arrays.toString(arr));
            }

        }

    }

    public static long factorial(int num) {

        if(num == 0) {
            return 1;
        }

        return num * factorial(num - 1);

    }

    public static void recursion() {

        /*
            Recursion is a method that calls itself again and again.

            We will look into factorial function as an example

            Start with num

            Return num * factorial(num - 1)

            If num = 0, the factorial is 1.

            Since factorial(int num) gets called again and again, this shows recursion

            For a recursion algorithm to be successful, there should be one point, when
            recursion needs to stop. This is called breaking case.

            In our case, breaking case is num = 0, factorial = 1.
         */

        int num = 9;

        System.out.println("\nThe factorial of " + num + " is - " + factorial(num));

    }

    public static void mergeSort(int[] arr, int start, int end) {

        /*
            Breaking condition -
            By default single element arrays are sorted
         */

        if(end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        /*
            Recursion

            Execute left sub-array, i.e. indices start from start to mid.

            Then, execute right sub-array, i.e. indices start from mid to end.
         */

        System.out.println("\nLeft partition - " + Arrays.toString(Arrays.copyOfRange(arr, start, mid)));
        mergeSort(arr, start, mid);

        System.out.println("\nRight partition - " + Arrays.toString(Arrays.copyOfRange(arr, mid, end)));
        mergeSort(arr, mid, end);

        //Merge the arrays
        merge(arr, start, mid, end);

    }

    public static void merge(int[] arr, int start, int mid, int end) {

        /*
            mid - 1 is the last index of the left partition
            mid is the first index of the right partition

            If arr[mid - 1] < arr[mid], and since all elements in
            the left partition are already sorted, this tells all
            the elements in the left partition are less than the
            elements in the right partition.
         */

        if(arr[mid - 1] <= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tmpIndex = 0;
        int[] tmp = new int[end - start];

        while(i < mid && j < end) {

            tmp[tmpIndex++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];

        }

        /*
              For left-over elements in left partition, i will be starting
              index of the elements which have not been accommodated in tmp

              The destination position will be start + tmpIndex, because the
              elements in the left partition need to jump tmpIndex places from
              start.

              The length will be mid - i, as it shows the number of elements
              which were not copied from the left partition.
         */

        System.arraycopy(arr, i, arr, start + tmpIndex, mid - i);

        /*
            This copies temporary array from start to tmpIndex.
         */

        System.arraycopy(tmp, 0, arr, start, tmpIndex);

        System.out.println("\nPartitions after merge - " + Arrays.toString(Arrays.copyOfRange(arr, start, end)));

    }

    public static void mergeSortAlgorithm() {

        /*
            Merge Sort -

            Divide and conquer algorithm

            Recursive algorithm

            Two phases - Splitting and Merging

            Splitting phase leads to faster sorting during merging

            Splitting is logical, no new arrays are created.

            Splitting phase -

            Start with an unsorted array.

            Divide the array into two, which are unsorted.
            (Get mid-point by (start + end)/2. For the first
            iteration, start = 0, end = array.length)

            The first array is left array, and the second array is right array.

            Keep splitting left and right arrays until all arrays have single element

            These new arrays are sorted arrays.

            Merging phase -

            Merge every left/right pair of sibling arrays.
            (Merging is done by keeping array with lower value at left,
            and higher value at right).

            After the first round of merge, we will have a bunch of
            two-element arrays.

            Then, merge these two-element arrays to end up with a bunch
            of four-element arrays.

            Repeat until there is a single sorted array.

            Not in-place algorithm, uses temporary arrays.

            Algorithm -

            Recursively split array into left array and right array.
            (Note - Only after splitting left array completely, we will
            be splitting right array)

            We merge sibling left and right arrays

            We create a temporary array large enough to hold all the
            elements in the array we're merging

            We set i = first index of left array
                   j = first index of right array

            We compare left[i] to right[j].
            If left[i] < right[j], we copy it to temporary array and
            Update i => i + 1
            If left[i] > right[j], we copy it to temporary array and
            Update j => j + 1

            We repeat the procedure until all elements in the two
            arrays are processed. Now, temporary array contains the
            merged values in sorted order.

            We then copy this temporary array back to the original
            input array, at the correct positions.

            If the left array is at positions x to y, and the right
            array is at y + 1 to z, then after the copy, positions
            x to z will be sorted in the original array.

            Time complexity - O(n * log2(n))

            Stable Algorithm
         */

        System.out.println("\n********** MERGE SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(arr, 0, arr.length);
    }

    public static void quickSort(int[] arr, int start, int end) {

        /*
            Breaking condition -
            By default single element arrays are sorted
         */

        if(end - start < 2) {
            return;
        }

        System.out.println("\nArray before quick sort is - " + Arrays.toString(arr));

        /*
            Returns correct sorted index of pivot. All the elements
            to the left of pivot are smaller than the pivot and all
            elements to the right of pivot are larger than the pivot.
         */

        int pivot = partition(arr, start, end);

        /*
            Recursion

            Execute left sub-array, i.e. indices start from start to pivot.

            Then, execute right sub-array, i.e. indices start from pivot + 1 to end.
         */

        quickSort(arr, start, pivot);

        quickSort(arr, pivot + 1, end);

    }

    public static int partition(int[] arr, int start, int end) {

        // This uses the first element as pivot
        int pivot = arr[start];

        System.out.println("\nThe value of pivot is - " + pivot);

        //Used to travel left to right
        int i = start;

        //Used to travel right to left
        int j = end;

        while(i < j) {

            //Decreasing j until we find first element lesser than pivot
            while(i < j && arr[--j] >= pivot);

            if(i < j) {

                /*
                    Moving the first element lesser than the pivot
                    to the position of i
                 */

                arr[i] = arr[j];

            }

            //Increasing i until we find first element greater than pivot
            while(i < j && arr[++i] <= pivot);

            if(i < j) {

                /*
                    Moving the first element greater than the pivot
                    to the position of j
                 */

                arr[j] = arr[i];

            }

        }

        arr[j] = pivot;

        System.out.println("\nArray after quick sort is - " + Arrays.toString(arr));

        return j;
    }

    public static void quickSortAlgorithm() {

        /*
            Quick Sort

            Divide and conquer algorithm

            Recursive algorithm

            Uses a pivot element to partition the array into two parts

            Elements less than pivot to its left, and elements greater
            than pivot are arranged to its right.

            Pivot will be then in its correct sorted position.

            Process is now repeated for the left array and right array

            Eventually, every element has been the pivot, so every element
            will be in its correct sorted position.

            Similar to the merge sort, we will end up partitioning the array
            into a series of 1-element arrays.

            Does this in-place (no temporary arrays are required)

            In this implementation, always used first element in the array
            (or subarray).

            Make start = 0, end = array.length

            Set i = start and j = end

            Set pivot = array[start]

            Start with --j (i.e. array[array.length - 1]

            If array[j] < pivot, assign array[j] to array[i] (which is
            initially zero).

            Now, we switch to i. Start with i++.

            If array[i] > pivot, assign array[i] to array[j] (which is
            now array.length - 1).

            Now, check if i < j (i.e. pointers have not crossed each other).

            Switch back to j, to look for the first element less than pivot.

            If array[j] < pivot, assign array[j] to array[i].

            Switch back to i, to look for the first element greater than pivot.

            When, i > j, assign array[i] = pivot.

            Repeat procedure until array is sorted (i.e. all elements are pivot)

            Time complexity - O(n * log2(n))

            Unstable Algorithm
         */

        System.out.println("\n********** QUICK SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        quickSort(arr, 0, arr.length);

    }

    public static void countingSort(int[] arr, int min, int max) {

        int[] countArray = new int[(max - min) + 1];

        for (int k : arr) {

            countArray[k - min]++;

        }

        System.out.println("\nCounting array is - " + Arrays.toString(countArray));

        int j = 0;

        for(int i = min; i <= max; i++) {

            while(countArray[i - min] > 0) {

                //Copying the values of i in the original array
                arr[j++] = i;

                //Reducing the count of i in counting array
                countArray[i - min]--;
            }

        }

        System.out.println("\nSorted array is - " + Arrays.toString(arr));

    }

    public static void countingSortAlgorithm() {

        /*
            Counting Sort

            Makes assumptions about the data

            Doesn't use comparisons

            Counts the number of occurrences of each value

            Only works with non-negative discrete values
            (Can't work with floats and strings)

            Values must be within a specific range

            Algorithm -

            Traverse the input array from left to right.

            Use the counting array to track how many of each value
            are in the input array.

            Using the counts in the counting array, write the values
            in the sorted order to the input array.

            Not an in-place algorithm (counting array needs to be created)

            Time complexity - O(n)

            For a stable sort, extra steps to be taken.
         */

        System.out.println("\n********** COUNTING SORT **********");

        int[] arr = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};

        countingSort(arr, 1, 10);

    }

    public static void stableCountingSortAlgorithm() {

        /*
            Create a count array as earlier.

            Create a temporary array that matches the length of array.

            We can use counts to figure out which range of indices in
            the temporary array will be occupied by each value.

            After the first pass, we adjust the counts. Instead of the
            number of values, we want to store how many values have a
            specific value or less.

            Write back to the temporary array as follows -

            n = array.length

            Code snippet -

            int[] tmp = new int[n];

            for(int k = n - 1; k >= 0; k--) {

                tmp[--countArray[getDigit(position, input[k], radix)] = input[k];

            }

            This works because we traverse the input array RTL, as well as
            we write duplicates in the temporary array from RTL.

            This preserves the relative positioning of duplicates.

            We can also use linked lists to make counting sort stable.
         */

    }

    public static int getDigit(int position, int value, int radix) {

        /*
            This method calculates the digit at position.

            For example, take 5937 as value and position as 0
            (i.e. 1s digit)

            So, Math.pow(10, 0) = 1.

            And 5937 / 1 = 5937.

            Here, radix is the base of number, which is base-10.

            Thus, final value => 5937 % 10 = 7.
         */

        return value / (int) Math.pow(10, position) % radix;

    }

    public static void radixSingleSort(int[] arr, int position, int radix) {

        int numOfElements = arr.length;

        int[] countArray = new int[radix];

        for(int element: arr) {

            countArray[getDigit(position, element, radix)]++;

        }

        //Implementing stable counting sort - Adjust cumulative sum

        for(int j = 1; j < radix; j++) {

            countArray[j] += countArray[j - 1];

        }

        int[] tmp = new int[numOfElements];

        for(int k = numOfElements - 1; k >= 0; k--) {

            //Please refer to the stableCountingSortAlgorithm

            tmp[--countArray[getDigit(position, arr[k], radix)]] = arr[k];

        }

        //Copy the elements to the original array
        System.arraycopy(tmp, 0, arr, 0, numOfElements);

        System.out.println("\nSorted array for " + (int) Math.pow(10, position) + "s position is - " + Arrays.toString(arr));

    }

    public static void radixSort(int[] arr, int radix, int width) {

        //Start with right-most bit, and then proceeds leftwards

        for(int position = 0; position < width; position++) {

            radixSingleSort(arr, position, radix);

        }

    }

    public static void radixSortAlgorithm() {

       /*
            Radix Sort

            Makes assumption about data

            Data must have same radix (as in all numbers in base-2, base-10)
            and width (as in all numbers are 4-digit, etc.)

            Data must be strings or integers

            Sort based on each individual digit or letter position

            Must use a stable algorithm at each stage

            Algorithm -

            Start with sorting the rightmost digit or character
            (This is the least significant bit)

            Then sort according to the second rightmost digit.
            Please note - The sort should be stable

            Keep doing until all digits or letters are covered

            Counting sort is often used as the sort algorithm.

            Time complexity - O(n)

            Although it performs worse than O(n * log2(n)) algorithms
            because of the overhead involved.

            In-place depends on which algorithm you use.

            Stable algorithm.
        */

        System.out.println("\n********** RADIX SORT **********");

        int[] arr = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(arr, 10, 4);

    }

    public static void sortingUsingJDK() {

        //System.out.println("\n***** SORTING ARRAYS USING JDK *****");

        //int[] arr = {20, 35, -15, 7, 55, 1, -22};

        /*
            Internally uses Dual Pivot Quick Sort Algorithm.

            Doesn't degrade as much as quick sort.

            Time complexity - O(n * log2(n))

            Uncomment to consume, and Ctrl/Cmd + Click to
            look through the source code.
         */

        //Arrays.sort(arr);

        /*
            Uses hybrid merge + Arrays.sort (i.e. Dual Pivot
            Quick Sort Algorithm)

            It breaks down the arrays and when it reaches down certain
            granularity, it uses Arrays.sort.

            Since, the operation run on parallel threads, it is
            a parallel sort.

            Uncomment to consume, and Ctrl/Cmd + Click to
            look through the source code.
         */

        //Arrays.parallelSort(arr);

        //System.out.println("\nArray after sort is - " + Arrays.toString(arr));
    }

    public static void doublePivotQuickSort(int[] arr, int start, int end) {

        /*
            Breaking condition -
            By default single element arrays are sorted
         */

        if(end - start < 2) {
            return;
        }

        /*
            Returns correct sorted index of pivot. All the elements
            to the left of pivot are smaller than the pivot and all
            elements to the right of pivot are larger than the pivot.
         */

        int[] pivots = doublePivotPartition(arr, start, end);

        /*
            Recursion

            Execute first sub-array, i.e. indices start from start to leftPivot - 1.

            Execute second sub-array, i.e. indices start from leftPivot to rightPivot - 1.

            Then, execute third sub-array, i.e. indices start from rightPivot to end.
         */

        doublePivotQuickSort(arr, start, pivots[0] - 1);

        doublePivotQuickSort(arr, pivots[0] + 1, pivots[1] - 1);

        doublePivotQuickSort(arr, pivots[1] + 1, end);

    }

    public static int[] doublePivotPartition(int[] arr, int start, int end) {

        if(arr[start] > arr[end]) {

            /*
                Swap positions if the leftmost element is greater than
                the rightmost element.
             */

            swap(arr, start, end);

        }

        // This uses the first element as left pivot
        int leftPivot = arr[start];

        // This uses the first element as left pivot
        int rightPivot = arr[end];

        System.out.println("\nThe value of left pivot is - " + leftPivot);

        System.out.println("\nThe value of right pivot is - " + rightPivot);

        //Used to store index of left pivot
        int leftPivotIndex = start + 1;

        //Used to store index of right pivot
        int rightPivotIndex = end - 1;

        //Used to traverse array
        int i = start + 1;

        while(i <= rightPivotIndex) {

            //Swap element to left if element is lesser than the leftPivot
            if(arr[i] < leftPivot) {
                swap(arr, i++, leftPivotIndex++);
            }

            /*
                Swap elements to the right if elements are greater than
                the rightPivot
             */
            else if(arr[i] > rightPivot) {
                swap(arr, i, rightPivotIndex--);
            }

            //Omit if both conditions are false
            else {
                i++;
            }
        }

        //Bring new leftPivot to the start of array
        swap(arr, start, --leftPivotIndex);

        //Bring new rightPivot to the start of array
        swap(arr, end, ++rightPivotIndex);

        System.out.println("\nArray after double pivot quick sort is - " + Arrays.toString(arr));

        return new int[] {leftPivotIndex, rightPivotIndex};
    }

    public static void doublePivotQuickSortAlgorithm() {

        /*
            Double Pivot Quick Sort Algorithm

            This uses two pivots instead of one.

            In our case, we will use array[0] and array[array.length - 1].

            We need to make sure that left pivot < right pivot.

            If not, we need to swap pivots.

            Now we divide array into three partitions as follows -

            In the first partition, all elements less than left pivot.

            In the second partition, all elements greater than left
            pivot and lesser than right pivot.

            In the third partition, all elements greater than right pivot.
         */

        System.out.println("\n********** DOUBLE PIVOT QUICK SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        doublePivotQuickSort(arr, 0, arr.length - 1);

    }

    public static void descendingMergeSort(int[] arr, int start, int end) {

        /*
            Breaking condition -
            By default single element arrays are sorted
         */

        if(end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        /*
            Recursion

            Execute left sub-array, i.e. indices start from start to mid.

            Then, execute right sub-array, i.e. indices start from mid to end.
         */

        System.out.println("\nLeft partition - " + Arrays.toString(Arrays.copyOfRange(arr, start, mid)));
        descendingMergeSort(arr, start, mid);

        System.out.println("\nRight partition - " + Arrays.toString(Arrays.copyOfRange(arr, mid, end)));
        descendingMergeSort(arr, mid, end);

        //Merge the arrays
        descendingMerge(arr, start, mid, end);

    }

    public static void descendingMerge(int[] arr, int start, int mid, int end) {

        /*
            mid - 1 is the last index of the left partition
            mid is the first index of the right partition

            If arr[mid - 1] > arr[mid], and since all elements in
            the left partition are already sorted, this tells all
            the elements in the left partition are less than the
            elements in the right partition.
         */

        if(arr[mid - 1] >= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tmpIndex = 0;
        int[] tmp = new int[end - start];

        while(i < mid && j < end) {

            tmp[tmpIndex++] = arr[i] >= arr[j] ? arr[i++] : arr[j++];

        }

        /*
              For left-over elements in left partition, i will be starting
              index of the elements which have not been accommodated in tmp

              The destination position will be start + tmpIndex, because the
              elements in the left partition need to jump tmpIndex places from
              start.

              The length will be mid - i, as it shows the number of elements
              which were not copied from the left partition.
         */

        System.arraycopy(arr, i, arr, start + tmpIndex, mid - i);

        /*
            This copies temporary array from start to tmpIndex.
         */

        System.arraycopy(tmp, 0, arr, start, tmpIndex);

        System.out.println("\nPartitions after merge - " + Arrays.toString(Arrays.copyOfRange(arr, start, end)));

    }

    public static void descendingMergeSortAlgorithm() {

        /*
            Descending Merge Sort -

            Divide and conquer algorithm

            Recursive algorithm

            Two phases - Splitting and Merging

            Splitting phase leads to faster sorting during merging

            Splitting is logical, no new arrays are created.

            Splitting phase -

            Start with an unsorted array.

            Divide the array into two, which are unsorted.
            (Get mid-point by (start + end)/2. For the first
            iteration, start = 0, end = array.length)

            The first array is left array, and the second array is right array.

            Keep splitting left and right arrays until all arrays have single element

            These new arrays are sorted arrays.

            Merging phase -

            Merge every left/right pair of sibling arrays.
            (Merging is done by keeping array with higher value at left,
            and lower value at right).

            After the first round of merge, we will have a bunch of
            two-element arrays.

            Then, merge these two-element arrays to end up with a bunch
            of four-element arrays.

            Repeat until there is a single sorted array.

            Not in-place algorithm, uses temporary arrays.

            Algorithm -

            Recursively split array into left array and right array.
            (Note - Only after splitting left array completely, we will
            be splitting right array)

            We merge sibling left and right arrays

            We create a temporary array large enough to hold all the
            elements in the array we're merging

            We set i = first index of left array
                   j = first index of right array

            We compare left[i] to right[j].
            If left[i] > right[j], we copy it to temporary array and
            Update i => i + 1
            If left[i] < right[j], we copy it to temporary array and
            Update j => j + 1

            We repeat the procedure until all elements in the two
            arrays are processed. Now, temporary array contains the
            merged values in sorted order.

            We then copy this temporary array back to the original
            input array, at the correct positions.

            If the left array is at positions x to y, and the right
            array is at y + 1 to z, then after the copy, positions
            x to z will be sorted in the original array.

            Time complexity - O(n * log2(n))

            Stable Algorithm
         */

        System.out.println("\n********** DESCENDING MERGE SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        descendingMergeSort(arr, 0, arr.length);
    }

    public static void recursiveInsertionSort(int[] arr, int numberOfItemsToBeSorted) {

        /*
            Breaking call - If the numberOfItemsToBeSorted < 2, i.e. first element,
            it is by default always sorted
         */

        if(numberOfItemsToBeSorted < 2) {
            return;
        }

        recursiveInsertionSort(arr, numberOfItemsToBeSorted - 1);

        int newElement = arr[numberOfItemsToBeSorted - 1];

        int i;

        for(i = numberOfItemsToBeSorted - 1; i > 0 && arr[i - 1] > newElement; i--) {
            arr[i] = arr[i - 1];
        }

        arr[i] = newElement;

        System.out.println("\nArray after step " + (numberOfItemsToBeSorted - 1) + " - " + Arrays.toString(arr));

    }

    public static void recursiveInsertionSortAlgorithm() {

        System.out.println("\n********** RECURSIVE INSERTION SORT **********");

        int[] arr = {20, 35, -15, 7, 55, 1, -22};

        recursiveInsertionSort(arr, arr.length);

    }

    public static int getCharacterIndex(int position, String value) {

        /*
            This method returns character's index in counting array.

            To calculate we first get character at the given position.

            Next, we subtract the ASCII value of the first element of
            counting array ('a' in our case).
         */

        return value.charAt(position) - 'a';

    }

    public static void stringRadixSingleSort(String[] arr, int position, int radix) {

        int numOfElements = arr.length;

        int[] countArray = new int[radix];

        for(String element: arr) {

            countArray[getCharacterIndex(position, element)]++;

        }

        //Implementing stable counting sort - Adjust cumulative sum

        for(int j = 1; j < radix; j++) {

            countArray[j] += countArray[j - 1];

        }

        String[] tmp = new String[numOfElements];

        for(int k = numOfElements - 1; k >= 0; k--) {

            //Please refer to the stableCountingSortAlgorithm

            tmp[--countArray[getCharacterIndex(position, arr[k])]] = arr[k];

        }

        //Copy the elements to the original array
        System.arraycopy(tmp, 0, arr, 0, numOfElements);

        System.out.println("\nSorted array for " + (position + 1) + " position is - " + Arrays.toString(arr));

    }

    public static void stringRadixSort(String[] arr, int radix, int width) {

        //Start with right-most character, and then proceeds leftwards

        for(int position = width - 1; position >= 0; position--) {

            stringRadixSingleSort(arr, position, radix);

        }

    }

    public static void stringRadixSortAlgorithm() {

        System.out.println("\n********** STRING RADIX SORT **********");

        String[] arr = {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"};

        stringRadixSort(arr, 26, 5);

    }
}
