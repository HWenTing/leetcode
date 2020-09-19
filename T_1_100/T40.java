package T_1_100;

import java.util.*;

public class T40 {
//	给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//	candidates 中的每个数字在每个组合中只能使用一次。

//	只能使用一次 可以使用下标不停的向下递归
//	不重复可以通过判断 candidates[i]==candidates[i-1] 来处理
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
	        List<Integer> list=new ArrayList<Integer>();
	        //排序
	        Arrays.sort(candidates);
	        find(listAll,list,candidates,target,0);
	        
	        return listAll;
	    }
    public void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
    	//递归的终点
        if(target==0){
            listAll.add(tmp);
            return;
        } 
        if(num>=candidates.length || target<candidates[num]) return;
        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
        	if(i>num && candidates[i]==candidates[i-1]) continue;
        	
            //深拷贝
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,list,candidates,target-candidates[i],i+1);
        }
    } 
    
}
