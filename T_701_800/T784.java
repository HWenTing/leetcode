package T_701_800;

import java.util.LinkedList;
import java.util.List;

public class T784 {

//	给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
	
//	dfs+回溯方法
	List<String> ans;
    public List<String> letterCasePermutation(String S) {
    	ans = new LinkedList<>();
        StringBuffer sb = new StringBuffer(S);
        dfs(sb,0);
        return ans;
    }
    
    private void dfs( StringBuffer sb,int pos){
    	if(pos==sb.length()){
    		ans.add(sb.toString());
    		return ;
    	}else{
    		char poschar= sb.charAt(pos);
    		if(poschar<='Z' &&poschar>='A'){
    			dfs(sb,pos+1);
    			sb.setCharAt(pos, (char) (poschar-'A'+'a'));
    			dfs(sb,pos+1);
    			sb.setCharAt(pos, poschar);//恢复现场
    			
    		}else if(poschar<='z' && poschar>='a'){
    			dfs(sb,pos+1);
    			sb.setCharAt(pos, (char) (poschar-'a'+'A'));
    			dfs(sb,pos+1);
    			sb.setCharAt(pos, poschar);//恢复现场
    			
    		}else{
    			dfs(sb,pos+1);
    		}
    	}
    }
    
}
