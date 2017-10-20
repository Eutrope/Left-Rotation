/**
 * Created by HaMi on 2017-09-27.
 * This program takes in an array of integers and a value d that stands for the index of which we want our new array to start with
 * The program needs to populate the array starting from index d and to the end, and also get the values before d
 * Example input: arr[1,2,3,4,5], d = 2
 * Example output: 3 4 5 1 2
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class LeftRotation {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/text.txt"));
        // read the entire file
        while (in.hasNext()) {
            int n = in.nextInt();
            int d = in.nextInt();
            int[] a = new int[n];

            for (int result = 0; result < n; ++result) {
                a[result] = in.nextInt();
            }
            System.out.print("Before: ");
            System.out.println(Arrays.toString(a));

            int[] a2 = leftRotation(a, d);

            System.out.print("After: ");
            System.out.println(Arrays.toString(a2));
            System.out.println("");
        }
        in.close();
    }

    public static int[] leftRotation(int[] a, int d) {
        int[] newArr = new int[a.length];
        int counter = 0;
        int newCounter;
        // starting from index d, we populate our new array all the way until we get to the end
        /* the counter variable will keep track of how many times we looped
        this will be useful since we will need to retrieve the rest of the elements after the rotating
        ex: if we have an array of 1 2 3 4 5 and we are rotating left by 2 then we do
        3 4 during the rotating phase
        afterwards, we know we looped twice here, so 2 minus the length of the array, 4, is 2
         */

        for (newCounter = d; newCounter < a.length; newCounter++) {
            newArr[counter] = a[newCounter];
            counter++;
        }

        // now we initialize newCounter to counter so we know what index to continue from
        newCounter = counter;

        // ex: a.length - counter (5 - 3 = 2 so we loop 2 times)
        for (int i = 0; i < a.length - counter; i++) {
            newArr[newCounter] = a[i];
            newCounter++;       // moving to next index in our new array
        }
        return newArr;
    }
}
