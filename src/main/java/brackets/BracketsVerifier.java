package brackets;

import java.util.*;


/**
 * Created by Egor on 28-Feb-17.
 */
public class BracketsVerifier {

    public static boolean isBracketsBalanced(String input) {
        Deque<Character> bracketsStack = new LinkedList<>();
        Map<Character, Character> bracketsPairs = new HashMap<>();
        bracketsPairs.put(')', '(');
        bracketsPairs.put(']', '[');
        bracketsPairs.put('>', '<');

        for (Character ch: input.toCharArray()) {
            if (bracketsPairs.containsValue(ch)) {
                bracketsStack.addLast(ch);
            } else if (bracketsPairs.containsKey(ch)) {
                if (bracketsPairs.get(ch) != bracketsStack.peekLast()) {
                    return false;
                }
                bracketsStack.removeLast();
            }
        }
        return bracketsStack.isEmpty();
    }
}
