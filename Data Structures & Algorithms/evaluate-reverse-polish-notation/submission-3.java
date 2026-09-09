class Solution {
    public int evalRPN(String[] tokens) {

        /*
            The idea with this problem is to utilize a stack to perform all the operations from the inside working outwards.

            we will only be pushing/popping integers from the stack.

            the approach involves iterating through the tokens, pushing integers onto the stack. when we encounter an operator, we will pop the top 2 integers from the stack.
            the order MATTERS with this. the first integer belongs to the right of the operator, and the second to the left.

            we pop these 2 values and perform the operation that we came across. 

            ex: tokens = ["1","2","+","3","*","4","-"]
            we push 1, 2 then reach "+".
            we pop 2 (right) then 1 (left) then do the operation: left + right = result.
            we push the result BACK ONTO the stack.
            we continue this pattern, working inside to out in the context of the arithmetic expression until we reach the end. 
            the remaining value on the stack is the result of the whole expression. return this value.

            in terms of complexity, this solution is O(n) time because we must parse the entire array.
            space complexity this solution would be O(n) because we have the token array and we are also creating a stack.
        */
        Stack<Integer> s = new Stack<>();
        
        // loop through array to evaluate expression
        for (String t : tokens) {
            switch (t) {
                case "+" -> {
                    int r = s.pop();
                    int l = s.pop();
                    s.push(l+r);
                }
                case "-" -> {
                    int r = s.pop();
                    int l = s.pop();
                    s.push(l-r);
                }
                case "*" -> {
                    int r = s.pop();
                    int l = s.pop();
                    s.push(l*r);
                }
                case "/" -> {
                    int r = s.pop();
                    int l = s.pop();
                    s.push(l/r);
                }
                default -> {
                    s.push(Integer.parseInt(t));
                }
            }
        }
        return(s.pop());

    }
}
