package InterviewBook;

import java.util.Stack;

public class T0302 {

//	请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。

//	双栈

	class MinStack {

		Stack<Integer> st,min ;
	    /** initialize your data structure here. */
	    public MinStack() {
	    	st = new Stack<>();
	    	min = new Stack<>();
	    }
	    
	    public void push(int x) {
	    	if(min.isEmpty() || min.peek()>=x)
	    		min.push(x);
	    	st.push(x);

	    }
	    
	    public void pop() {
	    	if(st.peek().intValue() == min.peek().intValue()) // 这个地方要特别注意 Integer的拆箱装箱问题
	    		min.pop();
	    	st.pop();	    	System.out.println(min);
	    }
	    
	    public int top() {
	    	return st.peek();
	    }
	    
	    public int getMin() {
	    	return min.peek();
	    }
	}
	
}
