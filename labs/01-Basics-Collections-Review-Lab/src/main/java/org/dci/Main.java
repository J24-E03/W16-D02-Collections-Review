package org.dci;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        listTasks();
        mapTasks();


    }

    private static void listTasks() {
        findTheSecondLargest();
        removeDuplicates();
        sumOfElements();
        checkPalindrome();
        findLongestSublist();

    }

    private static void mapTasks() {
        frequencyMapMaker();
        mergeTwoMaps();
        findMaxKeyValue();
        sortMapByValue();
        groupStudents();

    }


    private static List<Integer> populateListOfNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }

    private static void findTheSecondLargest() {
        List<Integer> numbers = populateListOfNumbers(new Random().nextInt(20) + 1);

        Integer firstMax = Integer.MIN_VALUE;
        Integer secondMax = Integer.MIN_VALUE;

        for (int num : numbers) {
            if (num > firstMax) {
                firstMax = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        System.out.println("\nArray of numbers: " + numbers);
        System.out.println("The second Largest number is: " + secondMax);
    }

    private static void removeDuplicates() {
        List<String> stringList = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange", "banana", "pomegranate", "grape", "kiwi", "pomegranate"));
        List<String> nonduplicateList = new ArrayList<>();
        for (String str : stringList) {
            if (!nonduplicateList.contains(str)) {
                nonduplicateList.add(str);
            }
        }
        System.out.println("\nOriginal List: " + stringList);
        System.out.println("Non-duplicate List: " + nonduplicateList);
    }

    private static void sumOfElements() {
        List<Integer> numbers = populateListOfNumbers(new Random().nextInt(20) + 1);
        System.out.println("\nArrayList of numbers: " + numbers);
        try {
            int startIndex = new Random().nextInt(numbers.size());
            int endIndex = new Random().nextInt(numbers.size() + 1);
            if (startIndex > endIndex) {
                int temp = startIndex;
                startIndex = endIndex;
                endIndex = temp;
            }
            Integer sum = calculateSumBetweenTwoIndexes(numbers, startIndex, endIndex);
            System.out.printf("Sum of the ArrayList starts from index %d ends to index %d is equal to %d\n", startIndex, endIndex, sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static int calculateSumBetweenTwoIndexes(List<Integer> numbers, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= numbers.size()) {
            throw new IllegalArgumentException(String.format("startsIndex: %d, EndIndex: %d, ArrayList Size: %d. Indexes out of bound!", startIndex, endIndex, numbers.size()));
        }
        return numbers.subList(startIndex, endIndex).stream().mapToInt(num -> num).sum();
    }

    private static void checkPalindrome() {
        List<Character> characterList1 = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'd', 'c', 'b', 'a'));
        List<Character> characterList2 = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'a'));

        System.out.println("\nArray List: " + characterList1 + " is palindrome? " + isListPalindrome(characterList1));
        System.out.println("Array List: " + characterList2 + " is palindrome? " + isListPalindrome(characterList2));
    }

    private static boolean isListPalindrome(List<Character> characters) {
        if (characters.isEmpty()) {
            return true;
        }

        for (int i = 0; i < characters.size() / 2; i++) {
            if (characters.get(i) != characters.get(characters.size() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private static void findLongestSublist() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 4, 20, 5, 1, 3, 2));
        System.out.println("\nLength of the longest consecutive sublist: " + findLongestConsecutiveSublist(numbers));
    }

    private static int findLongestConsecutiveSublist(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }
        Collections.sort(numbers);
        int maxLength = 1;
        int tempLength = 1;

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) == numbers.get(i - 1) + 1) {
                tempLength++;
            } else if (numbers.get(i) != numbers.get(i - 1)) {
                tempLength = 1;
            }
            maxLength = Math.max(maxLength, tempLength);
        }

        return maxLength;
    }

    private static void frequencyMapMaker() {
        List<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange", "banana", "pomegranate", "grape", "kiwi", "pomegranate"));
        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : words) {
            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nlist of words: " + words);
        System.out.println("frequency of each word: " +wordsMap);
    }

    private static void mergeTwoMaps() {
        Map<String, Integer> wordMap1 = new HashMap<>();
        Map<String, Integer> wordMap2 = new HashMap<>();

        wordMap1.put("apple", 3);
        wordMap1.put("banana", 1);
        wordMap1.put("kiwi", 2);
        wordMap1.put("mango", 4);
        wordMap1.put("strawberry", 3);
        wordMap1.put("pomegranate", 1);

        wordMap2.put("apple", 1);
        wordMap2.put("watermelon", 2);
        wordMap2.put("tomato", 8);
        wordMap2.put("kiwi", 2);
        wordMap2.put("raspberry", 3);
        wordMap2.put("banana", 4);
        wordMap2.put("avocado", 8);

        System.out.println("WordMap1: " + wordMap1);
        System.out.println("WordMap2: " + wordMap2);

        for (String word : wordMap2.keySet() ) {
            wordMap1.put(word, wordMap1.getOrDefault(word, 0) + wordMap2.get(word));
        }

        System.out.println("Merged WordMap: " + wordMap1);
    }

    private static void findMaxKeyValue() {
        Map<String, Integer> wordMap = new HashMap<>();

        wordMap.put("apple", 3);
        wordMap.put("banana", 1);
        wordMap.put("kiwi", 2);
        wordMap.put("mango", 4);
        wordMap.put("strawberry", 3);
        wordMap.put("pomegranate", 5);
        wordMap.put("watermelon", 2);
        wordMap.put("tomato", 8);
        wordMap.put("raspberry", 3);
        wordMap.put("avocado", 8);

        System.out.println("\nMap of words: " + wordMap);

        wordMap.entrySet().stream().max(Map.Entry.comparingByValue()).ifPresent(maxEntry -> {
            System.out.printf("First max repeated Word is \"%s\" and it has a frequency of %d.\n",
                    maxEntry.getKey(), maxEntry.getValue());
        });
    }

    private static void sortMapByValue() {
        Map<String, Integer> wordMap = new HashMap<>();

        wordMap.put("apple", 3);
        wordMap.put("banana", 1);
        wordMap.put("kiwi", 2);
        wordMap.put("mango", 4);
        wordMap.put("strawberry", 3);
        wordMap.put("pomegranate", 5);
        wordMap.put("watermelon", 2);
        wordMap.put("tomato", 8);
        wordMap.put("raspberry", 3);
        wordMap.put("avocado", 8);

        System.out.println("\nMap of words: " + wordMap);
        System.out.println("Sorted Map by Value (Descending Order):");
        Comparator<Map.Entry<String, Integer>> comparator =
                (o1, o2) -> o2.getValue().compareTo(o1.getValue());
        System.out.println(wordMap.entrySet().stream()
                .sorted(comparator)
                .toList());
    }

    private static void groupStudents() {
        List<Student> students = new ArrayList<>(
                Arrays.asList(
                        new Student("student1", 'A'),
                        new Student("student2", 'B'),
                        new Student("student3", 'C'),
                        new Student("student4", 'B'),
                        new Student("student5", 'D'),
                        new Student("student6", 'A'),
                        new Student("student7", 'C'),
                        new Student("student8", 'B'),
                        new Student("student9", 'D'),
                        new Student("student10", 'A'),
                        new Student("student11", 'D'),
                        new Student("student12", 'A'),
                        new Student("student13", 'B'),
                        new Student("student14", 'D')
                )
        );

        Map<Character, List<Student>> studentScoreMap = students.stream().collect(Collectors.groupingBy(student -> student.getScore()));
        System.out.println("List of students, grouped by their scores:");
        studentScoreMap.forEach((key, value) -> {
            System.out.println("Grade: " + key);
            value.forEach(System.out::println);
        });
    }
}