package com.company.MinimumElementChallenge;

import java.util.Scanner;

public class MinimumElementChallengeMain {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter amount of integers to process:\r");
        int count = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Lowest number in the array is: " + findMin(readIntegers(count)));
    }

    public static int[] readIntegers(int count) {
        System.out.println("Please enter " + count + " numbers to console.\r");
        int[] array = new int[count];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            scanner.nextLine();
        }
        return array;
    }

    public static int findMin(int[] array){
        int min = Integer.MAX_VALUE;
        for (int i : array) {
            if (min>i){
                min=i;
            }
        }
        return min;
    }
}