package T_1_100;

import java.util.*;

public class T39 {

	
	 public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
	        List<Integer> list=new ArrayList<Integer>();
	        //排序
	        Arrays.sort(candidates);
	        find(listAll,list,candidates,target,0);
	        return listAll;
	    }
    public static void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        //递归的终点
        if(target==0){
            listAll.add(tmp);
            return;
        } 
        if(target<candidates[num]) return;
        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
            //深拷贝
            List<Integer> list=new ArrayList<>(tmp);
            list.add(candidates[i]);
            //递归运算，将i传递至下一次运算是为了避免结果重复。
            find(listAll,list,candidates,target-candidates[i],i);
        }   
    } 
    
    
    public static void main(String[] args){
    	int[] candidates = {10,1,2,7,6,1,5};
    	int target = 8;
    	System.out.println(combinationSum(candidates,target));
    }
}
