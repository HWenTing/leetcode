package SwordToOffer;

import java.util.Stack;

public class T30 {
//	定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
	
//	单独拿出一个栈来存放最小值
//	或者自己实现个链表，每个节点加一个额外属性：当前最小值。
	class MinStack {
		Stack<Integer> stack;
		Stack<Integer> minst;
	    public MinStack() {
	    	stack = new Stack<>();
	    	minst = new Stack<>();
	    }
	    
	    public void push(int x) {
	    	stack.push(x);
	    	if(minst.isEmpty())
	    		minst.push(x);
	    	else if(x<=minst.peek())
	    		minst.push(x);
	    }
	    
	    public void pop() {
	    	int ret = stack.pop();
	    	if(minst.peek()==ret)
	    		minst.pop();
	    }
	    
	    public int top() {
	    	return stack.peek();
	    }
	    
	    public int min() {
	    	return minst.peek();
	    }
	}
	
}
