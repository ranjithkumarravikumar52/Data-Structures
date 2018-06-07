package queue.QueueChallenge;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
    }

    public static boolean checkForPalindrome(String string) {

        boolean isPalindrome = false;

        //Get me a "cleanString" based on the given problem
        String cleanString = cleanString(string);
        char[] charArray = cleanString.toCharArray();
        //Create a linkedList
        LinkedList<Character> stack = new LinkedList<>();
        //create a queue
        LinkedList<Character> queue = new LinkedList<>();
        //adding elements into the stack
        for (int i =0; i < charArray.length; i++) {
            stack.addFirst(charArray[i]);
            queue.add(charArray[i]);
        }
//        Iterator stackIterator = stack.iterator(); 
//        Iterator queueIterator = queue.iterator(); 
//        
//        System.out.println("Elements in the stack");
//        while(stackIterator.hasNext()){
//            System.out.println(stackIterator.next());
//        }
//        
//        System.out.println("Elements in the queue");
//        while(queueIterator.hasNext()){
//            System.out.println(queueIterator.next());
//        }

//        System.out.println("Popping stack "+stack.remove());
//        System.out.println("Popping queue "+queue.remove());
        for (int i = 0; i < charArray.length / 2; i++) {
            if (stack.remove() != queue.remove()) {
                isPalindrome = false;
                break;
            } else {
                isPalindrome = true;
            }

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
        for (char charIndex : charArray) {
            if (charIndex >= 'a' && charIndex <= 'z') {
                onlyLowerCaseCharArray.append(charIndex);
            }
        }
        cleanString = onlyLowerCaseCharArray.toString();
        return cleanString;
    }
}
