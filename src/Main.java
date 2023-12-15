import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {

        public static int missingNumber(int[] nums, int maxNum) {

            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

            for (int i = 1; i <= maxNum; i += 1) {
                if (!set.contains(i)) {
                    return i;
                }
            }
            return 0;
        }

    }
    public static boolean balancedParentheses(String s) {
        int numUnclosedOpenParens = 0;
        for (int i = 0; i < s.length(); i += 1) {
            if (s.charAt(i) == '(') {
                numUnclosedOpenParens += 1;
            }
            else if (s.charAt(i) == ')') {
                numUnclosedOpenParens -= 1;
            }

            if (numUnclosedOpenParens < 0) {
                return false;
            }
        }

        return numUnclosedOpenParens == 0;
    }

    public static boolean balancedBrackets(String s) {

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        bracketPairs.put('>', '<');

        for (int i = 0; i < s.length(); i += 1) {

            // If character is opening bracket
            if (bracketPairs.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            // Else, if character is closing bracket
            else if (bracketPairs.containsKey(s.charAt(i))) {
                // Closing bracket without matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                // Check that most recent bracket on stack matches
                Character mostRecentBracket = stack.pop();
                if (!mostRecentBracket.equals(bracketPairs.get(s.charAt(i)))) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}