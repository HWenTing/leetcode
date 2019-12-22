package T_101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T132 {
//	给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
//	返回符合要求的最少分割次数。
	
//	一开始的想法是对131进行修改，返回最短的长度 但是一直超时 以下是超时解决方案
//	boolean[][] dp;
//	int ansnum=Integer.MAX_VALUE;
//    public int minCut(String s) {
////      动态规划打表回文
//    	dp = new boolean[s.length()][s.length()];
//    	int length = s.length();
//    	//考虑所有长度的子串
//    	for (int len = 1; len <= length; len++) {
//    		//从每个下标开始
//    		for (int i = 0; i <= s.length() - len; i++) {
//    			int j = i + len - 1;
//    			dp[i][j] = s.charAt(i) == s.charAt(j) && (len < 3 || dp[i + 1][j - 1]);
//    		}
//    	}
//      
//    	List<List<String>> ans = new ArrayList<>();
//    	dfs(ans,new ArrayList<>(),0,s);
//    	return ansnum-1;
//    }
//	
//    private void dfs(List<List<String>> ans, List<String> temp,int start,String s){
//    	if(temp.size()>ansnum) return;
//    	if(start==s.length()){
//    		ansnum = Math.min(ansnum, temp.size());
//    		return ;
//    	}
//    	
//    	for(int i=s.length()-1;i>=start;i--){//从大到小也超时
//    		if(dp[start][i]){
//    			temp.add(s.substring(start,i+1));
//    			dfs(ans,temp,i+1,s);
//    			temp.remove(temp.size()-1);
//    		}
//    	}
//    }
	
//	采用中心向外拓展的思想，先声明一个dp数组 dp[i]表示到i分割的次数
    public int minCut(String s) {
    	if(s==null || s.length()<=1) return 0;
    	int len = s.length();
    	
        int[]dp = new int[len];
        Arrays.fill(dp, len-1);
        for(int i=0;i<len;i++){//要注意奇偶分开
        	expend(s,i,i,dp);//奇数位
        	expend(s,i,i+1,dp);//偶数位
        }
        return dp[len-1];
    }
    
//    i,j两个指针分别往两端跑，i到j是回文的
    private void expend(String s,int i,int j,int[]dp){
    	int len = s.length();
    	while(i>=0 && j<len && s.charAt(i)==s.charAt(j)){
    		if(i==0)//从0到j是回文的，不需要分割
    			dp[j]=0;
    		else//找到j之前 回文断开的位置dp[i-1]  i到j是回文的 i-1位置是上一个的结束
    			dp[j] =Math.min(dp[j],dp[i-1]+1);
    		i--;
    		j++;
    	}
    }
    
    
    
    
}
