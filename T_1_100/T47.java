package T_1_100;

import java.util.*;

public class T47 {

//	给定一个可包含重复数字的序列，返回所有不重复的全排列。
	
//	每次得到下一个排列
    public static List<List<Integer>> permuteUnique(int[] nums) {
    	int len = nums.length;
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	List<Integer> temp = new ArrayList<Integer>();
    	for(int i =0;i<len;i++){
    		temp.add(nums[i]);
    	}
    	ans.add(temp);
    	boolean con = true;
    	while(con){
    		con = nextPermutation(nums);
    		temp = new ArrayList<Integer>();
        	for(int i =0;i<len;i++){
        		temp.add(nums[i]);
        	}
        	
        	if(con)
        		ans.add(temp);
    	}
    	return ans;
    }
	
//	得到下一个序列
    public  static boolean nextPermutation(int[] nums) {
    	int len = nums.length;
    	boolean ischange=false;
    	for(int i =len-1;i>0;i--){
    		if(nums[i]>nums[i-1]){
    			Arrays.sort(nums, i, len);
    			for(int j=i;j<len;j++){
    				if(nums[j]>nums[i-1]){
    	    			int temp = nums[i-1];
    	    			nums[i-1] = nums[j];
    	    			nums[j]  = temp;
    	    			break;
    				}
    			}
    			Arrays.sort(nums, i, len);
    			ischange = true;
    			return true;
    		}
    	}
    	if(!ischange)
    		return false;
    	return true;
    }
    
    //回溯
//	private List<List<Integer>> ans;
//    public List<List<Integer>> permuteUnique(int[] nums) {
//    	ans = new LinkedList<>();
//    	Arrays.sort(nums);
//    	
//    	boolean[] marked = new boolean[nums.length];
//    	dfs(nums,marked,new LinkedList<>());
//    	return ans;
//    }
//    
//    private void dfs(int[] nums,boolean[] marked,LinkedList<Integer> cur){
//    	
//    	if(cur.size()==nums.length){
//    		ans.add(new LinkedList<>(cur));
//    		return ;
//    	}
//    	
//    	int before = -1;
//    	for(int i=0;i<nums.length;i++){
//    		if(marked[i] || (before>=0 &&nums[i]==nums[before]))
//    			continue;
//    		before = i;
//    		marked[i] = true;
//    		cur.add(nums[i]);
//    		dfs(nums,marked,cur);
//    		
//    		marked[i] = false;
//    		cur.remove(cur.size()-1);
//    	}
//    }
    
}
