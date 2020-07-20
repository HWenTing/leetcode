package T_1_100;

public class T41 {

	
//	给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
//	你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
	
    public int firstMissingPositive(int[] nums) {
        int len  = nums.length;
        int temp;
        int pos;
    	for(int i=0;i<len;i++){
    		if(nums[i]>0 && nums[i]<=len && nums[i]!=nums[nums[i]-1] ){//防止出现反复横跳无限循环的情况
    			pos = nums[i]-1;//交换元素
    			temp = nums[pos];
    			nums[pos]=nums[i];
    			nums[i]=temp;
    			if(i<pos){//这里也可以写成i!=pos
    				i--;
    			}
    		}
    	}
    	
    	for(int i =0;i<len;i++){
    		if(nums[i]!=i+1){
    			return i+1;
    		}
    	}
    	return len+1;
    }
    
    
}
