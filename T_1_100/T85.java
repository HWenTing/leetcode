package T_1_100;

public class T85 {

//	给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

	
//	不对，思路错了，没有考虑到单独的横排或者竖排，我太难了
//    public int maximalRectangle(char[][] matrix) {
//        int lenrow = matrix.length;
//        int lencol = matrix[0].length;
//        int ans = 0;
//        
//    	int[][][] dp = new int[lenrow][lencol][2];
//    	for(int i=0;i<lenrow;i++){
//    		for(int j=0;j<lencol;j++){
//    			int up = i-1>=0?matrix[i-1][j]-'0':0;
//    			int left = j-1>=0?matrix[i][j-1]-'0':0;
//    			
//    			if(matrix[i][j]=='1'){
//    				
//    				if(up==1 && left==1){
//    					dp[i][j][0] = Math.min(dp[i][j-1][0]+1,dp[i-1][j][0]);
//    					dp[i][j][1] = Math.min(dp[i-1][j][1]+1,dp[i][j-1][1]);
//    				}else if(up==0 && left==1){
//    					dp[i][j][0]=dp[i][j-1][0]+1;
//    					dp[i][j][1]=1;
//    					
//    				}else if(up==1 && left==0){
//    					dp[i][j][0]=1;
//    					dp[i][j][1]=dp[i-1][j][1]+1;
//    				}else{
//    					dp[i][j][0]=1;//左
//    					dp[i][j][1]=1;//上
//    				}
//    				
//    				ans = Math.max(ans, dp[i][j][0]*dp[i][j][1]);
//    			}
//    		}
//    	}
//    	return ans;
//    }
    
}
