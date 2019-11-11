package T_301_400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class T301 {
	
//	删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
//	说明: 输入可能包含了除 ( 和 ) 以外的字符。
	
	String s;
	Set<String> ans;//去重
    public List<String> removeInvalidParentheses(String s) {
        
    	int left = 0;//需要删除的左括号
    	int right = 0;//需要删除的右括号
    	for(char c:s.toCharArray()){
    		if(c=='(')
    			left++;
    		else if(c==')'){
    			if(left>0)
    				left--;
    			else 
    				right++;
    		}
    	}
    	this.s=s;
    	ans = new HashSet<>();
    	recurse(0,0,0,left,right,new StringBuffer());
    	
    	return  new ArrayList<String>(ans);
    	
    }
    
    
    //当前坐标，删除完后左括号，删除完后右括号，要删除的左括号，要删除的右括号，sb
    private void recurse(int index,int leftcnt,int rightcnt,int leftrem,int rightrem,StringBuffer sb){
    	if(index==s.length()){
    		if(leftrem==0 && rightrem==0)
    			ans.add(sb.toString());
    	}else{
    		
    		char c = s.charAt(index);
    		if(c=='(' && leftrem>0){//递归
    			recurse(index+1,leftcnt,rightcnt,leftrem-1,rightrem,sb);
    		}else if(c==')' && rightrem>0){
    			recurse(index+1,leftcnt,rightcnt,leftrem,rightrem-1,sb);
    		}
    		
    		sb.append(c);
    		
    		//该删除的都删除完毕
    		if(c!='(' &&c!=')')
    			recurse(index+1,leftcnt,rightcnt,leftrem,rightrem,sb);
    		else if(c=='(')
    			recurse(index+1,leftcnt+1,rightcnt,leftrem,rightrem,sb);
    		else if(rightcnt<leftcnt)//')'时，只有这种情况合法，rightcnt>=leftcnt时不合法就直接返回了
    			recurse(index+1,leftcnt,rightcnt+1,leftrem,rightrem,sb);
    		
    		sb.deleteCharAt(sb.length()-1);//回溯
    	}
    }
    
}
