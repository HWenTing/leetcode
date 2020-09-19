package T_1_100;

import java.util.*;

public class T20 {

//	给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//	有效字符串需满足：
//	左括号必须用相同类型的右括号闭合。
//	左括号必须以正确的顺序闭合。
//	注意空字符串可被认为是有效字符串。

//	栈
    public static boolean isValid(String s) {
    	
        Deque<Character> li = new LinkedList<>();
        li.add('*');
        int len = s.length();
        if(len==0){
        	return true;
        }
        
        char[] c=s.toCharArray();
        for (char i :c){
        	if(i==')' && li.getFirst() == '('){
        		li.pop();
        	}
        	else if(i=='}' && li.getFirst() == '{'){
        		li.pop();
        	}
        	else if(i==']' && li.getFirst() == '['){
        		li.pop();
        	}
        	else{
        		li.addFirst(i);
        	}
        }
        return li.size()==1;
    }
}
