package T_401_500;


//可以当作sum/2的 0、1背包问题
public class T416 {
    
    public boolean canPartition(int[] nums) {
    	int sum =0;
    	for(int num:nums){
    		sum+=num;
    	}
    	if(sum%2!=0)
	      	return false;
	  	int n=nums.length;
	  	int bag = sum/2;
	  	
	  	boolean [][]dp = new boolean[n][bag+1];   
	  	
	  	
	  	for(int i=0;i<bag+1;i++){
	  		if(nums[0]==i)
	  			dp[0][i]=true;
	  	}
	  	
	  	for(int i=1;i<n;i++){
	  		for(int j=0;j<bag+1;j++){
	  			if(j>=nums[i]){
	  				dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
	  			}else{
	  				dp[i][j]=dp[i-1][j];
	  			}
	  		}
	  	}
	  	
	  	return dp[n-1][bag];
	  	
    }

    	
    public static void main(String[] args){
    	int[] a =new int[]{5, 1, 11, 5};
    	
    	T416 t =new T416();
    	System.out.println(t.canPartition(a));
    }
}
