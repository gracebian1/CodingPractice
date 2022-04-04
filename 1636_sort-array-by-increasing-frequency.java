class Solution {
	// Time: O(nlogn); Space: O(n)
    public int[] frequencySort(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (k1, k2) -> map.get(k1) == map.get(k2) ? k2 - k1 : map.get(k1) - map.get(k2));
        
        for (int key: map.keySet()) {
            int len = map.get(key);
            for (int i = 0; i < len; i++) {
                heap.offer(key);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        
        while (!heap.isEmpty()) {
            list.add(heap.poll());
        }
        
        int[] result = new int[list.size()];
        
        int index = 0;
        for (int n: list) {
            result[index] = n;
            index++;
        }
        return result;
    }
    
    /*
    public int[] frequencySort(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        
        // Sort using new comparator
        Collections.sort(list, new MyComp());
        
        int[] result = new int[nums.length];
        int index = 0;
        
        for (Map.Entry<Integer, Integer> entry: list) {
            int freq = entry.getValue();
            
            while (freq > 0) {
                result[index] = entry.getKey();
                index++;
                freq--;
            }
        }
        return result;
    }
    
    private static class MyComp implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer>e2) {
            if (e1.getValue() == e2.getValue()) {
                return e2.getKey() - e1.getKey();
            } else {
                return e1.getValue() - e2.getValue();
            }
        }
    }
    */
    
    /*
    public int[] frequencySort(int[] nums) {
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
        
        int[] result = new int[nums.length];
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
    */
}