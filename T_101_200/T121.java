package T_101_200;

public class T121 {

//	做完了123，再回来看121，就简单很多
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2)
        	return 0; 
        
        int firstBuy =Integer.MIN_VALUE;//在该天第一次买入股票可获得的最大收益
        int firstSell =0;//在该天第一次卖出股票可获得的最大收益
        
        for(int pri:prices){
        	firstBuy = Math.max(firstBuy, -pri);//第一次买时的收益就取价格最小时
        	firstSell = Math.max(firstSell, firstBuy+pri);
        }
        return firstSell;
    }
    
    
    
}
