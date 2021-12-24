class Solution {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0)
            return null;
        
        // Define new comparator
        Comparator<String> myComparator = new Comparator<>() {
            @Override
            public int compare(String log1, String log2) {
                
                // Split each log into 2 parts, by first space
                String[] arr1 = log1.split(" ", 2);
                String[] arr2 = log2.split(" ", 2);
                
                 // Get identifiers
                String identifier1 = arr1[0];
                String identifier2 = arr2[0];
                
                // Get the first char of each log's contents
                boolean isDigit1 = Character.isDigit(arr1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(arr2[1].charAt(0));
                
                // Both are letter-logs:
                if (!isDigit1 && !isDigit2) {
                    int comp = arr1[1].compareTo(arr2[1]);
                    
                    // Different contents
                    if (comp != 0)
                        return comp;
                    
                    // Same contents
                    else {
                        return identifier1.compareTo(identifier2);
                    }
                }
                
                // One is letter-log, one is digit-log
                if (!isDigit1 && isDigit2) 
                    return -1;
                else if (isDigit1 && !isDigit2)
                    return 1;
                
                // Both are digit-logs (maintain their relative order)
                else
                    return 0;
            }
        };
        
        // sort(T[] a, Comparator<? super T> c)
        // Sort the array of objects according to the specified comparator
        Arrays.sort(logs, myComparator);
        return logs;
    }
}