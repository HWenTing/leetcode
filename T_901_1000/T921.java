package T_901_1000;

import java.util.Stack;

public class T921 {

//	给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
    
//	用栈
//	public int minAddToMakeValid(String S) {
//		Stack<Character> st = new Stack<>();
//		for(char c:S.toCharArray()){
//			if(c==')' && !st.empty() && st.peek()=='('){
//				st.pop();
//			}else
//				st.add(c);
//		}
//		return st.size();
//    }
    
//	或者直接计数，
	
	public int minAddToMakeValid(String S) {
		int left=0;//没有配对左括号
		int right=0;//没有配对右括号
		
		for(char c:S.toCharArray()){
			if(c=='('){
				left++;
			}else{
				if(left>0)
					left--;
				else
					right++;
			}
		}
		return left+right;
    }
	
	
}
