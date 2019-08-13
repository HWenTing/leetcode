package T_contest;

public class W149_1155 {

	
//	动态规划，前f个的和
//	10^9 + 7
    public int numRollsToTarget(int d, int f, int target) {
        if(d*f<target ||target<d)
        	return 0;
        
        int[] dp = new int[target];
        
        for(int i=0;i<d;i++){
        	for(int j=1;j<=f;j++){
        		dp[j-1]
        	}
        }
    }
    
	public static void main(String[] args) {
		
	}
}
