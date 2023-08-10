import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));
        System.out.println(checkForPalindrome("RACECAR"));

        System.out.println("------------");

        System.out.println(checkPalindrome("abccba"));
        System.out.println(checkPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkPalindrome("I did, did I?"));
        System.out.println(checkPalindrome("hello"));
        System.out.println(checkPalindrome("Don't node"));
        System.out.println(checkPalindrome("RACECAR"));

        System.out.println("--------------");

        System.out.println(convertDecimalToBinary(13));
        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(80));



    }

    public static boolean checkForPalindrome(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder noPunctionWord = new StringBuilder();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);

        for(int i = 0; i < lowerCase.length(); i++) {
            char letter = lowerCase.charAt(i);
            if(letter >= 'a' && letter <= 'z') {
                noPunctionWord.append(letter);
                stack.push(letter);
            }

        }

        StringBuilder reversed = new StringBuilder();
        while(!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return noPunctionWord.toString().equals(reversed.toString());
    }

    public static boolean checkPalindrome(String text) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCaseString = text.toLowerCase(Locale.ENGLISH);

        for(int i = 0; i < lowerCaseString.length(); i++) {
            char letter = lowerCaseString.charAt(i);
            if(letter >= 'a' && letter <= 'z') {
                queue.addLast(letter);
                stack.push(letter);
            }
        }

       while(!stack.isEmpty()) {
           if(!stack.pop().equals(queue.removeFirst())) {
               return false;
           }
       }

       return true;
    }

    public static String convertDecimalToBinary(int num) {
        final int number = 2;
        Stack numbers = new Stack();

        while(num > 0) {
            numbers.push(num % number);
            num = num / number;
        }

        String bits = "";
        while(!numbers.isEmpty()) {
            bits = bits + numbers.pop();
        }

        numbers.toString();
        return bits;
    }

}