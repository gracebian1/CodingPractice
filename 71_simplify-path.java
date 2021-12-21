class Solution {
    public String simplifyPath(String path) {
        String result = "";
        if (path == null || path.length() == 0)
            return result;
        
        Stack<String> stack = new Stack<>();
        
        String[] elements = path.trim().split("/");
        
        for (String directory: elements) {
            
            // "." or empty, do nothing, so skip
            if (directory.equals(".") || directory.isEmpty())
                continue;
            
            // Go back to previous dir, so pop it off
            else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                
                // Push others to stack
            } else {
                stack.push(directory);
            }
        }
        
        if (stack.isEmpty())
            return "/";
        
        // Attention to the order of final result
        while(!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result;
    }
}