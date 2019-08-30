package T_201_300;

public class T221 {

	
//	在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
//	啊也没啥思路
	
	
//	当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也一定是某个正方形的右下角，
//	否则该点为右下角的正方形最大就是它自己了。这是定性的判断，那具体的最大正方形边长呢？
//	我们知道，该点为右下角的正方形的最大边长，最多比它的上方，左方和左上方为右下角的正方形的边长多1，
//	最好的情况是是它的上方，左方和左上方为右下角的正方形的大小都一样的，这样加上该点就可以构成一个更大的正方形。 
//	但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，
//	这时候只能取那三个正方形中最小的正方形的边长加1了。假设dpi表示以i,j为右下角的正方形的最大边长，
//	则有 dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1 
//	当然，如果这个点在原矩阵中本身就是0的话，那dp[i]肯定就是0了。
	
	
//	击败11%，思想是对的，问题不大，在判断那里多费了些时间
    public int maximalSquare(char[][] matrix) {
        int lenrow = matrix.length;
        if(lenrow==0) return 0;
        int lencol = matrix[0].length;
        int[][] dp = new int[lenrow][lencol];
        int max=0;
        
        
        for(int i=0;i<lenrow;i++){
        	for(int j=0;j<lencol;j++){
        		if(matrix[i][j]=='1'){
        			if(i-1>=0 && j-1>=0)
        				dp[i][j] = Math.min(dp[i][j-1] ,Math.min(dp[i-1][j-1] ,dp[i-1][j]))+1;
        			else if(i-1<0)
        				dp[i][j] = matrix[0][j]=='1'?1:0;
        			else
        				dp[i][j] = matrix[i][0]=='1'?1:0;
        			
        			max = Math.max(max, dp[i][j]);
        		}
        	}
        }
        
        return max*max;
    }
    
    
//    把dp数组扩展一位就击败了80%，空间换时间吧
//    public int maximalSquare(char[][] matrix) {
//        int lenrow = matrix.length;
//        if(lenrow==0) return 0;
//        int lencol = matrix[0].length;
//        int[][] dp = new int[lenrow+1][lencol+1];
//        int max=0;
//        
//        
//        for(int i=1;i<=lenrow;i++){
//        	for(int j=1;j<=lencol;j++){
//        		if(matrix[i-1][j-1]=='1'){
//        			dp[i][j] = Math.min(dp[i][j-1] ,Math.min(dp[i-1][j-1] ,dp[i-1][j]))+1;       			
//        			max = Math.max(max, dp[i][j]);
//        		}
//        	}
//        }
//        
//        return max*max;
//    }
    
    
}
