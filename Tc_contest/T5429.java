package Tc_contest;

import java.util.Arrays;

public class T5429 {

	
//	给你一个整数数组 arr 和一个整数 k 。
//
//	设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：
//
//	 |arr[i] - m| > |arr[j] - m|
//	 |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
//	请返回由数组中最强的 k 个值组成的列表。答案可以以 任意顺序 返回。
	
//	先排序找中位数 然后双指针两边找
    public int[] getStrongest(int[] arr, int k) {
    	Arrays.sort(arr);
    	int len = arr.length;
    	int m = arr[(len-1)/2];//就是这么规定的中位数
    	
    	int[] ans = new int[k];
    	
    	int left = 0;
    	int right = len-1;
    	int cnt = 0;
    	
    	while(cnt<k){
    		if(Math.abs(arr[left]-m)>Math.abs(arr[right]-m))
    			ans[cnt++] = arr[left++];
    		else
    			ans[cnt++] =arr[right--];
    	}
    	return ans;
    }
    
}
