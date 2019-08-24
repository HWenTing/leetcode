package T_901_1000;

public class T983 {

	
//	不会。。。
//	dp
//	击败94
    public int mincostTickets(int[] days, int[] costs) {
        int lastday = days[days.length-1];
        int[] dp = new int[lastday+1];
        
        for(int i:days)
        	dp[i]=-1;
        
        for(int i=1;i<=lastday;i++){
        	if(dp[i]==0)//当天不旅行，花费等于前一天的
        		dp[i]=dp[i-1];
        	else{//当天旅行
        		int ticket1 = i-1>0?i-1:0;
        		int ticket7 = i-7>0?i-7:0;
        		int ticket30 = i-30>0?i-30:0;
//        		三种情况的最小值
        		int temp = Math.min(dp[ticket1]+costs[0], dp[ticket7]+costs[1]);
        		dp[i]=Math.min(dp[ticket30]+costs[2], temp);
        	}
        	
        }
    	return dp[lastday];
    }
    

    
}
