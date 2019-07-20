package T_1_100;

import java.util.*;

public class T20 {

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
    
    public static void main(String[] args){
    	String st = "([)]";
    	System.out.println(isValid(st));
    }
}
