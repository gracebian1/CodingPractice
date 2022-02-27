class TwoSum {
    // Map key: int; Map value: frequency
    private Map<Integer, Integer> map;

    public TwoSum() {
       this.map = new HashMap<>();
    }
    
    public void add(int number) {
        this.map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
        for (int key: map.keySet()) {
            int target = value - key;
            
            if (target != key) {
                if (this.map.containsKey(target))
                    return true;
                
                // If two elements are the same: 1 + 1 = 2
            } else if (this.map.get(key) > 1)
                return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */