package T_301_400;

public class T312 {

//	有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
//	现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
//	求所能获得硬币的最大数量。

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

        		for(int k=i;k<=j+i;k++){//最后一个戳k这个位置
        			dp[i][i+j] = Math.max(dp[i][i+j], newnums[k]*newnums[i-1]*newnums[i+j+1]+dp[i][k-1]+dp[k+1][i+j]);
        		}
        		
        	}
        }
        return dp[1][newnums.length-2];
    }
}
