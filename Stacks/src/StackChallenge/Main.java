package StackChallenge;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        //should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {

        boolean isPalindrome = true;
        
        //0. Get a "clean" string - no punctations or no symbols - only lowercase characters
        String lowerCaseString = string.toLowerCase();
        char[] tempCharArray = lowerCaseString.toCharArray(); 
        StringBuilder cleanString = new StringBuilder(string.length()); 
        for(char charIndex: tempCharArray){
            if(charIndex >= 'a' && charIndex <= 'z'){
                cleanString.append(charIndex);
            }
        }
        string = cleanString.toString();

        //1. convert the string to character Array
        char[] charArray = string.toCharArray();

        //2. push each char from the charArray to stack
        LinkedList<Character> stack = new LinkedList<>();
        for (char charIndex : charArray) {
            stack.push(charIndex);
        }

        //3. check stack.pop equals to each char in stack 
        for (char charIndex : charArray) {
            char checkChar = stack.pop();
            if (charIndex != checkChar) {
                //3.2 else not palindrome
                isPalindrome = false;
            }
            //3.1 if all char matches then palindrome
        }

        return isPalindrome;
    }
}
