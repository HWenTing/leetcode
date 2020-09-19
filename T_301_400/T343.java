package T_301_400;

public class T343 {
	
//	给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
	
//	用递归试试...emmm似乎行不通
//    public int integerBreak(int n) {
//    	if(n<=2)
//    		return 1;
//    	int mid = n%2==0?n/2-1:n/2;
//    	int left = n-mid;
//    	
//    	int a=Math.max(integerBreak(mid),mid);
//    	int b=Math.max(integerBreak(left),left);
//    	return Math.max(a*b,(n/2)*(n/2));
//    }
	
	
	
//	还是用动态规划吧
//	public int integerBreak(int n) {//下标从0开始，中间的转换可能比较绕
//		if(n==0)
//			return 0;
//		int[] dp = new int[n];
//		dp[0]=1;
//		for(int i=1;i<n;i++){
//			for(int j=0;j<i;j++){
//				dp[i] = Math.max(dp[i], Math.max((j+1)*(i-j), (j+1)*dp[i-j-1]));
//			}
//		}
//		return dp[n-1];
//	}
	//剑指offer14.1
	public int integerBreak(int n) {//下标从1开始，较为清晰
		if(n==0)
			return 0;
		int[] dp = new int[n+1];
		dp[1]=1;
		for(int i=2;i<=n;i++){
			for(int j=1;j<i;j++)
				dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
		}
		
		return dp[n];
	}
	
	
    public static void main(String[] args){
    	T343 t =new T343();
    	for(int i=0;i<10;i++){
    		System.out.println(t.integerBreak(i));
    	}
    	
    }
    
}
