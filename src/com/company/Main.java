package com.company;

import java.util.Scanner;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        // =========================================================================================================
        // The purpose of this program is to determine if a word is an anagram of another word
        // Anagram definition - An anagram is a word or phrase formed by rearranging the letters of a different
        // word or phrase, typically using all the original letters exactly once.
        // =========================================================================================================

        // Assumptions source word and test word must have same number of characters and have the same letters

        //creating scanner object to be able to get user input
        Scanner keyboard = new Scanner(System.in);
        //prompt user with source word

        System.out.print("Please enter source word to test anagram against: ");
        String source = keyboard.nextLine();
        System.out.println("");

        System.out.print("Enter word to test if anagram of " + source + " : ");
        String test = keyboard.nextLine();

        Boolean result =  isAnagram(source, test);

        if (result) {
            System.out.println(test + " is an anagram of " + source);
        }



    }

    public static boolean isAnagram(String s, String t) {

        char[] sourceArray = s.toCharArray();
        char[] testArray = t.toCharArray();

        //checking to see if the words are the same length
        if (sourceArray.length != testArray.length) {
            System.out.println(t + " is not an anagram of " + s + " because the words don't have the same # of characters");
            return false;
        }

        //sort the array to make comparison easier
        Arrays.sort(sourceArray);
        String sortedSourceString = new String(sourceArray);
        Arrays.sort(testArray);
        String sortedTestString = new String(sourceArray);

        //create sorted array
        char[] sourceSortedchar = sortedSourceString.toCharArray();
        char[] testSortedChar = sortedTestString.toCharArray();

        //compare the sorted arrays, if they are not equal to each other the words have different letters
        for (int i = 0; i < sourceArray.length; i++) {
            if (Character.toLowerCase(sourceSortedchar[i]) != Character.toLowerCase(testSortedChar[i])) {
                System.out.println(t + " is not an anagram of " + s + " because the characters are different");
                return false;
            }
        }

        return true;
    }//end isAnagram()
}
