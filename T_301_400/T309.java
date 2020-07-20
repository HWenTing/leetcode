package T_301_400;

public class T309 {

//	用两个数组来记录不同状态，不同状体之间还会相互影响
	
    public int maxProfit(int[] prices) {
    	int len = prices.length;
    	if(len<2)
    		return 0;
    	
    	int []sell = new int[len+1];//截至到第i天最后一个操作是卖操作的最大收益
    	int []buy = new int[len+1];//截至到第i天最后一个操作是买操作的最大收益
    	
    	buy[1] = -prices[0];
    	for(int i=2;i<=len;i++){
    		sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i-1]);//今天卖 要考虑昨天卖了 和前天买了今天卖
    		buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i-1]);
    	}
    	
    	 return sell[len];
    }
    
    
    
    
    
//	下边的做法错了，犯了短视的错误
//	6,1,3,2,4,7样例，正确答案是6（7-1），而求出5
	
//    public int maxProfit(int[] prices) {
//        int len = prices.length;
//        int ans=0;
//        if(len<=4){
//        	for(int i=0;i<len-1;i++){
//        		for(int j=1;j<len;j++){
//        			ans = Math.max(ans,prices[j]-prices[i]);
//        		}
//        	}
//        	return ans;
//        }
//        
//        int []dp = new int[len+1];
//        dp[2] = Math.max(0, prices[1]-prices[0]);
//        dp[3] = Math.max(dp[2], Math.max(prices[2]-prices[0], prices[2]-prices[1]));
//        int temp = Math.max(prices[3]-prices[0], prices[3]-prices[1]);
//        dp[4] = Math.max(dp[3],Math.max(temp, prices[3]-prices[2]));
//        
//        for(int i=5;i<=len;i++){
//        	dp[i]=Math.max(dp[i-2], dp[i-3]+prices[i-1]-prices[i-2]);
//        }
//        
//        for(int i :dp)
//        	System.out.print(i+" ");
//        System.out.println();
//        return dp[len];
//    }
    
    public static void main(String[] args){
    	T309 t = new T309();
    	int[] prices = new int[] {6,1,5,2,4,7};
    	System.out.println(t.maxProfit(prices));
    }
}
