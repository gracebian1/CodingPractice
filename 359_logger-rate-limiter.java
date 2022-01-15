class Logger {
    // Time: O(1); Space: O(n)
    private Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (this.map.containsKey(message)) {
            int oldTime = this.map.get(message);
            if (timestamp - oldTime >= 10) {
                this.map.put(message, timestamp);
                return true;
            } else
                return false;      
        } else {
            this.map.put(message, timestamp);
            return true;
        }
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */