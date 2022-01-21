class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        // Integer on stack
        Stack<Integer> stack = new Stack<>();
        
        int result = 0, operand = 0;
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // number of multiple digits
            if (Character.isDigit(c)) {
                operand = operand * 10 + (int) (c - '0');
                
            } else if (c == '+') {
                // Evaluate the expression to the left
                result += operand * sign;
                // Save the sign
                sign = 1;
                // Reset operand
                operand = 0;
                
            } else if (c == '-') {
                result += operand * sign;
                sign = -1;
                operand = 0;
                
            } else if (c == '(') {
                // Push: first: the previously calculated result,
                // Then: the sign before opening parenthesis
                stack.push(result);
                stack.push(sign);
                
                // Reset for new sub-expression in the ( )
                result = 0;
                sign = 1;
                
            } else if (c == ')') {
                // Evaluate the expression to the left
                result += operand * sign;
                
                // * the sign on top of stack
                result *= stack.pop();
                
                // Add the result before the current ( )
                // (operand on stack) + (sign on stack * (result in parentheses))
                result += stack.pop();
                
                // Reset operand
                operand = 0;   
            }
        }
        return result + (operand * sign);
    }
}