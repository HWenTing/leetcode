package T_301_400;

public class T357 {

//	给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
	
//	dp，每多一位数，在前一位的基础上增加

//	dp[0]  1
//	dp[1]  dp[0]+9
//	dp[2]  dp[1]+9*9;
//	dp[3]  dp[2]]+9*9*8;
	
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp=new int[11];
        dp[0]=1;
        for(int i=1;i<=10;i++){
        	int p=1;
        	int temp=9;
        	while(p<i){
        		temp*=(10-p);
        		p++;
        	}
        	dp[i]=dp[i-1]+temp;
        }
        
        return n>10?dp[10]:dp[n];
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
