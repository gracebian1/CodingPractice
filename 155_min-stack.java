class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> ms;

    public MinStack() {
        ms = new Stack<>();
    }
    
    public void push(int val) {
        // If new value <= current min, FIRST push current min AGAIN, THEN push the new value,
        // in order to keep tracking of the min AFTER new min has been popped out.
        if(val <= min){
            ms.push(min);
            min = val;
        }
        ms.push(val);
    }
    
    public void pop() {
        if(ms.peek() == min){
            // first pop out the current min
            ms.pop();
            // then pop out the next min and update the min value
            min = ms.pop(); 
        }else{
            ms.pop();
        }   
    }
    
    public int top() {
        return ms.peek();
    }
    
    public int getMin() {
        return min;   
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */