package T_401_500;

public class T493 {

//	给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
//  你需要返回给定数组中的重要翻转对的数量。

//归并 在归并的同时 考虑翻转对
	
	private int ans;
	private int[] temp;
    public int reversePairs(int[] nums) {
    	ans = 0;
    	temp = new int[nums.length];
    	sort(nums,0,nums.length);

    	return ans;
    }
    
    public void sort(int[] nums,int left,int right) {
    	if(left+1>=right) return;
    	int mid = (right-left)/2+left;
    	sort(nums,left,mid);
    	sort(nums,mid,right);
    	merge(nums,left,mid,right);
    	
    }
    
    private void merge(int[] nums,int left,int mid,int right){
    	
    	int first = left;
    	int second = mid;
    	
    	int ptr = left;
    	while(first<mid && second<right){
    		if(nums[first]<nums[second]){
    			temp[ptr++] = nums[first++];
    		}else{
    			temp[ptr++] = nums[second++];
    		}
    	}
    	while(first<mid)
    		temp[ptr++] = nums[first++];
    	while(second<right)
    		temp[ptr++] = nums[second++];
    	
    	
    	//归并额外的逻辑 开始
    	first = left;
    	second = mid;
    	while(first<mid && second<right){
    		if((long)nums[first]>(long)2*nums[second]){//这里小心溢出
    			ans+=mid-first;
    			second++;
    		}else{
    			first++;
    		}
    	}
    	//归并额外的逻辑 结束
    	
    	for(int i=left;i<right;i++)
    		nums[i] = temp[i];
    }
} 
