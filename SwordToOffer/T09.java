package SwordToOffer;

import java.util.Stack;

public class T09 {

	
//	用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
//	分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
	
	class CQueue {
		Stack<Integer> in,out;
	    public CQueue() {
	    	in = new Stack<>();//负责进
	    	out = new Stack<>();//负责出
	    }
	    
	    public void appendTail(int value) {//append直接push进in栈
	    	in.push(value);
	    }
	    
	    public int deleteHead() {//删除时 先判断out空不空，不空直接pop，否则将in倒入out
	    	if(!out.isEmpty())
	    		return out.pop();
	    	else{
	    		swap();
	    		return out.isEmpty()?-1:out.pop();
	    	}
	    }
	    
	    private void swap(){//将in倒入out
	    	while(!in.isEmpty()){
	    		out.push(in.pop());
	    	}
	    }
	}
    
}
