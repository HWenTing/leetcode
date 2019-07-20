package T_801_900;

public class T808 {
	static double[][] dp;
	
	public static double dfs(int A,int B) {
		if(A <= 0 && B > 0){
            return 1.0;
        }
        else if(A > 0 && B <= 0){
            return 0.0;
        }
        else if(A <= 0 && B <= 0){
            return 0.5;
        }else {
            if(dp[A][B] != 0)
                return dp[A][B];
            double v = 0.25*(dfs(A-4,B) + dfs(A-3,B-1) + dfs(A-2,B-2) + dfs(A-1,B-3));
            dp[A][B] = v;
            return v;
        }
	}
	
	
    public static double soupServings(int N) {
    	
    	if(N>=5000) {
        	return 1.0;
        }
    	
    	N=(int)Math.ceil(N/25.0);
    	dp = new double[N+1][N+1];
        
    	return dfs(N,N);
    }
    
    public static void main(String[] args){
    	String[] candidates = {};
    	System.out.println(soupServings(26));
    }
    
    
}

/*
 * 自底向上
 * 
 *     public static double soupServings(int N) {
    	
    	if(N>=5000) {
        	return 1.0;
        }
    	
    	N=(int)Math.ceil(N/25.0);
    	double[][] dp = new double[N+1][N+1];
        dp[0][0]=0.5;
        for(int i=1;i<N+1;i++) {
        	dp[i][0]=0;
        	dp[0][i]=1;
        }
    	
    	for(int i=1;i<N+1;i++){
    		
			int a1=i-4>=0?i-4:0;
			int a2=i-3>=0?i-3:0;
			int a3=i-2>=0?i-2:0;
			int a4=i-1>=0?i-1:0;
			
    		for(int j=1;j<N+1;j++){
    			
    			int b1=j-0>=0?j-0:0;
    			int b2=j-1>=0?j-1:0;
    			int b3=j-2>=0?j-2:0;
    			int b4=j-3>=0?j-3:0;
    			
    			dp[i][j] = 0.25*(dp[a1][b1]+dp[a2][b2]+dp[a3][b3]+dp[a4][b4]);
    		}
    	}
    	return dp[N][N];
    }
 */

/*
 * 
 * 超出内存限制
public static double soupServings(int N) {
	
	double[][] dp = new double[N+1][N+1];
	
    dp[0][0]=0.5;
    for(int i=1;i<N+1;i++) {
    	dp[i][0]=0;
    	dp[0][i]=1;
    }
	
	for(int i=1;i<N+1;i++){
		
		int a1=i-100>=0?i-100:0;
		int a2=i-75>=0?i-75:0;
		int a3=i-50>=0?i-50:0;
		int a4=i-25>=0?i-25:0;
		
		for(int j=1;j<N+1;j++){

			
			int b1=j-0>=0?j-0:0;
			int b2=j-25>=0?j-25:0;
			int b3=j-50>=0?j-50:0;
			int b4=j-75>=0?j-75:0;
			
			dp[i][j] = 0.25*(dp[a1][b1]+dp[a2][b2]+dp[a3][b3]+dp[a4][b4]);
		}
	}
	return dp[N][N];
}


 */
