package T_101_200;

import java.util.Arrays;

public class T164 {
	
//	给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
//	如果数组元素个数小于 2，则返回 0。
//	你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
//	请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
	
//	线性时间复杂度要求不能用普通的排序方式 可以想到桶排序，但是因为数值在 32 位有符号整数范围内，很大，如果直接用数组的话所需空间很大
//	看了题解 用桶排序和鸽巢原理结合起来。
//	第i个桶可以装min+(i-1)*interval ~ min+i*interval-1 范围内的数，interval的选择要保证同一个桶里边的最大差值小于桶之间的差值。
//	如果出现一个空桶，那么该桶左边的最大值和右边的最小值之差一定大于等于interval，而同一个桶之内的差值最大是interval-1，因此只要多分出来一个桶即可
//	综合鸽巢原理，interval = (int) Math.ceil((max-min)/(double)len);
	
	
    public int maximumGap(int[] nums) {
    	int len = nums.length;
    	if(len<2) return 0;
    	
    	int max = -1;
    	int min = Integer.MAX_VALUE;
    	
    	for(int i:nums){//取最值
    		max = Math.max(max, i);
    		min = Math.min(min, i);
    	}
    	
//    	算interval值
    	int interval = (int) Math.ceil((max-min)/(double)len);
    	if(interval==0) return 0;
    	
//    	存储每个箱子的最大最小值
    	int[] boxmax = new int[len+1];
    	int[] boxmin = new int[len+1];
    	Arrays.fill(boxmax, -1);
    	Arrays.fill(boxmin, Integer.MAX_VALUE);
    	for(int num:nums){
    		int index = (num-min)/interval;
    		boxmax[index] = Math.max(boxmax[index], num);
    		boxmin[index] = Math.min(boxmin[index], num);
    	}
    	
//    	算最大间隔
    	int ans = 0;
    	int previous = min;
    	for(int i=0;i<=len;i++){
    		if(boxmax[i]<0) continue;
    		ans = Math.max(ans, boxmin[i]-previous);
    		previous = boxmax[i];
    	}
    	return ans;
    }
    
}
