class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // user map: username-->pair(timestamp + website)
        Map<String, List<Pair>> userMap = new HashMap<>();
        
        for (int i = 0; i < username.length; i++) {
            userMap.putIfAbsent(username[i], new ArrayList<>());
            userMap.get(username[i]).add(new Pair(timestamp[i], website[i]));
        }
        
        // count map: String of triplet of website (pattern) --> # of users visited (score)
        Map<String, Integer> countMap = new HashMap<>();
        
        // This holds the triplet String as the key for countMap
        String resultStr = "";
        
        for (String user: userMap.keySet()) {
            // For each user, a new set to avoid visiting the same triplet website
            Set<String> set = new HashSet<>();
            
            List<Pair> list = userMap.get(user);
            Collections.sort(list, (a, b) -> (a.time - b.time));
            
            // O(n^3): triplet of website
            for (int i = 0; i < list.size(); i++) {
                for (int j = i+1; j < list.size(); j++) {
                    for (int k = j+1; k < list.size(); k++) {
                        String curr = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
                        
                        if (!set.contains(curr)) {
                            countMap.put(curr, countMap.getOrDefault(curr, 0) + 1);
                            set.add(curr);
                        }
                   
                        if (resultStr.equals("") || countMap.get(curr) > countMap.get(resultStr) || 
                           (countMap.get(curr) == countMap.get(resultStr) && resultStr.compareTo(curr) > 0)) {
                            resultStr = curr;
                        }
                    }
                }
            }
        }
        
        String[] arr = resultStr.split(" ");
        
        List<String> resultList = new ArrayList<>();
        for (String s: arr) {
            resultList.add(s);
        }
        return resultList;
    }
}
// New object type Pair
class Pair {
    int time;
    String web;
    
    public Pair (int time, String web) {
        this.time = time;
        this.web = web;
    }
}