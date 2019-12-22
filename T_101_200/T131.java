package T_101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T131 {
	
//	给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//	返回 s 所有可能的分割方案。
	
//	递归处理，如果头部是回文的，那么递归后边，然后把头部添加上去
//	判断回文可以打表判断
	boolean[][] dp;
    public List<List<String>> partition(String s) {
//      动态规划打表回文
    	dp = new boolean[s.length()][s.length()];
    	int length = s.length();
    	//考虑所有长度的子串
    	for (int len = 1; len <= length; len++) {
    		//从每个下标开始
    		for (int i = 0; i <= s.length() - len; i++) {
    			int j = i + len - 1;
    			dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
    		}
    	}
      
    	List<List<String>> ans = new ArrayList<>();
    	dfs(ans,new ArrayList<>(),0,s);
    	return ans;
    }
    
    private void dfs(List<List<String>> ans, List<String> temp,int start,String s){
    	if(start==s.length()){
    		ans.add(new ArrayList<>(temp));
    		return ;
    	}
    	
    	for(int i=start;i<s.length();i++){
    		if(dp[start][i]){
    			temp.add(s.substring(start,i+1));
    			dfs(ans,temp,i+1,s);
    			temp.remove(temp.size()-1);
    		}
    	}
    }

//    private boolean palindrome(String s,int left,int right){
//    	while(left<right){
//    		if(s.charAt(left)!=s.charAt(right))
//    			return false;
//    		left++;
//    		right--;
//    	}
//    	return true;
//    }
    



    
    
}
