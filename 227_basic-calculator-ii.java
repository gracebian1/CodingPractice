class Solution {
    /*
    // Using stack: Time: O(n), Space: O(n)
    
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int currNum = 0, result = 0;
        char currSign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + (c - '0');
            }
            
            if (c != ' ' && !Character.isDigit(c) || i == s.length() - 1) {
                if (currSign == '+') {
                    stack.push(currNum);
                }
                if (currSign == '-') {
                    stack.push(-currNum);
                }
                if (currSign == '*') {
                    stack.push(stack.pop() * currNum);
                }
                if (currSign == '/') {
                    stack.push(stack.pop() / currNum);
                }
                
                currNum = 0;
                currSign = c;
            }
        }
        
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;   
    }
    */   
    // NOT using stack: Time: O(n), Space: O(1)
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        
        int curr = 0, prev = 0, result = 0;
        char sign = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                curr = curr * 10 + (c - '0');
            }
            
            // ALSO need to check for the last position of string
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+' || sign == '-') {
                    result += prev;
                    prev = (sign == '+') ? curr : -curr;
                } else if (sign == '*') {
                    prev = prev * curr; 
                } else if (sign == '/') {
                    prev = prev / curr;
                }
                
                curr = 0;
                sign = c;
            }
        }
        result += prev;
        return result;
    }
}