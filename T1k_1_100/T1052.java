package T1k_1_100;

public class T1052 {

	
//	今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
//	在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
//	书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
//	请你返回这一天营业下来，最多有多少客户能够感到满意的数量。

//	滑动窗口
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    	if(X>=customers.length) {
    		int ret = 0;
    		for(int i:customers)
    			ret+=i;
    		return ret;
    	}
    	
    	int base = 0;
        for(int i=0;i<X;i++)//滑动窗口再最左边 前X都求和
        	base+=customers[i];
        
        for(int i=X;i<customers.length;i++){
        	if(grumpy[i]==0)
        		base+=customers[i];
        }
        
        int max = base;
        for(int i=X;i<customers.length;i++){//窗口向右滑动
        	if(grumpy[i-X]==1)//进来
        		base-=customers[i-X];
        	if(grumpy[i]==1)//出去
        		base+=customers[i];
        	max = Math.max(base, max);
        }
        return max;
        
    }
    
}
