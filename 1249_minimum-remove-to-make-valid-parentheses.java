class Solution {
    // Time: O(n); Space: O(n)
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        Stack<Integer> stack = new Stack<>();
        
        // Put entire string into string builder
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i, '*');
                }
            } 
        }
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        return sb.toString().replaceAll("\\*", "");
    }

   /*
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        // Set and Stack to store INDEX, not char in string
        // Use Set to get O(1) time for searching (instead of list)
        
        Set<Integer> indexToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') {
                stack.push(i);
            } 
            if (c == ')' && stack.isEmpty()) {
                indexToRemove.add(i);
            } 
            if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            }
        }
        
        // Pop all the rest in stack, and add to set
        while (!stack.isEmpty()) {
            indexToRemove.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    */
}