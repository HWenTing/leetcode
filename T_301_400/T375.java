package T_301_400;

public class T375 {

//	猜数字2，没思路。。。
//	要求再每次都猜错的情况下的总体最大开销
	
	
//	暴力法
//	时间复杂度n！
//	private int dfs(int start,int end){
//		if(end<=start) return 0;
//		int ret = Integer.MAX_VALUE;
//		int temp;
//        		System.out.println(start+" "+end);
//		for(int i=start;i<end;i++){
//			temp = i+Math.max(dfs(start,i-1), dfs(i+1,end));
//			ret=Math.min(ret, temp);
//		}
//		return ret;
//	}
//	
//    public int getMoneyAmount(int n) {
//        return dfs(1,n);
//    }
    
//	dp动态规划的思想
	
	/*	以n=5为例
	 * 
	 *   0  1  2  4  6
	 *   -  0  2  3  6
	 *   -  -  0  3  4
	 *   -  -  -  0  4
	 *   -  -  -  -  0
	 */
	
	public int getMoneyAmount(int n) {
		int[][] dp = new int[n+1][n+1];
		
		for(int len=2;len<=n;len++){//斜	对角线
			for(int start=1;start<=n-len+1;start++){
				int temp = Integer.MAX_VALUE;
				for(int mid = start;mid<start+len-1;mid++){
					int res = mid+Math.max(dp[start][mid-1], dp[mid+1][start+len-1]);
					temp = Math.min(temp, res);
				}
				dp[start][start+len-1] = temp;
			}
		}
		return dp[1][n];
	}
	
	
}




