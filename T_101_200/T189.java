package T_101_200;

public class T189 {

//	给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//	要求使用空间复杂度为 O(1) 的 原地 算法
	
//	模拟移动过程  时间Okn 时间击败33%
//    public void rotate(int[] nums, int k) {
//    	for(int i=0;i<k;i++){
//    		int temp=nums[nums.length-1];
//    		for(int j=nums.length-2;j>=0;j--){
//    			nums[j+1]=nums[j];
//    		}
//    		nums[0]=temp;
//    	}
//    }
    
//	分别反转前后部分，然后再整体翻转
//	要注意反转很多圈的情况
//	时间击败100%，空间95%
    public void rotate(int[] nums, int k) {
    	k=k%nums.length;//要注意处理一下
    	reverse(nums,0,nums.length-1-k);
    	reverse(nums,nums.length-k,nums.length-1);
    	reverse(nums,0,nums.length-1);
    }
    
    private void reverse(int[] nums,int start,int end){
    	while(start<end){
    		int temp = nums[end];
    		nums[end] = nums[start];
    		nums[start] = temp;
    		start++;
    		end--;
    	}
    }
    
    
    
    
    
    
    
    
    
	
}
