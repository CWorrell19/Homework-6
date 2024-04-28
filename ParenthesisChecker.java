// Conner Worrell

import java.util.Stack;

public class ParenthesisChecker {
    // Method to check if parentheses are balanced
    public static boolean isBalanced(String expression) {
        // Create a stack to store opening parentheses
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the expression
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                // Push opening parentheses onto the stack
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                // If a closing parenthesis is encountered and stack is empty, return false
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top element from the stack
                char top = stack.pop();
                // Check if the popped opening parenthesis matches the current closing parenthesis
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false; // Mismatched parentheses
                }
            }
        }
        // If the stack is empty after iterating through the expression, return true
        return stack.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Test cases
        String[] expressions = {
            "()",             // Balanced with single-type brackets
            "[[()]]",         // Balanced with mixed-type brackets
            "{[()]}",         // Balanced with mixed-type brackets
            "([)]",           // Unbalanced with mixed-type brackets
            "(",              // Unbalanced with single-type brackets
            "",               // Empty string
            "abc123"          // No parentheses
        };

        // Test the isBalanced method with each expression
        for (String exp : expressions) {
            System.out.println("Expression: " + exp);
            System.out.println("Balanced: " + isBalanced(exp));
            System.out.println();
        }
    }
}
