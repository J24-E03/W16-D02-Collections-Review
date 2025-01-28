package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayAndMapsInJava {
    public void main(String[] args) {

        // 1.1:
        int[] arr = {10, 20, 4, 45, 99, 99, 67};
        int secondLargest = findSecondLargest(arr);

        if (secondLargest == Integer.MIN_VALUE) {
            System.out.println("There is no second largest element.");
        } else {
            System.out.println("The second largest element is: " + secondLargest);
        }

        // 1.2:
        testingArrays();

        // 1.4:
        if (canFormPalindrome("geeksforgeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");

        if (canFormPalindrome("geeksogeeks"))
            System.out.println("Yes");
        else
            System.out.println("No");


        // 1.5:
        LargestSubArray2 large = new LargestSubArray2();
        int arr3[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        int n = arr3.length;
        System.out.println("Length of the longest contiguous subarray is "
                + large.findLength(arr3, n));


        // 2.1:
        String str = "Java Backend Developer";
        count_freq(str);

        // 2.2:
        // creating two maps to store key-value pair
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        // adding values to the two maps
        // adding similar key in the two maps
        map1.put("key", 1);
        map2.put("key", 5);
        map1.put("Key1", 2);
        map2.put("key2", 4);
        map2.put("Key2", 4);
        // using the putAll function to add all elements in
        // one map
        map1.putAll(map2);
        System.out.println("The resultant map is : " + map1);

        // 2.3:

        // Creating a Map
        // Declaring object of string and integer type
        Map<String, Integer> map = new HashMap<>();

        // Inserting elements in the Map object
        // using put() method
        // Custom input element addition
        map.put("ABC", 10);
        map.put("DEF", 30);
        map.put("XYZ", 20);

        // Calling method 2 to
        // print the map
        System.out.println(map);

        // Calling method 1 to
        // find the entry with the highest value and
        // print on the console
        System.out.println(
                "Entry with highest value: "
                        + getMaxEntryInMapBasedOnValue(map));


        // 2.4 (method calling):
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        Map<String, Integer> hm1 = LargestSubArray2.sortByValue(hm);

        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                    ", Value = " + en.getValue());
        }


        // 2.5:

        List<LargestSubArray2.Student> students = List.of(
                new LargestSubArray2.Student("Juan", "A", 8),
                new LargestSubArray2.Student("Pedro", "B", 5),
                new LargestSubArray2.Student("Maria", "B", 8),
                new LargestSubArray2.Student("Eugenia", "C", 5)
        );

        Map<String, List<String>> groupedByGradePassed = students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.gradeLevel,
                        Collectors.filtering(
                                student -> student.score >= 4,
                                Collectors.mapping(LargestSubArray2.Student::getName, Collectors.toList())
                        )
                ));

        System.out.println(groupedByGradePassed);

    }


    // 3:
    // Function to find the valid indices
    static void find_idx(int arr2[], int n) {
        arr2 = new int[]{36, 2, 17, 6, 6, 5};
        n = arr2.length;

        find_idx(arr2, n);

        // Vector to store the indices
        Vector answer = new Vector();

        // Initialise sum with 0
        int sum = 0;

        // Starting from the last element
        for (int i = n - 1; i >= 0; i--) {

            // If sum till now is equal to
            // the current element
            if (sum == arr2[i]) {
                answer.add(i);
            }

            // Add current element to the sum
            sum += arr2[i];
        }

        if (answer.size() == 0) {
            System.out.println("-1");
            return;
        }

        for (int i = answer.size() - 1; i >= 0; i--)
            System.out.print(answer.get(i) + " ");
    }


    public static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    public static void testingArrays() {
        List<Integer> mylist2 = new ArrayList<Integer>();

        List<Integer> mylist1 = new ArrayList<Integer>();
        mylist1.add(3);
        mylist1.add(3);
        mylist1.add(5);
        mylist1.add(9);
        mylist1.add(2);
        mylist1.add(5);
        mylist1.add(5);
        mylist1.add(3);
        mylist1.add(3);
        mylist1.add(3);
        mylist1.add(9);
        mylist1.add(56);
        System.out.println(mylist1);
        Iterator<Integer> itr1 = mylist1.listIterator();
        while (itr1.hasNext()) {
            Integer itn1 = (Integer) itr1.next();
            if (mylist2.contains(itn1) == false)
                mylist2.add(itn1);
        }
    }

    static int NO_OF_CHARS = 256;

    /* function to check whether characters
    of a string can form a palindrome */
    static boolean canFormPalindrome(String str) {

        // Create a count array and initialize all
        // values as 0
        int count[] = new int[NO_OF_CHARS];
        Arrays.fill(count, 0);

        // For each character in input strings,
        // increment count in the corresponding
        // count array
        for (int i = 0; i < str.length(); i++)
            count[(int) (str.charAt(i))]++;

        // Count odd occurring characters
        int odd = 0;
        for (int i = 0; i < NO_OF_CHARS; i++) {
            if ((count[i] & 1) == 1)
                odd++;

            if (odd > 1)
                return false;
        }

        // Return true if odd count is 0 or 1,
        return true;
    }

    class LargestSubArray2 {
        // Utility functions to find minimum and maximum of
        // two elements

        int min(int x, int y) {
            return (x < y) ? x : y;
        }

        int max(int x, int y) {
            return (x > y) ? x : y;
        }

        // Returns length of the longest contiguous subarray
        int findLength(int arr[], int n) {
            int max_len = 1;  // Initialize result
            for (int i = 0; i < n - 1; i++) {
                // Initialize min and max for all subarrays starting with i
                int mn = arr[i], mx = arr[i];

                // Consider all subarrays starting with i and ending with j
                for (int j = i + 1; j < n; j++) {
                    // Update min and max in this subarray if needed
                    mn = min(mn, arr[j]);
                    mx = max(mx, arr[j]);

                    // If current subarray has all contiguous elements
                    if ((mx - mn) == j - i)
                        max_len = max(max_len, mx - mn + 1);
                }
            }
            return max_len;  // Return result
        }


        // 2.4 (only method)
        // function to sort hashmap by values
        public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
            // Create a list from elements of HashMap
            List<Map.Entry<String, Integer>> list =
                    new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

            // Sort the list
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1,
                                   Map.Entry<String, Integer> o2) {
                    return (o1.getValue()).compareTo(o2.getValue());
                }
            });

            // put data from sorted list to hashmap
            HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
            for (Map.Entry<String, Integer> aa : list) {
                temp.put(aa.getKey(), aa.getValue());
            }
            return temp;
        }


        static class Student {
            public String name;
            public String gradeLevel;
            public int score;

            Student(final String name, final String gradeLevel, final int score) {
                this.name = name;
                this.gradeLevel = gradeLevel;
                this.score = score;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }

    // Function to count frequency of
    // words in the given string
    public static void count_freq(String str) {
        Map<String, Integer> mp = new TreeMap<>();

        // Splitting to find the word
        String arr[] = str.split(" ");

        // Loop to iterate over the words
        for (int i = 0; i < arr.length; i++) {
            // Condition to check if the
            // array element is present
            // the hash-map
            if (mp.containsKey(arr[i])) {
                mp.put(arr[i], mp.get(arr[i]) + 1);
            } else {
                mp.put(arr[i], 1);
            }
        }

        // Loop to iterate over the
        // elements of the map
        for (Map.Entry<String, Integer> entry :
                mp.entrySet()) {
            System.out.println(entry.getKey() +
                    " - " + entry.getValue());
        }
    }


    // Method 1
    // Find the entry with the highest value
    public static <K, V extends Comparable<V> >
    Map.Entry<K, V>
    getMaxEntryInMapBasedOnValue(Map<K, V> map)
    {

        // To store the result
        Map.Entry<K, V> entryWithMaxValue = null;

        // Iterate in the map to find the required entry
        for (Map.Entry<K, V> currentEntry :
                map.entrySet()) {

            if (
                // If this is the first entry, set result as
                // this
                    entryWithMaxValue == null

                            // If this entry's value is more than the
                            // max value Set this entry as the max
                            || currentEntry.getValue().compareTo(
                            entryWithMaxValue.getValue())
                            > 0) {

                entryWithMaxValue = currentEntry;
            }
        }

        // Return the entry with the highest value
        return entryWithMaxValue;
    }

    // Method 2
    // To print the map
    public static void print(Map<String, Integer> map)
    {

        System.out.print("Map: ");

        // If map does not contain any value
        if (map.isEmpty()) {

            System.out.println("[]");
        }
        else {
            System.out.println(map);
        }
    }
}





