package SwordToOffer;

public class T47 {

//	在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
//	你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
//	给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

//	dp
    public int maxValue(int[][] grid) {
    	
    	int row = grid.length;
    	int col = grid[0].length;
    	
    	int[] dp = new int[col];
    	dp[0] = grid[0][0];
    	for(int i=1;i<col;i++)
    		dp[i] = dp[i-1]+grid[0][i];
    	
    	for(int i=1;i<row;i++){
    		dp[0] = dp[0]+grid[i][0];
    		for(int j=1;j<col;j++){
    			dp[j] = Math.max(dp[j-1], dp[j])+grid[i][j];
    		}
    	}
    	return dp[col-1];
    }
    
}
