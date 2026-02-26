import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        // Create a stack to store expected closing brackets
        Stack<Character> stack = new Stack<>();

        // Loop through each character
        for (char c : s.toCharArray()) {

            // If opening bracket, push expected closing bracket
            if (c == '(') {
                stack.push(')');
            } 
            else if (c == '{') {
                stack.push('}');
            } 
            else if (c == '[') {
                stack.push(']');
            } 
            // If closing bracket
            else {
                // If stack empty OR top doesn't match → invalid
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // If stack empty → valid
        return stack.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {

        String test1 = "{[()]}";
        String test2 = "{[(])}";
        String test3 = "((()))";
        String test4 = "({[]})";

        System.out.println(test1 + " → " + isValid(test1));
        System.out.println(test2 + " → " + isValid(test2));
        System.out.println(test3 + " → " + isValid(test3));
        System.out.println(test4 + " → " + isValid(test4));
    }
}
