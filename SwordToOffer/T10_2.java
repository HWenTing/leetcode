package SwordToOffer;

public class T10_2 {

//	一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
//	答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

//	dp[i] = dp[i-1]+dp[i-2] 
    public int numWays(int n) {
    	if(n<2) return 1;
    	int a = 1;
    	int b = 1;
    	
    	int temp;
    	while(n>1){
    		n--;
    		temp = a+b;
    		a = b;
    		b = temp%1000000007;
    	}
    	return b;
    }
    
}
