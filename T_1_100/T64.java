package T_1_100;

public class T64 {

	
//	给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//	说明：每次只能向下或者向右移动一步。
	
//	单趋向的运动方向 适合动态规划
    public int minPathSum(int[][] grid) {
    	int numh = grid.length;
    	if(numh==0)
    		return 0;
    	int numw = grid[0].length;
    	int[] dp = new int[numw];
        for(int i=0;i<numh;i++){
        	for(int j=0;j<numw;j++){
        		if(j==0)
        			dp[j] = dp[j];
        		else if(i==0)
        			dp[j] = dp[j-1];
        		else
        			dp[j] = Math.min(dp[j], dp[j-1]);
        		dp[j]+=grid[i][j];
        	}
        }
        return dp[numw-1];	
    }
    
    
	public static void main(String[] args) {
		T64 t =new T64();
		int[][] grid = {
				{1,3,1},
				{1,5,1},
				{4,2,1}};
		System.out.println(t.minPathSum(grid));

	}

}
