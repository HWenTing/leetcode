package SwordToOffer;

import java.util.Arrays;

public class T51 {

//	在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
	
//	感觉像是冒泡排序 可能超时  使用归并排序 与T315类似
    public int reversePairs(int[] nums) {
    	
    	int[] temp = new int[nums.length];
    	int[] copy = new int[nums.length];
    	copy = Arrays.copyOf(nums, nums.length);
    	return reversePairs(copy,0,nums.length-1,temp);
    }
    
    private int reversePairs(int[] nums,int left,int right,int[] temp){
    	if(right<=left) return 0;//只有一个元素，不构成逆序
    	
    	int cnt = 0;
    	int mid = left+(right-left)/2;
    	
    	cnt += reversePairs(nums,left,mid,temp);
    	cnt += reversePairs(nums,mid+1,right,temp);
    	
    	if(nums[mid]<=nums[mid+1]) return cnt;//如果左半部分最大值比右半部分最小值，那么这一个区间也不存在逆序对
    	
    	for(int i=left;i<=right;i++)
    		temp[i] = nums[i];
    	int cur=left;//用来标记合并后数组的位置
    	int rightindex = mid+1;//用来标记右半部分的指针，左半部分的指针由left标记
    	
    	while(left<=mid && rightindex<=right){
    		if(temp[left]<=temp[rightindex])
    			nums[cur++] = temp[left++];
    		else{
    			nums[cur++] = temp[rightindex++];
    			cnt += mid-left+1;//当右半部分的元素插入时，该元素与左半部分的剩余每个元素构成逆序对
    		}
    	}
    	
    	while(left<=mid)
    		nums[cur++] = temp[left++];
    	while(rightindex<=right)
    		nums[cur++] = temp[rightindex++];
    	
    	return cnt;
    }
    
}
