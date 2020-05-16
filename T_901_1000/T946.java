package T_901_1000;

import java.util.Stack;

public class T946 {

//	给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，
//	只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。

//	判断是否为出栈序列
	
//	模拟出栈
    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	Stack<Integer> st = new Stack<>();
    	int poppedid = 0;
    	
    	for(int i:pushed){
    		st.push(i);//每次push一个
    		
    		while(!st.isEmpty() && st.peek()==popped[poppedid]){//遇到相等的就出栈
    			st.pop();
    			poppedid++;
    		}
    	}
    	return st.empty();//不为空则不是出栈序列
    
    }
    
}
