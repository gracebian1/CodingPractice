class Solution {
    // Time: O(m*n): m: maximum len of a string, n: len of strs
    // Space: O(m*n)
    
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        
        // key: "#1#0#0#0#1..#1..#0"; value: ["ate", "eat", "tea"]
        Map<String, List<String>> map = new HashMap<>();
        
        int[] bucket = new int[26];
        
        for (String s: strs) {
            Arrays.fill(bucket, 0);
            
            for (char c: s.toCharArray()) {
                bucket[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(bucket[i]);
            }
            
            String key = sb.toString();
            
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}