package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class LongestSubString {
    public int maxParen(String st) {
        if (st == null || st.length() == 0 ) {
            return 0;
        }

        int max  = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i =0; i < st.length(); i++) {
            if (st.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}


