package com.elrast;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : chars) {
            switch (ch) {
                case '{':
                case '(':
                case '[':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.pop().equals('('))
                        return false;
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.pop().equals('['))
                        return false;
                    break;
                default:
                    if (stack.isEmpty() || !stack.pop().equals('{'))
                        return false;
                    break;
            }
        }
        return stack.isEmpty();

    }
}

