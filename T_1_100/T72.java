package T_1_100;

public class T72 {
	
//	最小编辑距离，比较经典的用法,使用dp即可解决
	
    public int minDistance(String word1, String word2) {
        
    	int m = word1.length();
    	int n = word2.length();
    	
    	int [][]dp = new int[m+1][n+1];//dp[i][j]表示word1的前i位和word2的前j位最小编辑距离
    	
    	for(int i=1;i<=m;i++)//初始化
    		dp[i][0]=i;
    	for(int i=1;i<=n;i++)//初始化
    		dp[0][i]=i;
    	
    	for(int i=1;i<=m;i++){
    		for(int j=1;j<=n;j++){
    			if(word1.charAt(i-1)==word2.charAt(j-1))
    				dp[i][j] = dp[i-1][j-1];
    			else{
    				dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
    			}
    		}
    	}
    	
    	return dp[m][n];
    }
    
    
}
