package T_301_400;

import java.util.Stack;

public class T394 {

//	解析字符串
//	栈
//	要注意 Stringbuffer.reverse,会把每一项也都反转，123，456  reverse完了变成654321 而非456123
	
	public String decodeString(String s) {
		Stack<String> stack = new Stack<>(); 
		int cnt=0;
		
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);

			if(c>='0' && c<='9'){//确保每次加入的是一个数
				cnt = cnt*10+c-'0';
				if(s.charAt(i+1)>='0' && s.charAt(i+1)<='9'){
					continue;
				}else{
					stack.add(cnt+"");
					cnt=0;				}
			}else if(c==']'){//出栈，计算重复，再入栈
				
				StringBuffer temp = new StringBuffer();
				String top = stack.pop();
				while(!top.equals("[")){
					temp.insert(0,top);
					top = stack.pop();
				}
				int k=Integer.parseInt(stack.pop());

				StringBuffer sub = new StringBuffer();
				for(int j=0;j<k;j++){
					sub.append(temp.toString());
				}
				stack.add(sub.toString());
				
			}else{
				stack.add(c+"");
			}
		}
		
		StringBuffer ans = new StringBuffer();
		while(!stack.isEmpty())
			ans.insert(0,stack.pop());
		return ans.toString();
	}

}
