package T_301_400;

public class T329 {

//	给定一个整数矩阵，找出最长递增路径的长度。
//	对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
	
//	dfs 记忆化搜索
//	一遍ac  速度击败86%
	
	private int[][] directs;
	private int COL,ROW;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0) return 0;
        ROW = matrix.length;
        COL = matrix[0].length;
        directs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
    	int[][] dp = new int[ROW][COL];
    	int ans = 0;
    	for(int i=0;i<ROW;i++){
    		for(int j=0;j<COL;j++){
    			ans = Math.max(ans, item(matrix,dp,i,j));
    		}
    	}
    	return ans;
    }
    
//    不需要使用visit来标记路程，因为比较大小本来就是单向的，不会重复
    private int item(int[][] matrix,int[][] dp,int row,int col){
    	if(dp[row][col]>0)//大于0 说明被处理过 下次就不处理了直接返回
    		return dp[row][col];
    	
    	int max = 1;
    	for(int[] direct:directs){//四个方向 
    		int newrow = row+direct[0];
    		int newcol = col+direct[1];
    		if(newrow>=0 && newrow<ROW && newcol>=0 && newcol<COL && matrix[row][col]<matrix[newrow][newcol])
    			max = Math.max(max, 1+item(matrix,dp,newrow,newcol));
    		
    	}
    	dp[row][col] = max;//更改状态
    	return max;
    }
    
}
