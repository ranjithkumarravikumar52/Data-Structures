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
        
        //0. clean up the string
        string = cleanString(string);

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

    public static String cleanString(String string) {
        //0. Get a "clean" string - no punctations or no symbols or no whiteSpaces or no Uppercase
        String cleanString = string.toLowerCase();
        cleanString = cleanString.trim();
        
        //ONLY lowercase characters should be present in the clean String
        char[] charArray = cleanString.toCharArray();
        StringBuilder onlyLowerCaseCharArray = new StringBuilder(cleanString.length());
        for(char charIndex: charArray){
            if(charIndex >= 'a' && charIndex <= 'z'){
                onlyLowerCaseCharArray.append(charIndex);
            }
        }
        cleanString = onlyLowerCaseCharArray.toString();
        return cleanString;
    }
}
