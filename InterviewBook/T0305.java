package InterviewBook;

import java.util.Stack;

public class T0305 {

//	栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。
//	最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。
//	该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。

//	两个栈 相互倒腾
	class SortedStack {

		Stack<Integer> s1,s2;
		
	    public SortedStack() {
	    	s1 = new Stack<>();
	    	s2 = new Stack<>();
	    }
	    
	    public void push(int val) {//可以倒腾的不这么频繁
	    	if(s1.isEmpty()){
	    		s1.push(val);
	    		return ;
	    	}
	    	
	    	while(!s1.isEmpty() && s1.peek()<val){
	    		s2.push(s1.pop());
	    	}
	    	s1.push(val);
	    	while(!s2.isEmpty()){
	    		s1.push(s2.pop());
	    	}
	    }
	    
	    public void pop() {
	    	if(!s1.empty())
	    		s1.pop();
	    }
	    
	    public int peek() {
	    	if(s1.empty()) return -1;
	    	return s1.peek();
	    }
	    
	    public boolean isEmpty() {
	    	return s1.isEmpty();
	    }
	}
	
	
//	更快一点 push方法倒腾的不是那么频繁
//	class SortedStack {
//	    Stack<Integer> stack1;
//	    Stack<Integer> stack2;
//
//	    public SortedStack() {
//	        stack1 = new Stack<>();
//	        stack2 = new Stack<>();
//	    }
//	    
//	    public void push(int val) {
//	        int max = stack1.isEmpty()?Integer.MAX_VALUE:stack1.peek();
//	        int min = stack2.isEmpty()?Integer.MIN_VALUE:stack2.peek();
//	        while(true){
//	            if(val>max){
//	                stack2.push(stack1.pop());
//	                max = stack1.isEmpty()?Integer.MAX_VALUE:stack1.peek();
//	            }else if(val<min){
//	                stack1.push(stack2.pop());
//	                min = stack2.isEmpty()?Integer.MIN_VALUE:stack2.peek();
//	            }else{
//	                stack1.push(val);
//	                break;
//	            }
//	        }
//	    }
//	    
//	    public void pop() {
//	        while(!stack2.isEmpty())
//	            stack1.push(stack2.pop());
//	        if(!stack1.isEmpty())
//	            stack1.pop();
//	    }
//	    
//	    public int peek() {
//	        while(!stack2.isEmpty())
//	            stack1.push(stack2.pop());
//	        return stack1.isEmpty()?-1:stack1.peek();
//	    }
//	    
//	    public boolean isEmpty() {
//	        return stack1.isEmpty();
//	    }
//	}
	
	
}
