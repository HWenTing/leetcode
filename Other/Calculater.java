package Other;

import java.util.Stack;

public class Calculater {

//	符号栈数据栈
	
//	+ - * / 
	private int[] compare = new int[108];
	{
		compare['+']=0;
		compare['-']=0;
		compare['*']=1;
		compare['/']=1;
		compare['#']=-1;
	}
	
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
        		if(charst.isEmpty() || heighter(charst.peek(),c)){
        			charst.push(c);
        		}else{
        			i--;
        			numst.push(item(numst.pop(),numst.pop(),charst.pop()));
        		}
        	}
        }

        return numst.pop();
    }
    
    public static void main(String[] args) {
		System.out.println((int)'(');
		System.out.println((int)')');
		System.out.println((int)'+');
		System.out.println((int)'-');
		System.out.println((int)'*');
		System.out.println((int)'/');
		System.out.println((int)'#');
	}
}
