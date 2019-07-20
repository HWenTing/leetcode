package T_501_600;
import java.util.Arrays;

public class T581 {
////	获取所有当前数组与排序后数组具有不同数值的索引，最右边的索引 - 最左边的 + 1 就是结果
//	public int findUnsortedSubarray(int[] nums) {
//        int [] nums_order = new int[nums.length];
//
//        for(int i =0;i<nums.length;i++){
//            nums_order[i] = nums[i];
//        }
//        Arrays.sort(nums_order);
//        int start =0;int end = nums.length-1;
//        while(start<end&&nums[start]==nums_order[start]){
//            start++;
//        }
//        while(end>start&&nums[end]==nums_order[end]){
//            end--;
//        }
//        return end==start?0:(end-start+1);
//    }
	
	
//	这个方法更快，不需要排序，先找乱序的部分，然后再扩展边界
	public int findUnsortedSubarray(int[] nums) {
        int ans=0,lo=0,hi=nums.length-1,cntlo=0,cnthi=0;
        while(lo<hi&&nums[lo]<=nums[lo+1]){
            lo++;
        }
        while(lo<hi&&nums[hi-1]<=nums[hi]){
            hi--;
        }
        if(lo==hi)
            return 0;
        //说明lo的右边和hi的左边开始无序了
        //但是这个不一定是结果，因为如果里面最大的比边界大的话，边界也是要外扩的
        //记录里面最大和最小的
        int max=nums[lo],min=nums[lo];
        for(int i=lo;i<=hi;i++){
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
        }
        //然后一步步往外扩
        while(lo>=0&&nums[lo]>min){
                lo--;
        }
        while(hi<nums.length&&nums[hi]<max){
                hi++;
        }
        //无序的是下标为lo+1,hi-1之间的数据
        return hi-lo-1;
    }
	 
	 
//	dp
//	max[i]表示前i个最大的元素....不对，做不出来
//    public int findUnsortedSubarray(int[] nums) {
//        int len = nums.length;
//        int []max = new int[len];
//        max[0] = nums[0];
//        for(int i=1;i<len;i++){//
//        	max[i] = Math.max(max[i-1], nums[i]);
//        }
//        
//        int []dp = new int[len];
//        dp[0] = 0;
//        int source = 0;
//        for(int i=1;i<len;i++){
//        	if(nums[i]<max[i-1]){
//        		source = i;
//        		break;
//        	}
//        }
//        
//        for(int i=1;i<len;i++){
//        	if(nums[i]>=max[i-1])
//        		dp[i]=dp[i-1];
//        	else
//        		dp[i]=i-source;
//        }
//        
//        return dp[len-1];
//    }
    
    
	public static void main(String [] args){
		T581 t = new T581();
		int a [] = {2,6,4,8,10,9,15};
		System.out.println(t.findUnsortedSubarray(a));
	 }
}
