package T_301_400;

public class T398 {

//	给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
//	数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。

//	蓄水池抽样算法 给定一个数据流，长度N很大，且N在遍历完数据之前不可知，如何在只便利一遍O(n)的情况下，能够随机选取m个不同的元素。
//	思路是先取m个元素放到蓄水池中，当i>=m时，在[0,i]中取随机数d，若d在[0，m-1]中，则用该元素替换蓄水池中的第d个元素
//	同T382
	
	int[] nums;
    public T398(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int ans = -1;
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==target){
        		cnt++;
        		if((int)(Math.random()*cnt)==0){
        			ans = i;
        		}
        	}
        }
        return ans;
    }
    
}
