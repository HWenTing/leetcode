package T1k_1_100;

public class T1021 {

//	删除最外层的括号
	
//	cnt 左括号加一，右括号减一
    public String removeOuterParentheses(String S) {
    	int cnt =0;
    	StringBuffer sb = new StringBuffer();
    	
    	for(int i=0;i<S.length();i++){
    		if(S.charAt(i)==')'){
    			if(cnt!=1){
    				sb.append(')');
    			}
    			cnt--;
    		}else{
    			if(cnt!=0)
    				sb.append('(');
        		cnt++;
    		}
    	}
    	return sb.toString();
    }
    
    
}
