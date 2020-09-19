package T_301_400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T315 {

//	给定一个整数数组 nums，按要求返回一个新数组 counts。
//	数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。

	
//	归并排序的思想 与T51类似
	private int[] copy,index,temp,tempindex,ans;
    public List<Integer> countSmaller(int[] nums) {
    	if(nums.length==0) return new ArrayList<>(nums.length);
    	copy = new int[nums.length];//原数组的复制
    	index = new int[nums.length];//存放当前位置的元素，一开始位于哪里
    	temp = new int[nums.length];
    	tempindex = new int[nums.length];
    	ans = new int[nums.length];
    	
    	for(int i=0;i<nums.length;i++) index[i]=i;
    	copy = Arrays.copyOf(nums, nums.length);

    	countSmaller(0,nums.length-1);
    	
    	List<Integer> ret = new ArrayList<>(nums.length);
    	for(int i:ans)
    		ret.add(i);
    	return ret;
    }

	private void countSmaller(int left, int right) {
		if(left==right) return;
		int mid = left+(right-left)/2;
		
		countSmaller(left,mid);
		countSmaller(mid+1,right);
		
		if(copy[mid]<=copy[mid+1]) return;
    	for(int i=left;i<=right;i++){
    		temp[i] = copy[i];
    		tempindex[i] = index[i];
    	}
    	int cur=left;//用来标记合并后数组的位置
    	int rightindex = mid+1;//用来标记右半部分的指针，左半部分的指针由left标记
    	
    	while(left<=mid && rightindex<=right){
    		if(temp[left]<=temp[rightindex]){
    			copy[cur] = temp[left];
    			index[cur++] = tempindex[left];
    			ans[tempindex[left++]]+=(rightindex-mid-1);
    		}else{
    			copy[cur] = temp[rightindex];
    			index[cur++] = tempindex[rightindex++];
    		}
    	}
    	
    	while(left<=mid){
    		copy[cur] = temp[left];
			index[cur++] = tempindex[left];
			ans[tempindex[left++]]+=(rightindex-mid-1);
    	}
    	while(rightindex<=right){
    		copy[cur] = temp[rightindex];
			index[cur++] = tempindex[rightindex++];
    	}
		
	}
    
	
	public static void main(String[] args) {
		T315 t = new T315();
		System.out.println(t.countSmaller(new int[]{5}));
	}
	
}
