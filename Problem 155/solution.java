class MinStack {
    Stack<Integer> stk;
    Stack<Integer> min_stk;
    int min;

    public MinStack() {
        stk = new Stack<>();
        min_stk = new Stack<>();
        min_stk.push(Integer.MAX_VALUE);
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stk.push(val);
        if(min >= val){
            min = val;
            min_stk.push(min);
            
        }
    }
    
    public void pop() {
        int val = stk.pop();
        if(val == min){
            min_stk.pop();
            min = min_stk.peek();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min;
    }
}


/** 
  * Time Complexity O(1) for each operation
  * Space Complexity O(N)
*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
