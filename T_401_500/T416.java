package T_401_500;


//可以当作sum/2的 0、1背包问题
public class T416 {
    
//    public boolean canPartition(int[] nums) {
//    	int sum =0;
//    	for(int num:nums)
//    		sum+=num;
//    	if(sum%2!=0)//没法平均分
//	      	return false;
//    	int bag = sum/2;
//    	
//    	for(int num:nums)
//    		if(num>bag)//只一个元素就大于总和的一半，那么肯定没法平均分
//    			return false;
//	  	
//	  	//dp[i][j] 表示 只用前i个元素能否 找到和为j的集合
//	  	boolean [][]dp = new boolean[nums.length][bag+1];   
//	  	dp[0][nums[0]]=true;
//	  	
//	  	for(int i=1;i<nums.length;i++){
//	  		for(int j=0;j<bag+1;j++){
//	  			if(j>=nums[i])
//	  				dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
//	  			else
//	  				dp[i][j]=dp[i-1][j];
//	  		}
//	  		if(dp[i][bag])//剪枝
//	  			return true;
//	  	}
//	  	return false;
//    }

//	空间优化过的 
    public boolean canPartition(int[] nums) {
    	int sum =0;
    	for(int num:nums)
    		sum+=num;
    	if(sum%2!=0)//没法平均分
	      	return false;
	  	int bag = sum/2;
	  	
    	for(int num:nums)
    		if(num>bag)//只一个元素就大于总和的一半，那么肯定没法平均分
    			return false;
    	
	  	
	  	boolean []dp = new boolean[bag+1];   
	  	dp[0]=true;
	  	
	  	for(int num:nums){//从第一个到最后一个
	  		for(int i=bag;i>=num;i--){// 防止同一层前边修改的元素影响后边
	  			dp[i] = dp[i] || dp[i-num];
	  		}
	  		if(dp[bag])//剪枝
	  			return true;
	  	}
	  	return false;
    }
    
    	
    public static void main(String[] args){
    	int[] a =new int[]{5, 1, 11, 5};
    	
    	T416 t =new T416();
    	System.out.println(t.canPartition(a));
    }
}
