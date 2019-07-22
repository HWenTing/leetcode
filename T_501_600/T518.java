package T_501_600;


public class T518 {


//	dp问题
    public int change(int amount, int[] coins) {

        if(amount==0 && coins.length==0)
            return 1;
        if(coins.length==0)
        	return 0;
        
    	int []dp = new int[amount+1];
    	dp[0]=1;
    	
    	for(int coin:coins){
    		for(int i=coin;i<=amount;i++){
    			dp[i] = dp[i]+dp[i-coin];//不使用该coin（dp[i]）和使用该coin（dp[i-coin]）可能之和
    		}

//        	for(int i:dp){//输出dp矩阵
//	    		System.out.print(i+" ");
//	    	}
//	    	System.out.println();
    	}
    	return dp[amount];
    }
    
	public static void main(String[] args) {
		int []coins = new int[]{1,2,5};
		T518 t =new T518();
		System.out.println(t.change(3,coins ));
	}

}
