package T_401_500;

public class T486 {

//	给定一个表示分数的非负整数数组。 玩家1从数组任意一端拿取一个分数，随后玩家2继续从剩余数组任意一端拿取分数，然后玩家1拿，……。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
//	给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。


	
//	dp[i][j]表示从nums[i]到nums[j]先手比另一位玩家多的最大分数，最后返回dp[0][nums.length-1]是否大于0即可
//
//	对于dp[i][j]，如果先手拿了nums[i]，则另一位玩家比先手多dp[i+1][j]，dp[i][j] = nums[i]-dp[i+1][j]，如果先手拿了nums[j]，则另一位玩家比先手多dp[i][j-1]，dp[i][j] = nums[j]-dp[i][j-1]
//	综上，dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1])
//	当i=j时，先手一定赢，比另一位玩家多dp[i][j]=nums[i]

//	偶数个数一定先手赢，因为先手可以判断奇数列和 和 偶数列和，如果偶数和大，那么每次只选偶数位的即可
    public boolean PredictTheWinner(int[] nums) {
    	int[][] dp = new int[nums.length][nums.length];
//    	for(int i=0;i<nums.length;i++)
//    		dp[i][i]=nums[i];
    	
    	for(int i=nums.length-1;i>=0;i--){
    		dp[i][i]=nums[i];
    		for(int j=i+1;j<nums.length;j++){
    			dp[i][j] = Math.max(nums[i]-dp[i+1][j],nums[j]-dp[i][j-1]);
    		}
    	}
    	return dp[0][nums.length-1]>=0;
    }
    
    
    
    
    
    
    
    
    
    
//    下边的错了。。看来没这么简单。。。
//    public boolean PredictTheWinner(int[] nums) {
//    	if(nums.length<=1)return true;
//    	
//    	int onesum=0;
//    	int twosum=0;
//    	int left=0;
//    	int right=nums.length-1;
//    	boolean oneturn=true;
//    	
//    	while(right-left>=2){
//    		int add;
//    		if(nums[left]-Math.max(nums[left+1], nums[right])>=nums[right]-Math.max(nums[left], nums[right-1])){
//    			add=nums[left];
//    			left++;
//    		}else{
//    			add = nums[right];
//    			right--;
//    		}
//    		if(oneturn)
//    			onesum+=add;
//    		else
//    			twosum+=add;
//    		oneturn=!oneturn;
//    	}
//    	if(oneturn){
//    		onesum+=Math.max(nums[left],nums[right]);
//    		twosum+=Math.min(nums[left],nums[right]);
//    	}else{
//    		onesum+=Math.min(nums[left],nums[right]);
//    		twosum+=Math.max(nums[left],nums[right]);
//    	}
//    	return onesum>=twosum;
//    	
//    	
//    }
    
}
