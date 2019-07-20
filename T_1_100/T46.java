package T_1_100;

import java.util.*;

public class T46 {

//    public  static boolean nextPermutation(int[] nums) {
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
//    			return true;
//    		}
//    	}
//    	if(!ischange)
//    		return false;
//    	return true;
//    }
//    
//    
//    public static List<List<Integer>> permute(int[] nums) {
//    	int len = nums.length;
//    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
//    	Arrays.sort(nums);
//    	List<Integer> temp = new ArrayList<Integer>();
//    	for(int i =0;i<len;i++){
//    		temp.add(nums[i]);
//    	}
//    	ans.add(temp);
//    	boolean con = true;
//    	
//    	while(con){
//    		
//    		con = nextPermutation(nums);
//    		
//    		temp = new ArrayList<Integer>();
//        	for(int i =0;i<len;i++){
//        		temp.add(nums[i]);
//        	}
//        	
//        	if(con)
//        		ans.add(temp);
//    	}
//    	return ans;
//    }
//    
	
//	要注意ArrayList深度复制问题
    public List<List<Integer>> permute(int[] nums) {
    	int n=nums.length;
    	List<List<Integer>> res = new ArrayList<>();
    	boolean[] marked = new boolean[n];
    	getItem(nums,marked,res,new ArrayList<>());
    	return res;
    }
    
    private void getItem(int[] nums,boolean[] marked,List<List<Integer>> res,List<Integer> temp){
    	if(temp.size()==nums.length){
    		res.add(new ArrayList<Integer>(temp));
    		return;
    	}
    	for(int i = 0;i<nums.length;i++){
    		if(!marked[i]){
    			marked[i]=true;
    			temp.add(nums[i]);
    			getItem(nums,marked,res,temp);
    			temp.remove(temp.size()-1);
    			marked[i]=false;
    		}
    	}
    }
    
    public static void main(String[] args){
    	int[] candidates = {1,2,3};
    	T46 t = new T46();
    	System.out.println(t.permute(candidates));
    }
    
}
