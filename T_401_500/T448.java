package T_401_500;

import java.util.LinkedList;
import java.util.List;

public class T448 {
	
//	给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
//	找到所有在 [1, n] 范围之间没有出现在数组中的数字。
//
//	不使用额外空间且时间复杂度为O(n)

//	不使用额外数组的话，可能就要更改本数组了
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> ans = new LinkedList<>();
    	for(int i=0;i<nums.length;i++){
    		int pos=nums[i]-1;
    		while(pos>=0 && nums[pos]>0){
//    			System.out.println(pos);
    			int next = nums[pos]-1;
    			nums[pos]=-1;
    			pos = next;
    		}
    	}
    	
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]>0){
    			ans.add(i+1);
    		}
    	}
    	System.out.println(ans);
    	return ans;
    }
    
    public static void main(String[] args){
    	T448 t = new T448();
    	int[] nums = new int[]{4,3,2,7,8,2,3,1};
    	t.findDisappearedNumbers(nums);
    	
    }
}
