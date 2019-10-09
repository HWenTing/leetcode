package T_701_800;

public class T747 {

//	在一个给定的数组nums中，总是存在一个最大元素 。
//	查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
//	如果是，则返回最大元素的索引，否则返回-1。
	
	
//	最大的数比第二大的数大两倍即可
    public int dominantIndex(int[] nums) {
    	if(nums.length==1) return 0;
        int max=Integer.MIN_VALUE;
        int secmax=Integer.MIN_VALUE;
        int index=0;
        for(int i=0;i<nums.length;i++){
        	int temp=nums[i];
        	if(temp>=max){
        		secmax=max;
        		max = temp;
        		index=i;
        	}else if(temp>secmax){
        		secmax=temp;
        	}
        }
        return max-2*secmax>=0?index:-1;
    }
    
}
