/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

class MinStack {
    static class Data {
        int value;
        int min;
        public Data(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
    
    private Stack<Data> datas = null;
    
    /** initialize your data structure here. */
    public MinStack() {
        datas = new Stack<>();
    }
    
    public void push(int x) {
        if (datas.isEmpty()) {
            datas.push(new Data(x, x));
        } else {
            datas.push(new Data(x, Math.min(x, datas.peek().min)));
        }
    }
    
    public void pop() {
        datas.pop();
    }
    
    public int top() {
        return datas.peek().value;
    }
    
    public int getMin() {
        return datas.peek().min;
    }
}
