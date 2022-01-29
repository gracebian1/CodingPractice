class Solution {
    // Time: O(n); Space: O(n)
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for (String token: tokens) {
            if (!"+-*/".contains(token)) {
                stack.push(Integer.valueOf(token));
                continue;
            }
            int result = 0;
            
            // num2 comes first
            int num2 = stack.pop();
            int num1 = stack.pop();
            
            switch(token) {
                case "+": 
                    result = num1 + num2;
                    break;
                case "-": 
                    result = num1 - num2;
                    break;
                case "*": 
                    result = num1 * num2;
                    break;
                case "/": 
                    result = num1 / num2;
                    break;
            }
            stack.push(result);
        }
        return stack.pop();
    }
}