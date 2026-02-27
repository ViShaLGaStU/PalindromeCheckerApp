public class PalindromeCheckerApp {
    private static class Node {
        char value;
        Node next;

        Node(char value) {
            this.value = value;
        }
    }

    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }

        String cleaned = text.toLowerCase().replaceAll("\\s+", "");
        if (cleaned.isEmpty()) {
            return true;
        }

        Node head = null;
        Node tail = null;
        for (char c : cleaned.toCharArray()) {
            Node node = new Node(c);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverseList(slow);
        Node firstHalf = head;
        Node secondIter = secondHalf;

        while (secondIter != null) {
            if (firstHalf.value != secondIter.value) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondIter = secondIter.next;
        }

        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        String input = "level";
        boolean result = isPalindrome(input);
        System.out.println("UC8: Linked List Based Palindrome Checker");
        System.out.println("Input: " + input);
        System.out.println("Result: " + (result ? "PALINDROME" : "NOT PALINDROME"));
    }
}