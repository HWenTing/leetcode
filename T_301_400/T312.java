package T_301_400;

public class T312 {

	
//	动态规划 
//	要注意的是ij的含义，j表示区间的长度，i表示起始位置
//	dp[i][i+j] = Math.max(dp[i][i+j], newnums[k]*newnums[i-1]*newnums[i+j+1]+dp[i][k-1]+dp[k+1][i+j]);
//	
	
    public int maxCoins(int[] nums) {
    	
    	int[] newnums = new int[nums.length+2];
    	newnums[0] = 1;
    	for(int i=0;i<nums.length;i++){
    		newnums[i+1] = nums[i];
    	}
    	newnums[nums.length+1]=1;
    	
        int[][] dp = new int[newnums.length][newnums.length];
        for(int j=0;j<newnums.length-2;j++){//区间长度
        	for(int i=1;i+j<newnums.length-1;i++){//起始位置

        		for(int k=i;k<=j+i;k++){
        			dp[i][i+j] = Math.max(dp[i][i+j], newnums[k]*newnums[i-1]*newnums[i+j+1]+dp[i][k-1]+dp[k+1][i+j]);
        		}
        		
        	}
        }
        return dp[1][newnums.length-2];
    }
}
