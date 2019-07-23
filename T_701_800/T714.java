package T_701_800;


public class T714 {

//	这个题和309十分相似 两个数组分别记录两种状态
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if(len<2)
        	return 0;
        
        int sell[] = new int[len];
        int buy[] = new int[len];
        
        buy[0] = -prices[0];
        
        for(int i=1;i<len;i++){
        	sell[i] = Math.max(sell[i-1] , buy[i-1]+prices[i]-fee);
        	buy[i] =  Math.max(buy[i-1] , sell[i-1]-prices[i]);
        }
        
        return sell[len-1];
    }
    
    
	public static void main(String[] args) {
		T714 t = new T714();
    	int[] prices = new int[] {1, 3, 2, 8, 4, 9};
    	System.out.println(t.maxProfit(prices,2));
	}

}
