class Solution {
    public int[] frequencySort(int[] nums) {
        // HashMap => key: integer, value: counts
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // Array of Integer list
        // Attention to the list length
        List<Integer>[] bucket = new List[nums.length + 1];
        
        for (int key: map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            for (int i = 0; i < frequency; i++)
                bucket[frequency].add(key);
        }
        
        // result int array
        int[] result = new int[nums.length];
        // first index in result array
        int index = 0;
        
        for (int i = 0; i < bucket.length; i++) {
            List<Integer> list = bucket[i];
            // if list is null or 0 size => frequency is 0
            if (list == null || list.size() == 0)
                continue;
            // sort current list in reverse order
            Collections.sort(list, Collections.reverseOrder());
            // add list value to result array
            for (int j = 0; j < list.size(); j++) {
                result[index] = list.get(j);
                index++;
            }
        }
        return result;
    }
}