package T_201_300;

import java.util.Stack;

public class T224 {

//	实现一个基本的计算器来计算一个简单的字符串表达式的值。
//	字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
	
//	每次push进数，就和前面的数对对碰，碰到第一个左括号。
//	每次读入),就去掉一层括号，并往前对对碰
    public int calculate(String s) {
    	s=s+"#";//加个终结符，便于统一处理
    	Stack<String> st = new Stack<>();
    	int before=0;
    	boolean push=false;
        for(char c:s.toCharArray()){
        	
        	if(c>='0' && c<='9'){//处理数字
        		before = before*10+(c-'0');
        		push=true;
        	}else{
        		if(push){//压入数字，同时进行对对碰
        			if(st.empty() || st.peek().equals("(")){//靠着左括号或者栈为空就直接压入
        				st.push(before+"");
        			}else{//进行一次对对碰
        				String sym = st.pop();
        				int num2 = Integer.parseInt(st.pop());
        				if(sym.equals("+")){
        					st.push(num2+before+"");
        				}else{
        					st.push(num2-before+"");
        				}
        			}
        			before=0;
        			push=false;//更改状态
        		}
        		switch(c){
        		case ' ':
        			continue;
        		case '+':
        			st.push("+");
        			break;
        		case '-':
        			st.push("-");
        			break;
        		case '(':
        			st.push("(");
        			break;
        		case ')'://去一层括号，并且向前对对碰一次
        			String cur = st.pop();
        			if(cur.equals("(")) continue;
        			int curnum = Integer.parseInt(cur);
        			st.pop();//弹(
        			
        			//向前一层
        			if(st.isEmpty() || st.peek().equals("(")){
        				st.push(curnum+"");
        				continue;
        			}else{
        				String sym = st.pop();//弹符号
        				int num2 = Integer.parseInt(st.pop());//弹数
        				if(sym.equals("+")){//把新值压栈
        					st.push(num2+curnum+"");
        				}else{
        					st.push(num2-curnum+"");
        				}
        			}
        		}
        	}
        }
        
        return Integer.parseInt(st.pop());
    }
    
    
    public static void main(String[] args) {
		System.out.println(Integer.parseInt("+1"));
	}
}
