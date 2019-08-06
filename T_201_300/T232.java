package T_201_300;

import java.util.Stack;

public class T232 {

//	用两个栈来模拟实现队列
	
    /** Initialize your data structure here. */
    public T232() {
        
    }
    
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(out.empty())
        	in2out();
        return out.pop();
        	
    }
    
    private void in2out(){
    	while(!in.empty()){
    		int temp = in.pop();
    		out.push(temp);
    	}
    }
    /** Get the front element. */
    public int peek() {
        if(out.empty())
        	in2out();
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.empty()&&out.empty();
    }
}
