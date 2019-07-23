package T_301_400;

public class T377 {

//	竟然一遍就ac了。。用了dp思想
//	首先令数组nums里的每个num   有dp[num]=1
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int []dp = new int[target+1];
        for(int i:nums){
        	if(i<=target)
        		dp[i]=1;	
        }
    	for(int i=0;i<=target;i++){//可重复选取元素应从0到target遍历
    		for(int num:nums){//求解顺序的完全背包问题时，对物品的迭代应该放在最里层
    			if(num+i<=target){
    				dp[num+i]+=dp[i];
    			}
    		}
    	}
    	return dp[target];
    }
    
    
	public static void main(String[] args) {
		int []nums =new int[]{1, 2, 3};
		T377 t = new T377();
		System.out.println(t.combinationSum4(nums, 4));
	}
	

}
