package T_801_900;

import java.util.Stack;

public class T844 {

//	给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
	
//	用栈模拟过程
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> st = new Stack<>();
    	for(char c:S.toCharArray()){
    		if(c=='#'){
    			if(!st.isEmpty())
    				st.pop();
    		}
    		else
    			st.add(c);
    	}
    	Stack<Character> st2 = new Stack<>();
    	for(char c:T.toCharArray()){
    		if(c=='#'){
    			if(!st2.isEmpty())
    				st2.pop();
    		}
    		else
    			st2.add(c);
    	}
    	if(st.size()!=st2.size())
    		return false;
    	while(!st.isEmpty()){
    		if(st.pop()!=st2.pop())
    			return false;
    	}
    	return true;
    }
    
}
