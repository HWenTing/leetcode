package T_401_500;

import java.util.HashMap;
import java.util.Stack;

public class T496 {

//	不会
//  用栈和hashmap来做
//	先遍历一遍nums2，把每个元素对应的下一个最大元素存到hashmap中
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	int len = nums1.length;
        int []ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        
        for(int num:nums2){
        	while(!stack.empty() && num>stack.peek())
        		hashmap.put(stack.pop(), num);
        	stack.push(num);
        }
        
        for(int i=0;i<len;i++)
        	ans[i] = hashmap.getOrDefault(nums1[i], -1);
        
        return ans;
    }
    
    
}
