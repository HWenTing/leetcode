package T_101_200;

import java.util.Stack;

public class T155 {
	
//	设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//	没有好的思路
	
//	可以每次push进连个元素，一个代表真正的元素，一个是当前最小的元素
//	这样后加入的元素也不会影响到前边的元素
	
//	或者也可以单独拿出一个栈来存放最小值
	Stack<Integer> stack = new Stack<>();
	
    public void push(int x) {
    	if(stack.empty()){
    		stack.push(x);
    		stack.push(x);
    	}else{
    		int temp = stack.peek();
    		stack.push(x);
    		if(temp<x)
    			stack.push(temp);
    		else
    			stack.push(x);
    	}
    }
    
    public void pop() {
        if(!stack.empty()){
        	stack.pop();
        	stack.pop();
        }
    }
    
    public int top() {
    	return stack.get(stack.size()-2);
    }
    
    public int getMin() {
        return stack.peek();
    }
    
    
}
