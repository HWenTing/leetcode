package T_1_100;

import java.util.Arrays;

public class T31 {
//	实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//	如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//	必须原地修改，只允许使用额外常数空间。

//	求下一个字典序
//    public  void nextPermutation(int[] nums) {
//    	int len = nums.length;
//    	boolean ischange=false;
//    	for(int i =len-1;i>0;i--){
//    		if(nums[i]>nums[i-1]){
//    			Arrays.sort(nums, i, len);
//    			for(int j=i;j<len;j++){
//    				if(nums[j]>nums[i-1]){
//    	    			int temp = nums[i-1];
//    	    			nums[i-1] = nums[j];
//    	    			nums[j]  = temp;
//    	    			break;
//    				}
//    			}
//
//    			
//    			Arrays.sort(nums, i, len);
//    			ischange = true;
//    			break;
//    		}
//    	}
//    	if(!ischange)
//    		Arrays.sort(nums);
//        
//    }
	
    public void nextPermutation(int[] nums) {
        if(nums.length<=1) return ;
        int pos = nums.length-2;

        while(pos>=0){//找到最后一个nums[i]<nums[i+1]
            if(nums[pos]<nums[pos+1])
                break;
            pos--;
        }

        if(pos<0)
            Arrays.sort(nums);//可以直接倒叙
        else{
            Arrays.sort(nums,pos+1,nums.length);
            int temp = nums[pos];
            int arc = pos;
            while(++pos<nums.length){
                if(temp<nums[pos]){
                    nums[arc] = nums[pos];
                    nums[pos] = temp;
                    break;
                }
           }
        }
    }

    
    
}
