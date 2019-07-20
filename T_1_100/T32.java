package T_1_100;

import java.util.*;

class TwoTuple{

    public char first;

    public int second;

    public TwoTuple(char a, int b){
        first = a;
        second = b;
    }
}
public class T32 {


    public static int longestValidParentheses(String s) {
        Deque<TwoTuple> de = new LinkedList<TwoTuple>();
        int len = s.length();
        int ans = 0;
        for(int i =0;i<len;i++){
        	
        	if(s.charAt(i)=='('){
        		de.addFirst(new TwoTuple('(',i));
        	}else{
        		if(!de.isEmpty() && de.getFirst().first=='('){
        			de.pop();
        		}else{
        			de.addFirst(new TwoTuple(')',i));
        		}
        	}
        }
        if(de.isEmpty()){
        	return len;
        }
        int pos=-1;
        int current=0;
        while(!de.isEmpty()){
        	current = de.pollLast().second;

        	int temp = current-pos-1;
        	pos = current;
        	ans=ans>temp?ans:temp;

        	
        }
        ans=ans>(len-current-1)?ans:(len-current-1);
        

        
        return ans;
    }
    
    public static void main(String[] args){
    	String haystack = "())";
    	System.out.println(longestValidParentheses(haystack));
    }
}
