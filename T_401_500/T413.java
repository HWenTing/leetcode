package T_401_500;

public class T413 {

	//动态规划 
    public int numberOfArithmeticSlices(int[] A) {
    	int n = A.length;
    	if(n<3)
    		return 0;
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 0;
        
        for(int i=2;i<n;i++){
        	if(A[i]-A[i-1]==A[i-1]-A[i-2])
        		dp[i] = 1+dp[i-1];
        }
        
        int ans = 0;
        for(int i:dp){
        	ans+=i;
        }
        return ans;
    }
    
    
	public static void main(String[] args) {

	}

}
