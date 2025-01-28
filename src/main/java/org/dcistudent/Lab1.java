package org.dcistudent;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lab1 {
  public static void main(String[] args) {
    Lab1.exercise1();
    Lab1.exercise2();
    Lab1.exercise3();
    Lab1.exercise4();
    Lab1.exercise5();
  }

  // 1. Find the second-largest number
  // Given an ArrayList<Integer> containing integers, write a method to find the second-largest number in the list.
  // Do not use any sorting algorithms.
  private static void exercise1() {
    System.out.println("Lab 1 - Exercise 1:");

    List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    numbers
        .stream()
        .sorted(Comparator.reverseOrder())
        .skip(1)
        .findFirst()
        .ifPresent(System.out::println);

    System.out.println("--------------------------------------------------");
  }

  // 2. Remove all duplicates
  // Given an ArrayList<String>, write a method to remove all duplicate values in the list while maintaining the order
  // of the first occurrences. The list should only contain unique elements after the method runs.
  private static void exercise2() {
    System.out.println("Lab 1 - Exercise 2:");

    List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    numbers
        .stream()
        .distinct()
        .forEach(System.out::println);

    System.out.println("--------------------------------------------------");
  }

  // 3. Sum of all elements in a range
  // Given an ArrayList<Integer>, write a method to find the sum of all elements between two indices startIndex and
  // endIndex (both inclusive). If the indices are out of bounds, the method should return 0.
  private static void exercise3() {
    System.out.println("Lab 1 - Exercise 3:");

    List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    int startIndex = 2;
    int endIndex = 5;

    int sum = numbers
        .stream()
        .skip(startIndex)
        .limit((long) endIndex - startIndex + 1)
        .reduce(0, Integer::sum);

    System.out.println(sum);

    System.out.println("--------------------------------------------------");
  }

  // 4. Find if the list is a palindrome
  // Write a method to determine if an ArrayList<Character> forms a palindrome.
  // A palindrome reads the same forwards and backwards. If it does, return true; otherwise, return false.
  private static void exercise4() {
    System.out.println("Lab 1 - Exercise 4:");

    List<Character> characters = new ArrayList<>(List.of('r', 'o', 't', 'a', 't', 'o', 'r'));
    boolean isPalindrome = characters
        .equals(
            new ArrayList<>(characters)
                .stream()
                .sorted(Comparator.reverseOrder()).toList()
        );

    System.out.println(isPalindrome);


    System.out.println("--------------------------------------------------");
  }

  // 5. Find the longest sublist with consecutive elements
  // Given an ArrayList<Integer>, find the length of the longest sublist that contains consecutive numbers.
  // For example, for the input [10, 4, 20, 5, 1, 3, 2], the result should be 5 because [4, 5, 1, 3, 2] is the longest
  // consecutive sublist.
  private static void exercise5() {
    System.out.println("Lab 1 - Exercise 5:");

    List<Integer> numbers = new ArrayList<>(List.of(10, 4, 20, 5, 1, 3, 2));
    int longestSublist = numbers
        .stream()
        // 0 is the initial value for the accumulator (representing the current maximum length).
        // max: The current maximum length found so far.
        // current: The current integer being processed from the stream.
        .reduce(0, (max, current) -> {
          // count = 1: Initializes a counter for the current sublist length to 1.
          int count = 1;
          //  This loop iterates as long as the next consecutive number (current + count) is found within the numbers
          //  list.
          //  If found, the count is incremented.
          while (numbers.contains(current + count)) {
            count++;
          }

          // Returns the maximum between the current max and the calculated count of the current sublist.
          return Math.max(max, count);
        });

    System.out.println(longestSublist);

    System.out.println("--------------------------------------------------");
  }
}
