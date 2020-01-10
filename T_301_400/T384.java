package T_301_400;

import java.util.Arrays;
import java.util.Random;

public class T384 {
	
//	打乱一个没有重复元素的数组。
	
//	Fisher-Yates 洗牌算法
//	在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。接下来，将当前元素和随机选出的下标所指的元素互相交换 
	
	Random rand = new Random();
	int[] original;
    public T384(int[] nums) {
        original = Arrays.copyOf(nums, nums.length);
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
    	return Arrays.copyOf(original, original.length);
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = Arrays.copyOf(original, original.length);
        int len = ret.length;
        
        for(int i=0;i<len;i++){
        	int t = random(i,len);
        	swap(ret,i,t);
        }
        return ret;
    }
    
    private int random(int start,int end){
    	return rand.nextInt(end - start) + start;
    }
    private void swap(int[] nums,int s,int t){
    	int temp = nums[t];
    	nums[t] = nums[s];
    	nums[s] = temp;
    }
    
}
