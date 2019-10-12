package Tc_contest;

public class W149_1155 {

	
//	d个骰子，每个有f面(1-f)，返回掷出的总点数为target的组合数模10^9+7结果
	
//	动态规划，前f个的和
//	10^9 + 7
//	dp[i][k] i个骰子时，target为k的组合数
//	dp[i][k] = dp[i][k]+dp[i-1][k-j]   1<=j<=f
//	击败82%
	private int mod = 1000000007;
	public int numRollsToTarget(int d, int f, int target) {
        if(d*f<target ||target<d )
        	return 0;
        
        int[][] dp = new int[d+1][target+1];
        
        int min=Math.min(f, target);
        for(int i=1;i<=min;i++){
        	dp[1][i]=1;
        }
        	
        for(int i=2;i<=d;i++){
        	for(int k=i;k<=target;k++){
        		for(int j=1;j<=f&& j<=k;j++){
        			dp[i][k] =  (dp[i][k]+dp[i-1][k-j]) %mod;
        		}
        	}
        }
        return dp[d][target];
    }
    
	public static void main(String[] args) {
		
	}
}
