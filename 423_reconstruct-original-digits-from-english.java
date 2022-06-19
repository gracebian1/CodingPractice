class Solution {
    public String originalDigits(String s) {
        if (s == null || s.length() == 0)
            return "";
        
        // 0 - 9 digits
        int[] count = new int[10];
        
        for (char c: s.toCharArray()) {
            switch(c) {
                // Unique char in even numbers
                case 'z': 
                    count[0]++; break;
                case 'w': 
                    count[2]++; break;
                case 'u': 
                    count[4]++; break;
                case 'x': 
                    count[6]++; break;
                case 'g': 
                    count[8]++; break;
                    
                // Representative char in odd numbers
                case 'o': 
                    count[1]++; break;
                case 't': 
                    count[3]++; break;
                case 'f': 
                    count[5]++; break;
                case 's': 
                    count[7]++; break;
                case 'i': 
                    count[9]++; break;
            }
        }
        // Subtract duplicate counts for odd numbers
        count[1] = count[1] - count[0] - count[2] - count[4];
        count[3] = count[3] - count[2] - count[8];
        count[5] = count[5] - count[4];
        count[7] = count[7] - count[6];
        count[9] = count[9] - count[5] - count[6] - count[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb.append(i);
            }
        }
        return sb.toString();
    }
}