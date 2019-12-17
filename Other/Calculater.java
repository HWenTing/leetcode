package Other;

import java.util.Stack;

public class Calculater {
//  整数计算器实现
//	支持 加 减 乘 除 括号 乘方
//	符号栈数据栈
	
//	+ - * / ( )  优先级定义
	private int[] compare = new int[108];
	{
		compare['+']=0;
		compare['-']=0;
		compare['*']=1;
		compare['/']=1;
		compare['^']=2;
		compare['(']=-1;
		compare[')']=-1;
		compare['#']=-10;
	}
//	比较优先级大小
	private boolean heighter(char left,char right){
		return compare[right]-compare[left]>0;
	}
	
	//a是第二个数 b是第一个数
	private int item(int a,int b,char oprt){
		switch(oprt){
		case '+':
			return b+a;
		case '-':
			return b-a;
		case '*':
			return b*a;
		case '/':
			return b/a;
		case '^':
			return (int)Math.pow(b, a);
		default:
			return -1;
		}
	}
	
    public int calculate(String s) {
    	s=s+"#";//加个终结符，便于统一处理
    	Stack<Integer> numst = new Stack<>();
    	Stack<Character> charst = new Stack<>();
    	
    	boolean newint=true;
        for(int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	if(Character.isDigit(c)){//处理数字
        		if(newint){
        			numst.push(c-'0');
        			newint=false;
        		}else{
        			numst.push(numst.pop()*10+c-'0');
        		}
        	}else{
        		newint=true;
        		if(c==' ') continue;
        		
        		if(charst.isEmpty() || c=='(' || heighter(charst.peek(),c)){//如果当前符号是第一个符号 或 括号 或 优先级高于前一个符号 直接push进去
        			charst.push(c);
        		}else{
        			if(charst.peek()=='('){//特殊处理括号
        				charst.pop();
        				continue;
        			}
        			i--;
        			numst.push(item(numst.pop(),numst.pop(),charst.pop()));
        		}
        	}
        }

        return numst.pop();
    }
    
    public static void main(String[] args) {
    	Calculater c = new Calculater();
//    	System.out.println(c.calculate("1-2*(2-9)/3"));
    	System.out.println(c.calculate("1-2*(2-9)^2/2"));
//		System.out.println((int)'(');
//		System.out.println((int)')');
//		System.out.println((int)'+');
//		System.out.println((int)'-');
//		System.out.println((int)'*');
//		System.out.println((int)'/');
//		System.out.println((int)'#');
	}
}
