package T_601_700;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class T697 {

	
//	给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
//	你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

//	遍历，hashmap存次数与起始位置，再遍历找最值
//	击败69%
    public int findShortestSubArray(int[] nums) {
    	Map<Integer, int[]> numMap = new HashMap<>();
    	
    	int len = nums.length;
    	for(int i=0;i<len;i++){
    		int temp = nums[i];
    		int[] pos;
    		if(numMap.containsKey(temp)){
    			pos = numMap.get(temp);
    			pos[0]++;//更新计数
    			pos[2]=i;//更新结束位置
    			//numMap.put(temp, pos);//这个地方不加这句话也可以，因为pos是个引用，修改后实际map中的值也改了
    		}else{
    			numMap.put(temp, new int[]{1,i,i});//[计数，起始位置，结束位置]
    		}
    	}
    	
    	int max=0;
    	int ans = Integer.MAX_VALUE;
    	for(int[] temp :numMap.values()){
    		if(temp[0]==max){
    			ans = Math.min(ans, temp[2]-temp[1]);
    		}else if(temp[0]>max){
    			max = temp[0];
    			ans = temp[2]-temp[1];
    		}
    	}

    	return ans+1;
    }
    
}
