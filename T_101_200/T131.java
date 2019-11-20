package T_101_200;

import java.util.LinkedList;
import java.util.List;

public class T131 {
	
//	给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//	返回 s 所有可能的分割方案。
	
//	递归处理，如果头部是回文的，那么递归后边，然后把头部添加上去
//	击败9.1%。。。。。
//	判断回文可以打表判断
    public List<List<String>> partition(String s) {
    	List<List<String>> ans = new LinkedList<>();
        if(s.length()<=1){
        	List<String> temp = new LinkedList<>();
        	if(s.length()==0){//为空
        		ans.add(temp);
        		return ans;
        	}
        	temp.add(s);
        	ans.add(temp);
        	return ans;
        }
        
        for(int i=0;i<s.length();i++){
        	if(palindrome(s,0,i)){
        		List<List<String>> son = partition(s.substring(i+1));
        		for(int j=0;j<son.size();j++){
        			List<String> temp = new LinkedList<>();
        			temp.add(s.substring(0,i+1));
        			for(String ss:son.get(j))
        				temp.add(ss);
        			ans.add(temp);
        		}
        	}
        }
        return ans;
    }
    

    private boolean palindrome(String s,int left,int right){
    	while(left<right){
    		if(s.charAt(left)!=s.charAt(right))
    			return false;
    		left++;
    		right--;
    	}
    	return true;
    }
    
//    动态规划打表回文
//    boolean[][] dp = new boolean[s.length()][s.length()];
//    int length = s.length();
//    //考虑所有长度的子串
//    for (int len = 1; len <= length; len++) {
//        //从每个下标开始
//        for (int i = 0; i <= s.length() - len; i++) {
//            int j = i + len - 1;
//            dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
//        }
//    }

    
    
}
