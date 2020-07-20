package SwordToOffer;

public class T63 {

//	假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
	
	
    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0; 
        
    	int firstbuy = Integer.MIN_VALUE;//记录前面的最小值
    	int firstsell = 0;
    	
    	
    	for(int pri:prices){
    		firstbuy = Math.max(firstbuy, -pri);
    		firstsell = Math.max(firstsell, pri+firstbuy);
    	}
    	return firstsell;
    }
    
}
