import java.util.Stack;

public class UseCase5PalindromeCheckerApp {
    public static void main(String[] args) {
        // Hardcoded string to check
        String str = "madam";
        
        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();
        
        // Push all characters into the stack
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        
        // Pop and compare characters
        boolean isPalindrome = true;
        for (int i = 0; i < str.length(); i++) {
            // Pop from stack (Last In First Out - reverses order)
            char poppedChar = stack.pop();
            
            // Compare with original character
            if (str.charAt(i) != poppedChar) {
                isPalindrome = false;
                break;
            }
        }
        
        // Print result
        if (isPalindrome) {
            System.out.println("\"" + str + "\" is a palindrome");
        } else {
            System.out.println("\"" + str + "\" is not a palindrome");
        }
    }
}
