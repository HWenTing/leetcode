package InterviewBook;

import java.util.LinkedList;
import java.util.Stack;

public class T0303 {

//	堆盘子。设想有一堆盘子，堆太高可能会倒下来。
//	因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。
//	请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
//	此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 
//	
//	进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
//	当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.

//	list stack 模拟
	
	class StackOfPlates {

		private LinkedList<Stack<Integer>> stacklist;
		private int cap;
		
	    public StackOfPlates(int cap) {
	    	stacklist = new LinkedList<>();
	    	this.cap = cap;
	    }
	    
	    public void push(int val) {
	    	if (cap <= 0)   return;
	    	if(stacklist.isEmpty() || stacklist.getLast().size()==cap)
	    		stacklist.add(new Stack<>());
	    	stacklist.getLast().push(val);
	    }
	    
	    public int pop() {
	    	if(stacklist.isEmpty()) return -1;
	    	int temp = stacklist.getLast().pop();
	    	if(stacklist.getLast().isEmpty())
	    		stacklist.removeLast();
	    	return temp;
	    }
	    
	    public int popAt(int index) {
	    	if(stacklist.size()-1<index) return -1;
	    	
	    	int temp = stacklist.get(index).pop();
	    	if(stacklist.get(index).isEmpty())
	    		stacklist.remove(index);
	    	return temp;
	    }
	}
	
}