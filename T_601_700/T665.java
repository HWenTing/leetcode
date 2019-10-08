package T_601_700;

public class T665 {
//	给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//	我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]
	
	  // 思路如下：
    // 如果出现 a[i] > a[i+1]   改变一个数 就面临两种选择
    // 1. 把a[i]变大
    // 2. 把a[i+1] 变小
    // 这两种选择其实是有依据的 需要比较a[i-1] 与 a[i+1]的值
    // eg.  ... 1 4 3 ...   只能选择把4变小   ... 3 4 1 ... 只能选择把1变大
    // 改变完之后，记录改变次数，再检测是否升序
    // 如果次数大于1，至少改了两次 返回false
    
    // 先让前两个有序
    // 因为没有左边没有数 所以对于前两个数来说，最佳选择就是把 a[0] 变小
	
    public boolean checkPossibility(int[] nums) {
        if(nums.length<=2)
        	return true;
        int cnt=0;
        if(nums[0]>nums[1]){
        	nums[0]=nums[1];
        	cnt++;
        }
        
        for(int i=1;i<nums.length-1;i++){
        	if(nums[i]>nums[i+1]){
        		cnt++;
        		if(cnt>1) return false;
        		
        		if(nums[i-1]>nums[i+1]){
        			nums[i+1]=nums[i];
        		}else{
        			nums[i]=nums[i-1];
        		}
        	}
        }
        return true;
        	
    }
    

}



















