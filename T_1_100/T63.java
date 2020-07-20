package T_1_100;

import java.util.Arrays;

public class T63 {

	
//	有障碍物的路径条数
//	和62思路差不多，加了个障碍物判断
//	ok,击败99%
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lenrow = obstacleGrid.length;
        if(lenrow==0) return 0;
        
        int lencol = obstacleGrid[0].length;
        
    	int[] dp = new int[lencol];
    	for(int i=0;i<lencol;i++){//初始化
    		if(obstacleGrid[0][i]==1)
    			break;
    		dp[i]=1;
    	}
    	
    	for(int i=1;i<lenrow;i++){
    		if(obstacleGrid[i][0]==0 && dp[0]==1)
    			dp[0]=1;
    		else
    			dp[0]=0;
    		
    		for(int j=1;j<lencol;j++){
    			if(obstacleGrid[i][j]==0)
    				dp[j]=(obstacleGrid[i][j-1]==0?dp[j-1]:0)+(obstacleGrid[i-1][j]==0?dp[j]:0);//状态转移公式 也可以直接写成 dp[j]+=(obstacleGrid[i][j-1]==0?dp[j-1]:0);
    			else
    				dp[j]=0;
    		}
    	}
    	return dp[lencol-1];
    }
    
}
