class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        // Integer on stack, not Character
        Stack<Integer> stack = new Stack<>();
        
        int result = 0, operand = 0;
        // 1 for positive, -1 for negative
        int sign = 1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // In case for number of multiple digits
            if (Character.isDigit(c)) {
                operand = operand * 10 + (int) (c - '0');
                
            } else if (c == '+') {
                // Evaluate the expression to the left
                result += operand * sign;
                // Save the sign
                sign = 1;
                // Reset the operand
                operand = 0;
                
            } else if (c == '-') {
                result += operand * sign;
                sign = -1;
                operand = 0;
                
            } else if (c == '(') {
                // Push first the previously calculated result,
                // Then the sign before opening parenthesis, on stack
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
                // Add the result before this ( )
                // (operand on stack) + (sign on stack * (result in parentheses))
                result += stack.pop();
                
                // Reset the operand
                operand = 0;   
            }
        }
        return result + (operand * sign);
    }
}