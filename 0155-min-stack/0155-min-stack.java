class MinStack {
     Stack<Integer> stack;
     Stack<Integer> minStack;
    
    // two stack-main stack norrmal operation krega and min stack will check minimum everytime
    public MinStack() {
      stack = new Stack<>();
       minStack = new Stack<>();
    }

    
    public void push(int val) {
        stack.push(val);
        // push kro agar voh minimum hoga
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

   
    public void pop() {
        // popped element agr current minimum hai toh usse minstack se bhi pop kro
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    
    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();

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