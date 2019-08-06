package T_501_600;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class T503 {

//	给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
//	第一反应是哪就遍历两边呗。。。。
//	。。速度没想到还可以。。击败了78%
	
    public int[] nextGreaterElements(int[] nums) {
        
    	int len = nums.length;
        int []ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<len;i++){//第一遍
            ans[i]=-1;
        	while(!stack.empty() && nums[stack.peek()]<nums[i]){
        		int temp = stack.pop();
        		ans[temp] = nums[i];
        	}
        	stack.push(i);
        }
        
        for(int i=0;i<len;i++){//第二遍处理没处理过的
        	while(!stack.empty() && nums[stack.peek()]<nums[i]){
        		int temp = stack.pop();
        		ans[temp] = nums[i];
        	}
        }
        
        return ans;
    }
    
    
//    上边的两个for循环也可以写在一个里
//    public int[] nextGreaterElements(int[] nums) {
//    	int len = nums.length;
//    	int []ans = new int[len];
//    	Stack<Integer> stack = new Stack<>();
//    	Arrays.fill(ans, -1);
//    	
//    	for(int i=0;i<len*2;i++){
//    		int num = i%len;
//    		while(!stack.empty() && nums[stack.peek()]<nums[num]){
//    			int temp = stack.pop();
//    			ans[temp] = nums[num];
//    		}
//    		
//    		if(i<len)
//    			stack.push(i);
//    	}
//    	return ans;
//    }
}
