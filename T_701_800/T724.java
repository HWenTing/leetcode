package T_701_800;

public class T724 {

//	给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
//	我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
//	如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
	
//	求正反两个前缀和
    public int pivotIndex(int[] nums) {
    	if(nums.length==0) return -1;
    	 
    	int[] sumleft = new int[nums.length];
    	sumleft[0]=nums[0];
    	for(int i=1;i<nums.length;i++){
    		sumleft[i]=sumleft[i-1]+nums[i];

    	}
    	
    	int[] sumright = new int[nums.length];
    	sumright[nums.length-1]=nums[nums.length-1];
    	for(int i=nums.length-2;i>=0;i--){
    		sumright[i]=sumright[i+1]+nums[i];
    	}
    	
    	for(int i=0;i<nums.length;i++){
    		if(sumleft[i]==sumright[i])
    			return i;
    	}
    	return -1;
    }
    
}
