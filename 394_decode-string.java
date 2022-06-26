class Solution {
/* 
 Time: O(maxK^countK * n): maxK: maximum value of k; countK: count of nested K; n: len of s
 e.g.: 10[ab10[cd]]10[ef]: 10*cd*10*ab + 10*2 = 10^2*2.
    
 Space: O(sum(maxK^countK * n)): sum of all decoded strings
*/
    public String decodeString(String s) {
        if (s == null || s.length() == 0)
            return "";

        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (c == ']') {
                // Build a new stringbuilder each time encountered a ']'
                StringBuilder sb = new StringBuilder();
                
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                // Pop off the top '['
                stack.pop();
            
                // For k of double digits and more, e.g. 25
                // On stack, it's 2 and 5
                int base = 1;
                int k = 0;
                
                // Get the count for repeated characters
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }
                
                // Push back chars in[ ] to the stack for k times (reversely)
                while (k > 0) {
                    for (int j = sb.length() - 1; j >= 0; j--) {
                        stack.push(sb.charAt(j));
                    }
                    k--;
                }  
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}