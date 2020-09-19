package InterviewBook;

public class T0301 {

//	三合一。描述如何只用一个数组来实现三个栈。
//	你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
//	构造函数会传入一个stackSize参数，代表每个栈的大小。

	class TripleInOne {

		private int[] stack;
		private int[] pointer;
		private int stackSize;
		
	    public TripleInOne(int stackSize) {
	    	pointer = new int[3];
	    	stack = new int[stackSize*3];
	    	this.stackSize = stackSize;
	    	for(int i=0;i<pointer.length;i++)
	    		pointer[i] = i*stackSize;
	    }
	    
	    public void push(int stackNum, int value) {
	    	if(pointer[stackNum] == (stackNum+1)*stackSize)
	    		return ;
	    	stack[pointer[stackNum]]=value;
	    	pointer[stackNum]++;
	    }
	    
	    public int pop(int stackNum) {
	    	if(pointer[stackNum]==stackNum*stackSize)
	    		return -1;
	    	pointer[stackNum]--;
	    	return stack[pointer[stackNum]];
	    }
	    
	    public int peek(int stackNum) {
	    	if(pointer[stackNum]==stackNum*stackSize)
	    		return -1;
	    	return stack[pointer[stackNum]-1];
	    }
	    
	    public boolean isEmpty(int stackNum) {
	    	return pointer[stackNum]==stackNum*stackSize;
	    }
	}
	
}
