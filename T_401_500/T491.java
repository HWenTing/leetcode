package T_401_500;
import java.util.*;
public class T491 {

//	给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
//	回溯 剪枝
	public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        helper(nums, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    // 确定一个在[cur,nums.length-1]范围内的数字, 如果找到这个数字, 那么就要递归的向下搜索
    private void helper(int[] nums, int cur, List<Integer> list, Set<List<Integer>> res) {
        if(list.size() >= 2) {
            List<Integer> newList = new ArrayList<>(list); // 由于list是由引用传递的，所以我们需要深拷贝一个新的List
            res.add(newList);
        }
        for(int i = cur; i < nums.length; i++) {
            if(list.size() == 0 || nums[i] >= list.get(list.size()-1)) {
                list.add(nums[i]);
                helper(nums, i+1, list, res);
                list.remove(list.size()-1);    //注意要回到初始的情况，保持递归的语义
            }
        }
    }
    
    
    
}
