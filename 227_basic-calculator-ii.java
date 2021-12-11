class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        // Integer, not Character, on stack
        Stack<Integer> stack = new Stack<>();
        
        int result = 0, currNum = 0;
        char currOperation = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // For number of multiple digits
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }
            
            // c is one of 4 operations, OR is last index of string s
            if (c != ' ' && !Character.isDigit(c) || i == s.length() - 1) {
                if (currOperation == '+')
                    stack.push(currNum);
                if (currOperation == '-')
                    stack.push(-currNum);
                
                // Follow operator precedence
                if (currOperation == '*')
                    stack.push(stack.pop() * currNum);
                if (currOperation == '/')
                    stack.push(stack.pop() / currNum);
                
                // Update the operation sign
                currOperation = c;
                // Update the current number 
                currNum = 0;
            }
        }
    
        while (!stack.isEmpty()) 
            result += stack.pop();
        
        return result;
    }
}