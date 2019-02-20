package com.company.ArraysChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysChallengeMain {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] array = getIntegers(5);
        System.out.println();
        System.out.println("Tims method:");
        printArray(sortArrayByTim(array));

    }

    public static int[] getIntegers(int amount) {
        System.out.println("Enter " + amount + " integer values.\r");
        int[] array = new int[amount];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }


    public static int[] sortArrayByTim(int[] array) {
        int[] sortedArray = Arrays.copyOf(array,array.length);

        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (sortedArray[i] < sortedArray[i + 1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i + 1];
                    sortedArray[i + 1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }

    public static void printArray(int[] array) {
        System.out.println("Sorted integers are: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents is: " + array[i]);
        }
    }
}
