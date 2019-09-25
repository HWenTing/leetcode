package T_201_300;

public class T215 {

//	在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//	速度击败32%，空间击败90%
//	基于快排的思想 ，自己实现的不算优雅
	
//    public int findKthLargest(int[] nums, int k) {
//    	return quickfind(nums,0,nums.length-1,k-1	);
//    }
//    
//    private int quickfind(int[] nums,int left,int right,int k){//基于快排的思想
//    	if(left==right) return nums[left];
//    	
//    	int forleft = left;int forright = right;
//    	int pos=left;
//    	while(left<right){
//    		while(left<right && nums[right] <= nums[pos])
//    			right--;
//    		
//    		while(left<right && nums[left] >= nums[pos])
//    			left++;
//    		
//    		if(left>=right) break;
//    		
//    		int temp = nums[left];
//    		nums[left] = nums[right];
//    		nums[right] = temp;
//
//    	}
//    	
//		int temp = nums[left];
//		nums[left] = nums[pos];
//		nums[pos] = temp;
//		
//		if(left==k)
//			return nums[left];
//		else if(left<k)
//			return quickfind(nums,left+1,forright,k);
//		else
//			return quickfind(nums,forleft,left-1,k);
//		
//    }
    
	
	
//	比较优雅的实现
//	很神奇的是，使用choosePivotIndex选取基准以后，速度能够右非常大的提升，击败100%。。。
	
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, nums.length - k, 0, nums.length-1);
    }
    
//    快排
    public int partition(int[] nums, int k, int s, int e) {
        int i = s;
        int j = e;

        int mid = s + (e - s) / 2;
        int to = choosePivotIndex(nums, s, mid, e);
        swap(nums, s, to);

        int flag = nums[s];
        while(i < j) {
            while(i < j && nums[j] >= flag) //先右
                j--;
            nums[i] = nums[j];
            
            while(i < j && nums[i] <= flag) //后左
                i++;
            nums[j] = nums[i];
        }
        
        if(i == k) 
            return flag;
        else if(i > k) 
            return partition(nums, k, s,i - 1);
        else 
            return partition(nums, k,i + 1, e);
    }
    
//    返回三个元素中，中间的数
    public int choosePivotIndex(int[] nums, int a, int b, int c){
        if(nums[a] > nums[b]){
            if(nums[c] > nums[a])
                return a;
            else if(nums[c] > nums[b])
                return c;
            else
                return b;
        }
        else{
            if(nums[c] > nums[b])
                return b;
            else if(nums[c] > nums[a])
                return c;
            else
                return a;
        }
    }
//    交换元素
    public void swap(int[] N, int i, int j) {
        int tmp = N[i];
        N[i] = N[j];
        N[j] = tmp;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//  private void dfs(int[] nums,int left,int right){//似乎这个快排是没问题的
//	if(left>=right) return ;
//	int forleft = left;int forright = right;
//	
//	int pos=left;
//	while(left<right){
//		while(left<right && nums[right] <= nums[pos])
//			right--;
//		
//		while(left<right && nums[left] >= nums[pos])
//			left++;
//		
//		if(left>=right) break;
//		
//		int temp = nums[left];
//		nums[left] = nums[right];
//		nums[right] = temp;
//
//	}
//	
//	int temp = nums[left];
//	nums[left] = nums[pos];
//	nums[pos] = temp;
//	dfs(nums,forleft,left-1);
//	dfs(nums,left+1,forright);
//	
//}
    
}
