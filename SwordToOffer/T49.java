package SwordToOffer;

public class T49 {

//	我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
	
//	三指针问题 同T264
    public int nthUglyNumber(int n) {
    	
    	int n1=0;
    	int n2=0;
    	int n3=0;
    	int[] dp = new int[n];
    	dp[0]=1;
    	
    	for(int i=1;i<n;i++){
    		dp[i] = Math.min(Math.min(dp[n1]*2, dp[n2]*3), dp[n3]*5);
    		
    		if(dp[i]==dp[n1]*2) n1++;
    		if(dp[i]==dp[n2]*3) n2++;
    		if(dp[i]==dp[n3]*5) n3++;
    		
    	}
    	return dp[n-1];
    }
    
}
