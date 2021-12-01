class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> result = new ArrayList<>();
        
        // Map key: name; Map value: list of time 
        Map<String, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            
            // Build a new pair of name-time 
            if (!map.containsKey(name)) {
                map.put(name, new ArrayList<>());
            } 
            // Add new time to the time list
            map.get(name).add(getTime(keyTime[i]));
        }
        
        for (String name: map.keySet()) {
            // Get the time list for each name
            List<Integer> timeList = map.get(name);
            
            // Sort the time in ascending order
            Collections.sort(timeList);
            
            for (int i = 2; i < timeList.size(); i++) {
                if (timeList.get(i) - timeList.get(i-2) <= 60) {
                    // Add name to result list and break the current loop
                    // no need to check for more time of the same name
                    result.add(name);
                    break;
                }
            }
        }
        // Sort the result name in alphabetical order
        Collections.sort(result);
        return result;                            
    }
    
    private static int getTime(String time) {
        String[] splitTime = time.split(":");
        // Get the total minutes for time
        return Integer.parseInt(splitTime[1]) + 60 * Integer.parseInt(splitTime[0]);
    }
}