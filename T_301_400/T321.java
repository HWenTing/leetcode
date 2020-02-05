package T_301_400;

public class T321 {

//	给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
//	现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
//	求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

//	速度击败67%  空间击败92%
	
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int len1 = nums1.length;
    	int len2 = nums2.length;
    	
    	int[] ans = new int[k];

    	for(int i=0;i<=len1;i++){//枚举两位数组分别选取的长度
    		int j = k-i;//nums2截取的长度
    		if(j>=0 && j<=len2){
    			int[] temp = mergeArray(subArray(nums1,i),subArray(nums2,j));
    			if(compare(ans,temp,k))//选取最大的
    				ans = temp;
    			    			
    		}
    	}
    	return ans;
    }
    
    //截取数组的最大子数组
    private int[] subArray(int[] nums,int k){
    	if(k==0) return new int[0];
    	
    	int[] ret = new int[k];
    	
    	int s =0;//标记上一个最大值的位置
    	for(int i=0;i<k;i++){
    		int pos = maxRange(nums,s,nums.length-k+i);
    		ret[i] = nums[pos];
    		s = pos+1;
    	}
    	return ret;
    }
    
    //获得数组某一范围内的最大值下标
    private int maxRange(int[] nums,int start,int end){
    	int max = -1;
    	int maxpos = start;
    	for(int i=start;i<=end;i++){
    		if(nums[i]>max){
    			max = nums[i];
    			maxpos = i;
    		}
    	}
    	return maxpos;
    }
    
//   双指针法合并数组
    private int[] mergeArray(int[] nums1, int[] nums2){
    	
    	if(nums1.length==0) return nums2;
    	else if(nums2.length==0) return nums1;
    	
    	int k = nums1.length + nums2.length;
    	int i=0;
    	int j=0;
    	
    	int[] ret = new int[k];
    	for(int c=0;c<k;c++){
    		ret[c] = bigger(nums1,i,nums2,j)?nums1[i++]:nums2[j++];
    		
    	}
     	return ret;
    }
    //判断数组大小
    private boolean bigger(int[] nums1,int i,int[] nums2,int j){
    	while(i<nums1.length && j<nums2.length && nums1[i]==nums2[j]){
    		i++;
    		j++;
    	}
    	
    	if(i==nums1.length) return false;
    	else if(j==nums2.length) return true;
    	else
    		return nums1[i]>nums2[j];
    	
    }
    
//    判断是否最大
    private boolean compare(int[] nums1,int[] nums2,int len){
    	for(int i=0;i<len;i++){
    		if(nums1[i]<nums2[i])
    			return true;
    		else if(nums1[i]>nums2[i])
    			return false;
    	}
    	return false;
    }
    
    
}
