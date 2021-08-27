class Solution {
    public boolean isValid(String s) {
        
        if(s == null || s.length() == 0) return true;
        if(s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            switch(c){
                case ')': if(stack.isEmpty() || stack.pop() != '(') 
                    return false;
                    break;
                case ']': if(stack.isEmpty() || stack.pop() != '[')
                    return false;
                    break;
                case '}': if(stack.isEmpty() || stack.pop() != '{')
                    return false;
                    break;
                default: stack.push(c);
            }
        }
        return stack.isEmpty();  
    }
}