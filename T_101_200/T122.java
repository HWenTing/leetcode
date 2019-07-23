package T_101_200;

public class T122 {

//	这个题确实比较简单。。只要第二天比前一天高就把差加在ans里即可
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len<2)
        	return 0; 
        
        int ans=0;
        for(int i=1;i<len;i++){	
        	if(prices[i]>prices[i-1])
        		ans+=prices[i]-prices[i-1];
        }
        return ans;
    }
    
    
}
