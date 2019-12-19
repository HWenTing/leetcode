package T_1_100;

import java.util.LinkedList;
import java.util.List;

public class T78 {
	
//	给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//	说明：解集不能包含重复的子集。
	
//	第一反应是回溯
//	List<List<Integer>> ans;
//	int len;
//    public List<List<Integer>> subsets(int[] nums) {
//        ans = new LinkedList<>();
//        len = nums.length;
//        ans.add(new LinkedList<>());
//        for(int i=0;i<len;i++){
//        	flashback(nums,i,new LinkedList<>());
//        }
//        return ans;
//    }
//    
//    
//	private void flashback(int[] nums, int curpos,LinkedList<Integer> temp) {
//		temp.add(nums[curpos]);
//		ans.add(new LinkedList<>(temp));
//		curpos++;
//		for(int i=curpos;i<len;i++){
//			flashback(nums,i,temp);
//		}
//		temp.remove(temp.size()-1);
//	}
    
//    天呐还可以位运算，每个位置集合的每个元素，都有可以选或不选，用二进制和位运算，可以很好的表示。
//	不过对数组的长度有要求，比如32以内
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new LinkedList<>();
		
		for(int i=0;i<(1<<nums.length);i++){
			List<Integer> temp = new LinkedList<>();
			for(int k=0;k<nums.length;k++){
				if(((i>>k)&1)==1){
					temp.add(nums[k]);
				}
			}
			ans.add(temp);
		}
		return ans;
	}
	
//	还可以直接遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
	
	
}
