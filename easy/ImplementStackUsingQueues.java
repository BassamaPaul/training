/**
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/

class MyQueue {
  private Stack stack1 = new Stack();
  private Stack stack2 = new Stack();
  
  // Push element x to the back of queue.
  public void push(int x) {
      stack1.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
      balance();
      stack2.pop();
  }
  
  // Get the front element.
  public int peek() {
    balance();
    if (!stack2.isEmpty()) {
        return (Integer) stack2.peek();
    }
    return 0;
  }

  // Return whether the queue is empty.
  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
  
  public void balance() {
    if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
  }
}
