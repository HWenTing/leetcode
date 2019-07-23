package T_101_200;

public class T188 {
	
//	这个题和123很像，求只能交易k次的最大收益，可以进行推广
//	。。。。直接推广内存爆了。。。看来要对k进行处理
    public int maxProfit(int k, int[] prices) {
    	
    	int len = prices.length;
        if(len<2 || k==0)//注意k为0的情况
        	return 0;
        
        if(k>len/2)//对k进行减半处理就不会爆了。。
        	return greedy(prices);
        	
        int []buy = new int[k];//在该天第i次买入股票可获得的最大收益
        int []sell = new int[k];//在该天第i次卖出股票可获得的最大收益
        for(int i=0;i<k;i++)
        	buy[i]=Integer.MIN_VALUE;
        
        for(int pri:prices){
        	//第一次特殊处理
    		buy[0] = Math.max(buy[0], -pri);
    		sell[0] = Math.max(sell[0], buy[0]+pri);
    		
        	for(int i=1;i<k;i++){
        		buy[i] = Math.max(buy[i], sell[i-1]-pri);//第i次买时的收益是第i-1次卖减去第i次买的价格
        		sell[i] = Math.max(sell[i], buy[i]+pri);
        	}
        }
        return sell[k-1];
    }
    
    private int greedy(int[] prices) {//退化成T122的形式，直接贪心就好，能多击败45%的人。。
        int max = 0;
        for(int i = 1; i < prices.length; ++i) {
            if(prices[i] > prices[i-1])
                max += prices[i] - prices[i-1];
        }
        return max;
    }
    
}
