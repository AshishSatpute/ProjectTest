package com.Ashish.project;

import android.util.Log;

public class PalindromeExample {

    public static void main(String args[]) {
        String originals = "ashisha", reverse = ""; // Objects of String class
        int length = originals.length();
        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + originals.charAt(i);
        System.out.println("" + reverse);
        if (originals.equals(reverse))
            System.out.println("Entered string/number is a palindrome.");
        else
            System.out.println("Entered string/number isn't a palindrome.");
    }
}
