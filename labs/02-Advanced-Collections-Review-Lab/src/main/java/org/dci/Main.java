package org.dci;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        findClosestNumToZero();

        checkSubSequence();
    }

    private static void findClosestNumToZero() {
        int[] numbers = generateRandomArray();
        System.out.println("array of numbers: " + Arrays.toString(numbers));


        int closestNumber =  Arrays.stream(numbers)
                .boxed().min((num1, num2) -> {
                    int absCompare = Integer.compare(Math.abs(num1), Math.abs(num2));
                    return absCompare == 0 ? Integer.compare(num2, num1) : absCompare;
        }).orElseThrow(() -> new RuntimeException("Array is empty"));

        System.out.println("Closest number to zero is: " + closestNumber);
    }

    private static int[] generateRandomArray() {
        Random random = new Random();
        int n = random.nextInt(10) + 1;
        int[] numbers = new int[n];

        int min = -100;
        int max = 100;
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(max - min + 1) + min;
        }

        return numbers;
    }

    private static void checkSubSequence() {
        String firstString = "cabcdefgh";
        String secondString = "cdef";

        int i = 0;
        int j = 0;

        while (i < secondString.length() && j < firstString.length()) {
            if (secondString.charAt(i) == firstString.charAt(j)) {
                i++;
            } else {
                i =0;
            }
            j++;
        }

        if (i == secondString.length()) {
            System.out.printf("\"%s\" is a substring of \"%s\"\n", secondString, firstString);
        } else {
            System.out.printf("\"%s\" is not a substring of \"%s\"\n", secondString, firstString);
        }
    }
}