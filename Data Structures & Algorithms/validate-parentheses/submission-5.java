class Solution {
    public boolean isValid(String s) {
        /*
            we want to use a stack for this problem.

            the intuition to take with this problem involves only adding the opening parentheses to the stack. we dont care to add the closing ones.

            we add each opening parentheses as we iterate, and the idea is that when we encounter a closing parentheses, its correct counter part will be on top of the stack.
            we will pop from the stack as long as the correct closing parentheses is seen. if there is no match then we know the string is invalid and can exit.

            once we've parsed the whole string, we know the string is valid if the stack is empty. if there is anything leftover in the stack we know the string is invalid. return accordingly.

            based on the constraints, there are 2 edge cases to account for that would instantly invalidate the string. if the length of the string is odd, we know there is a mismatch between opening and closing brackets. additionally, if the beginning and end of the string are not matching parentheses, then we also know the string is invalid.
        */

        // quick edge case check
        if (s.length() % 2 != 0) return false;

        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
    
        if (first == ')' || first == '}' || first == ']' || 
            last == '(' || last == '{' || last == '[') {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case ')' -> {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case ']' -> {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                case '}' -> {
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
                default -> {
                    stack.push(c);
                }
            }
        }

        if (!stack.isEmpty()) return false;
        return true;
    }
}
