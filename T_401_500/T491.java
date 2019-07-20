package T_401_500;
import java.util.*;
public class T491 {

	public static void print(int[] nums){
		for(int i :nums){
			System.out.print(i+" ");
		}
	}
	
//    public static List<List<Integer>> findSubsequences(int[] nums) {
//    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
//
//    	int len = nums.length;
//    	
//    	for(int i=0;i<len-1;i++){
//    		List<Integer> temp = new ArrayList<Integer>();
//    		temp.add(nums[i]);
//    		dfs(ans,nums,i,temp);
//    	}
//    	return ans;
//    }
//    
//    public static void dfs(List<List<Integer>> ans,int[] nums,int pos,List<Integer> temp){
//    	if(pos>=nums.length-1){
//    		return;
//    	}
//    	if(temp.get(temp.size()-1) <=nums[++pos]){
//    		temp.add(nums[pos]);
//    		ans.add(new ArrayList<Integer>(temp));
//    		dfs(ans,nums,pos,temp);
//    		temp.remove(temp.size()-1);
//    		dfs(ans,nums,pos,temp);
//    	}else{
////    		dfs(ans,nums,pos,temp);
//    		
//    	}
//    	
//    }

	public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        helper(nums, 0, new ArrayList<>(), res);
        return new ArrayList<>(res);
    }

    // 确定一个在[cur,nums.length-1]范围内的数字, 如果找到这个数字, 那么就要递归的向下搜索
    private static void helper(int[] nums, int cur, List<Integer> list, Set<List<Integer>> res) {
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
    
    
    
    public static void main(String[] args){
    	int[] candidates = {4,6, 7, 7};
    	System.out.println(findSubsequences(candidates));
    }
    
    
}
