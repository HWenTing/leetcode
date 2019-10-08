package T_601_700;

import java.util.Stack;

public class T682 {

	
//	用栈模拟操作
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for(String s:ops){
        	switch(s){
        	case "C":
        		st.pop();
        		break;
        	case "+":
        		int temp1 = st.pop();
        		int temp2 = st.pop();
        		st.add(temp2);
        		st.add(temp1);
        		st.add(temp1+temp2);
        		break;
        	case "D":
        		st.add(st.peek()*2);
        		break;
        	default:
        		st.add(Integer.valueOf(s));
        	}
        }
        int ans=0;
        while(!st.isEmpty()){
        	ans+=st.pop();
        }
        return ans;
    }
    
}
