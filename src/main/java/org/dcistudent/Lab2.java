package org.dcistudent;

import java.util.ArrayList;
import java.util.List;

public class Lab2 {
  public static void main(String[] args) {
    Lab2.exercise1();
    Lab2.exercise2();
  }

  // 1. Closest Number to Zero
  // Given an integer array nums of size n, return the number with the value closest to 0 in nums.
  // If there are multiple answers, return the number with the largest value.
  private static void exercise1() {
    System.out.println("Lab 2 - Exercise 1:");

    List<Integer> numbers = new ArrayList<>(List.of(-10, -5, -2, 4, 5, 6, 7, 8, 9, 10));
    int closestToZero = numbers
        .stream()
        .sorted((a, b) -> {
          if (Math.abs(a) == Math.abs(b)) {
            return b - a;
          }
          return Math.abs(a) - Math.abs(b);
        })
        .findFirst()
        .orElse(0);
    System.out.println(closestToZero);

    System.out.println("--------------------------------------------------");
  }

  // 2. Subsequence Check
  // Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
  // A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
  // of the characters without disturbing the relative positions of the remaining characters.
  private static void exercise2() {
    System.out.println("Lab 2 - Exercise 2:");

    final String[] s = {"abc"};
    String t = "ahbgdc";
    t.chars()
        .filter(c -> c == s[0].charAt(0))
        .forEach(c -> s[0] = s[0].substring(1));
    System.out.println(s[0].isEmpty());

    final String[] s2 = {"axc"};
    String t2 = "ahbgdc";
    t2.chars()
        .filter(c -> c == s2[0].charAt(0))
        .forEach(c -> s2[0] = s2[0].substring(1));
    System.out.println(s2[0].isEmpty());

    System.out.println("--------------------------------------------------");
  }
}
