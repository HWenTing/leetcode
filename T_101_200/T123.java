package T_101_200;

public class T123 {

//	qnq没有思路 ，看了一些题解，发现思路还是相似的，对每个状态进行维护
	
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2)
        	return 0;
        
        int firstBuy =Integer.MIN_VALUE;//在该天第一次买入股票可获得的最大收益
        int firstSell =0;//在该天第一次卖出股票可获得的最大收益
        int secondBuy =Integer.MIN_VALUE;//在该天第二次买入股票可获得的最大收益
        int secondSell =0;//在该天第二次卖出股票可获得的最大收益
        
        for(int pri:prices){
        	firstBuy = Math.max(firstBuy, -pri);//第一次买时的收益就取价格最小时
        	firstSell = Math.max(firstSell, firstBuy+pri);
        	secondBuy = Math.max(secondBuy, firstSell-pri);//第二次买时的收益是第一次卖减去第二次买的价格
        	secondSell = Math.max(secondSell, secondBuy+pri);
        }
        return secondSell;
        
    }
    
	public static void main(String[] args) {

	}

}
