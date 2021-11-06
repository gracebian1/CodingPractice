class Solution {
    /*
    // String concatenation
    public String interpret(String command) {
        String s = "";
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G'){
                s += 'G';
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i+1) == 'a') {
                    s += "al";
                } else {
                    s += 'o';
                }
            }
        }
        return s;
    }
    */
    
    // StringBuilder 1:
    // Different nestings between method 1 and 2
    /*
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i+1) == 'a') {
                    sb.append("al");
                } else {
                    sb.append('o');
                }
            }
        }
        return sb.toString();
    }
    */
    
    // StringBuilder 2:
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                sb.append('G');
            } else if ((i+1) < command.length() && command.charAt(i+1) == ')') {
                sb.append('o');
                i++;         // update index 
            } else {
                sb.append("al");
                i += 3;      // update index
            }
        }
        return sb.toString();
    }
}