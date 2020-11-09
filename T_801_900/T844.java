package T_801_900;

import java.util.Stack;

public class T844 {

//	给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
	
//	用栈模拟过程
//    public boolean backspaceCompare(String S, String T) {
//        Stack<Character> st = new Stack<>();
//    	for(char c:S.toCharArray()){
//    		if(c=='#'){
//    			if(!st.isEmpty())
//    				st.pop();
//    		}
//    		else
//    			st.add(c);
//    	}
//    	Stack<Character> st2 = new Stack<>();
//    	for(char c:T.toCharArray()){
//    		if(c=='#'){
//    			if(!st2.isEmpty())
//    				st2.pop();
//    		}
//    		else
//    			st2.add(c);
//    	}
//    	if(st.size()!=st2.size())
//    		return false;
//    	while(!st.isEmpty()){
//    		if(st.pop()!=st2.pop())
//    			return false;
//    	}
//    	return true;
//    }
    
//	从后往前 双指针 击败96%
	public boolean backspaceCompare(String S, String T) {
		int i = S.length()-1;
		int j = T.length()-1;
		
		while(true){
			int cnt = 0;
			while(i>=0){
				if(S.charAt(i)=='#'){
					cnt++;
					i--;
				}else if(cnt>0){
					cnt--;
					i--;
				}else{
					break;
				}
			}

			cnt = 0;
			while(j>=0){
				if(T.charAt(j)=='#'){
					cnt++;
					j--;
				}else if(cnt>0){
					cnt--;
					j--;
				}else{
					break;
				}
			}
			

			if(i<0 && j<0)
				return true;
			
			if(i<0 || j<0 || S.charAt(i--)!=T.charAt(j--))
				return false;
		}
		
	}
}
