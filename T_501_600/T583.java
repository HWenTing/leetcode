package T_501_600;

public class T583 {

//	可以转换成求最长公共子序列seq，然后m+n-2seq
//	dp来解决就好
    public int minDistance(String word1, String word2) {
        
    	int m = word1.length();
    	int n = word2.length();
    	
    	int [][]dp = new int[m+1][n+1];//dp[i][j]表示word1的前i位和word2的前j位最长公共子序列
    	for(int i=1;i<=m;i++){
    		for(int j=1;j<=n;j++){
    			if(word1.charAt(i-1)==word2.charAt(j-1))
    				dp[i][j] = dp[i-1][j-1]+1;
    			else
    				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    		}
    	}
    	
    	return m+n-2*dp[m][n];
    }
    
    
}
