import java.util.InputMismatchException;
import java.util.Scanner;

class dsa_array {
    Scanner sc = new Scanner(System.in);
    int[] Array;
    int[] Array1;
    int[] Array2;
    int[] array1, array2, array3;
    int size, size1, size2, size3, maxsize, maxsize1;

    void Array_input() {
        while (true) {
            try {
                System.out.println("Please enter the size of the first Array ypu want to Create:\t");
                size = sc.nextInt();

                System.out.println("Please enter How many elements you want to add in your  first Array:\t");
                maxsize = sc.nextInt();

                System.out.println("Please enter the size of the Second  Array ypu want to Create:\t");
                size1 = sc.nextInt();

                System.out.println("Please enter How many elements you want to add in your  Second Array:\t");
                maxsize1 = sc.nextInt();

                if (size > 0 && maxsize > 0 && maxsize <= size) {
                    Array = new int[size];
                    Array1 = new int[size1];
                    Array_Creation(maxsize, maxsize1);
                    break;
                } else {
                    System.out.println("Re - try");
                }

            } catch (InputMismatchException e) {
                System.out.println("Errors");
                sc.next();
            }
        }
    }

    void Array_Creation(int maxsize, int maxsize1) {
        for (int i = 0; i < maxsize; i++) {
            while (true) {
                try {
                    System.out.println("Enter the Elements to the first Array of Index\t" + i);
                    Array[i] = sc.nextInt();
                    break;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error");
                    Array_Creation(maxsize, maxsize1);
                }
            }
        }

        for (int i = 0; i < maxsize1; i++) {
            while (true) {
                try {
                    System.out.println("Enter the Elements to the second Array at Index\t" + i);
                    Array1[i] = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error");
                    Array_Creation(maxsize, maxsize1);
                }
            }
        }
        Array_option();
    }

    void Array_Traversing() {
        int lower_bound = 0;
        int upper_bound = Array.length;
        while (lower_bound < upper_bound) {
            System.out.println(" first Array for index\t" + lower_bound + "\t" + Array[lower_bound]);
            lower_bound += 1;
        }
        System.out.println("\n");

        int lower_bound1 = 0;
        int upper_bound1 = Array1.length;
        while (lower_bound1 < upper_bound1) {
            System.out.println(" Second Array for index\t" + lower_bound1 + "\t" + Array1[lower_bound1]);
            lower_bound1 += 1;
        }
    }

    void Array_Insertion() {
        int pos, num, n = Array.length;

        System.out.println("Number of elements in Your Array is:");
        for (int i = 0; i < size; i++) {
            System.out.println("Array of index\t" + i + "\t" + Array[i]);
        }

        while (true) {
            try {

                // if (size >= n) {
                // System.out.println("The array is full.");
                // break;
                // }

                System.out.println("Enter the Number to be Inserted in Your Array:");
                num = sc.nextInt();

                System.out.println("Enter the Position where you want to insert the number:");
                pos = sc.nextInt();

                if (pos < 0 || pos > n) {
                    System.out.println("Invalid Position");
                    continue;
                }

                for (int i = n - 2; i >= pos; i--) {
                    Array[i + 1] = Array[i];
                }
                Array[pos] = num;
                n++;
                System.out.println("Number inserted successfully.");
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
                sc.nextLine();
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error");
            }
        }

    }

    void Array_Deletion() {

        System.out.println("Number of elements in Your Array is:");
        for (int i = 0; i < size; i++) {
            System.out.println("Array of index\t" + i + "\t" + Array[i]);
        }

        System.out.println("Enter the Index Number from which the Number has to been Deleted:");
        int pos = sc.nextInt();

        if (pos < 0 || pos > size) {
            System.out.println("Invalid Position");
            // continue;
        }

        for (int j = pos; j < size - 1; j++) {
            Array[j] = Array[j + 1];
        }
        size -= 1;

        System.out.println("Array After Deleting an Number from a particular Index Number:");
        for (int i = 0; i < size; i++) {
            System.out.println("Array of index\t" + i + "\t" + Array[i]);
        }
    }

    void Array_Linear_search() {

        System.out.println("PLease Enter the elements you want to search in your Created Array:");
        int number = sc.nextInt();
        int i = 0;
        int found = 0;

        do {
            if (number == Array[i]) {
                found = 1;
                break;
            }
            i++;
        } while (i < size);

        if (found == 1) {
            System.out.println("Element found in The Arrays");
        } else {
            System.out.println("Element not Found");
        }
    }

    void Array_Binary_search() {
        System.out.println("PLease Enter the elements you want to search in your Created Array:");
        int number = sc.nextInt();
        int start = 0;
        int end = Array.length - 1;
        int flag = 0;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (Array[middle] == number) {
                System.out.println("Element found :\t" + middle);
                flag = 1;
                break;
            } else if (Array[middle] < number) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        if (flag == 0) {
            System.out.println("Element not found");
        }

    }

    void Array_Bubble_Sorting() {
        System.out.println("elements in Your Array Before Bubble Sorting:");
        for (int i = 0; i < size; i++) {
            System.out.println("Array of index\t" + i + "\t" + Array[i]);
        }
        int p = 0;
        int n = size;
        while (p < n - 1) {
            int j = 0;
            while (j < n - p - 1) {
                if (Array[j] > Array[j + 1]) {
                    int temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                }
                j++;
            }
            p++;
        }
        System.out.println("elements in Your Array After Bubble Sorting :");
        for (int i = 0; i < size; i++) {
            System.out.println("Array of index\t" + i + "\t" + Array[i]);
        }
    }

    void Array_merging() {
        // System.out.println("elements in Your Array Before Merging Two Array:");
        // for (int i = 0; i < size; i++) {
        // System.out.println("first and Second Array of index\t" + i + "\t" + Array[i]
        // + "\t" + Array1[i]);
        // }
        // size2 = size + size1;
        // int[] Array2 = new int[size2];

        // for (int i = 0; i < Array.length; i++) {
        // Array2[i] = Array[i];
        // }

        // for (int i = 0; i < Array1.length; i++) {
        // Array2[size + i] = Array1[i];
        // }

        // System.out.println("elements in Your Array after Merging Two Array:");
        // for (int i = 0; i < Array2.length; i++) {
        // System.out.println("final Array of index\t" + i + "\t" + Array2[i]);
        // }
        System.out.println("Choose One Option:\n");
        System.out.println("1.Sorted Array");
        System.out.println("2. Un - Sorted Array");

        int answer = sc.nextInt();

        switch (answer) {
            case 1:
                System.out.println("You have Selected Sorted Array:");
                Array_sorted_array();
            case 2:
                System.out.println("You have Selected Sorted Array:");
                Array_Unsorted_array();

        }

    }

    void Array_sorted_array() {
        System.out.println("Please enter the size of the first Array ypu want to Create:\t");
        size1 = sc.nextInt();

        System.out.println("Please enter How many elements you want to add in your  first Array:\t");
        maxsize = sc.nextInt();

        array1 = new int[size1];

        for (int i = 0; i < maxsize; i++) {
            while (true) {
                try {
                    System.out.println("Enter the Elements to the first Array of Index\t" + i);
                    array1[i] = sc.nextInt();
                    break;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error");
                }
            }
        }

        System.out.println("Please enter the size of the Second  Array ypu want to Create:\t");
        size2 = sc.nextInt();

        System.out.println("Please enter How many elements you want to add in your  Second Array:\t");
        maxsize1 = sc.nextInt();

        array2 = new int[size1];

        for (int i = 0; i < maxsize1; i++) {
            while (true) {
                try {
                    System.out.println("Enter the Elements to the second Array at Index\t" + i);
                    array2[i] = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error");
                    Array_Creation(maxsize, maxsize1);
                }
            }
        }

        System.out.println("elements in Your Array Before Merging Two Array:");
        for (int i = 0; i < size1; i++) {
            System.out.println("first and Second array of index\t" + i + "\t" + array1[i]
                    + "\t" + array2[i]);
        }
        size3 = size1 + size2;
        array3 = new int[size3];

        int a = 0, b = 0, k = 0;
        while ((a <= array1.length - 1) && (b <= array2.length - 1)) {
            if (array1[a] < array2[b]) {
                array3[k] = array1[a];
                a++;
                k++;
            } else {
                array3[k] = array2[b];
                b++;
                k++;
            }
        }

        if (a > array1.length) {
            while (b <= array2.length) {
                array3[k] = array2[b];
                b++;
                k++;
            }
        } else if (b > array2.length) {
            while (a <= array1.length) {
                array3[k] = array1[a];
                a++;
                k++;
            }
        }

        System.out.println("elements in Your Array after Merging Two Sorted Array:");
        for (int i = 0; i < array3.length; i++) {
            System.out.println("final Array of index\t" + i + "\t" + array3[i]);
        }

    }

    void Array_Unsorted_array() {
        System.out.println("Please enter the size of the first Array ypu want to Create:\t");
        size1 = sc.nextInt();

        System.out.println("Please enter How many elements you want to add in your  first Array:\t");
        maxsize = sc.nextInt();

        array1 = new int[size1];

        for (int i = 0; i < maxsize; i++) {
            while (true) {
                try {
                    System.out.println("Enter the Elements to the first Array of Index\t" + i);
                    array1[i] = sc.nextInt();
                    break;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error");
                }
            }
        }

        System.out.println("Please enter the size of the Second  Array ypu want to Create:\t");
        size2 = sc.nextInt();

        System.out.println("Please enter How many elements you want to add in your  Second Array:\t");
        maxsize1 = sc.nextInt();

        array2 = new int[size1];

        for (int i = 0; i < maxsize1; i++) {
            while (true) {
                try {
                    System.out.println("Enter the Elements to the second Array at Index\t" + i);
                    array2[i] = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error");
                    Array_Creation(maxsize, maxsize1);
                }
            }
        }

        System.out.println("elements in Your Array Before Merging Two Array:");
        for (int i = 0; i < size1; i++) {
            System.out.println("first and Second array of index\t" + i + "\t" + array1[i]
                    + "\t" + array2[i]);
        }
        size3 = size1 + size2;
        array3 = new int[size3];

        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            array3[size1 + i] = array2[i];
        }

        System.out.println("elements in Your Array after Merging Two  Un-Sorted-Array:");
        for (int i = 0; i < array3.length; i++) {
            System.out.println("final Array of index\t" + i + "\t" + array3[i]);
        }
    }

    void Array_option() {
        System.out.println("Please Enter the Option From the Given Below:");
        System.out.println("1.-\tTraversing");
        System.out.println("2.-\tInsertion");
        System.out.println("3.-\tDeletion");
        System.out.println("4.-\tLinear Search");
        System.out.println("5.-\tBinary Search");
        System.out.println("6.-\tBubble Sorting");
        System.out.println("7.-\tMerging Array");
        System.out.println("8-\tExit");
        try {
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Traversing Method");
                    Array_Traversing();
                    break;
                case 2:
                    System.out.println("Insertion");
                    Array_Insertion();
                    break;
                case 3:
                    System.out.println("Deletion");
                    Array_Deletion();
                    break;
                case 4:
                    System.out.println("Linear Search");
                    Array_Linear_search();
                    break;
                case 5:
                    System.out.println("binary Search");
                    Array_Binary_search();
                    break;
                case 6:
                    System.out.println("Bubble Sorting");
                    Array_Bubble_Sorting();
                    break;
                case 7:
                    System.out.println("Merging Array");
                    Array_merging();
                    break;
                case 8:
                    System.out.println("Exit");
                    System.exit(option);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error, Re-try");
        }

        System.out.println("Do you Still Want To Continue Then press Y and if Not then press N");
        sc.nextLine();
        String Answer = sc.nextLine();
        if (Answer.equalsIgnoreCase("Y")) {
            System.out.println("Welcome Back");
            Array_option();
        }
    }

    public static void main(String[] args) {
        dsa_array DA = new dsa_array();
        // DA.Array_input();
        DA.Array_merging();
    }
}
