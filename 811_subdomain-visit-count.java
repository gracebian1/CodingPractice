class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> result = new ArrayList<>();
        if (cpdomains == null || cpdomains.length == 0) 
            return result;
        
        // Map key: domain string; Map value: count
        Map<String, Integer> map = new HashMap<>();
        
        // Iterate through each string
        for (String domain: cpdomains) {
            // Split by space
            String[] info = domain.split("\\s+");
            
            // Get integer count and domain parts based on array indices
            int count = Integer.parseInt(info[0]);
            String[] sections = info[1].split("\\."); 
            
            String curr = "";
            
            // Iterate backwards, from the highest level of domain 
            for (int i = sections.length - 1; i >= 0; i--) {
                curr = sections[i] + (i < sections.length - 1 ? "." : "") + curr;
                map.put(curr, map.getOrDefault(curr, 0) + count);
            }
        }
        
        // Add result to list, map value + key --> count + domain 
        for (String s: map.keySet()) {
            result.add("" + map.get(s) + " " + s);
        }
        return result;
    }
}