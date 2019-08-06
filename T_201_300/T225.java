package T_201_300;

import java.util.LinkedList;
import java.util.Queue;

public class T225 {
//队列实现栈
	
	private Queue<Integer> qu = new LinkedList<>();
	
    /** Push element x onto stack. */
    public void push(int x) {//每次push一个元素，将之前的元素都出队列再进队列，保证后加入的元素在队列的头部 
        qu.add(x);
        int len = qu.size()-1;
        for(int i=0;i<len;i++){
        	qu.add(qu.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return qu.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return qu.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return qu.isEmpty();
    }
}
