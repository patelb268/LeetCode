class MyQueue {
    Stack<Integer> stk;
    Stack<Integer> stk_que;
    
    public void move(){
        while(!stk.isEmpty()){
            stk_que.push(stk.pop());
        }
    }
    
    public MyQueue() {
        stk = new Stack<>();
        stk_que = new Stack<>();
    }
    
    public void push(int x) {
        stk.push(x);
    }
    
    public int pop() {
        if(stk_que.isEmpty()) move();
        return stk_que.pop();
    }
    
    public int peek() {
        if(stk_que.isEmpty()) move();
        return stk_que.peek();
    }
    
    public boolean empty() {
        if(stk.isEmpty() && stk_que.isEmpty()) return true;
        return false;
    }
}

/**
  * Time Complexity O(1)
  * Space Complexity O(n)

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
