import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {
    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        String cleaned = text.toLowerCase().replaceAll("\\s+", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : cleaned.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "refer";
        boolean result = isPalindrome(input);
        System.out.println("UC7: Deque-Based Optimized Palindrome Checker");
        System.out.println("Input: " + input);
        System.out.println("Result: " + (result ? "PALINDROME" : "NOT PALINDROME"));
    }
}