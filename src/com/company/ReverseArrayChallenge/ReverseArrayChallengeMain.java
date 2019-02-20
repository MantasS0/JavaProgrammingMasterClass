package com.company.ReverseArrayChallenge;

import java.util.Arrays;

public class ReverseArrayChallengeMain {

    public static void main(String[] args) {
	int[] array = {1,2,3,4,5};

        System.out.println("Original array: " + Arrays.toString(array));

        reverse(array);

        System.out.println("Reversed array: " + Arrays.toString(array));

    }

    public static void reverse(int[] array){
        for (int i = 0; i<array.length/2;i++){
            int temp = array[i];
            array[i] = array[array.length-i-1];
            array[array.length-i-1] = temp;
        }
    }
}
