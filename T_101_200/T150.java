package T_101_200;

import java.util.Stack;

public class T150 {

//	根据逆波兰表示法，求表达式的值。
//	有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式
	
//	相当于后缀表达式，栈
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s:tokens){
        	switch(s){
        	case "+":
        		st.push(st.pop()+st.pop());
        		break;
        	case "-":
        		int mins = st.pop();
        		st.push(st.pop()-mins);
        		break;
        	case "*":
        		st.push(st.pop()*st.pop());
        		break;
        	case "/":
        		int sha = st.pop();
        		st.push(st.pop()/sha);
        		break;
        	default:
        		st.push(Integer.parseInt(s));
        	}
        }
        return st.pop();
    }
    
}
