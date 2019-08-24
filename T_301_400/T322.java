package T_301_400;

public class T322 {

//	典型的dp问题,可重复选取元素
//	dp[i] = Math.min(dp[i],dp[i-coin]+1) 
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
        	return -1;
    	int []dp = new int[amount+1];
    	for(int i=1;i<=amount;i++){
    		//这个地方之所以赋最大值-1，是因为下边dp[i] = Math.min(dp[i],dp[i-coin]+1)时，Integer.MAX_VALUE+1溢出了，变为负
    		dp[i]=Integer.MAX_VALUE-1;
    	}
    	
    	for(int coin:coins){
   
    		for(int i=coin;i<=amount;i++){//这里从小到大，因为可以重复选取元素。
    			dp[i] = Math.min(dp[i],dp[i-coin]+1);
    		}
//        	for(int i:dp){//输出dp矩阵
//        		System.out.print(i+" ");
//        	}
//        	System.out.println();
    	}
    	return dp[amount]==Integer.MAX_VALUE-1?-1:dp[amount];
    }
    
    
  
//    这个和上边思路是一样的
//    public int coinChange(int[] coins, int amount) {
//        int dp[] =new int[amount+1];
//        dp[0]=0;
//        for(int i=1;i<=amount;i++) dp[i]=amount+1;
//        for(int i=1;i<=amount;i++){
//            for(int coin:coins){
//                if(coin<=i){
//                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
//                }
//            }
//        }
//        return dp[amount]>amount? -1:dp[amount];
//    }
    
    
	public static void main(String[] args) {
		int []coins = new int[]{2};
		T322 t =new T322();
		System.out.println(t.coinChange(coins, 3));
	}

}
